package com.jin.learn.leetcode.editor.cn.tool;

import com.google.common.base.MoreObjects;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstractScalableThreadPoolDecisionMaker implements ScalableThreadPoolDecisionMaker {


    private final Scalable scalable;

    private final Map<Thread, ThreadStatus> threadStatuses = new ConcurrentHashMap<>();
    private final Set<Thread> inProgressThreads = new HashSet<>();
    private final Set<Thread> doneThreads = new HashSet<>();
    private final Set<Thread> runningThreads = new HashSet<>();
    /** how many tasks executed before evaluation. */
    private volatile int executionTimesPerThread = 10;

    /** upgrade percentage per time. */
    private volatile int upgradePctPerTime = 20;

    /** min cycle to evaluate like downgrade/upgrade. unit: seconds. */
    private volatile int evaluationCycle = 15;

    /** threshold for busy, percentage. */
    private volatile int busyPct = 20;
    /** threshold for error, percentage. */
    private volatile int errorPct = 80;


    private volatile int times;
    private volatile long time4success, time4error, time4busy;
    private volatile long started;


    public AbstractScalableThreadPoolDecisionMaker(final Scalable scalable) {
        this.scalable = scalable;
    }

    enum Action {
        KEEP,
        UPGRADE,
        DOWNGRADE,
        FAILOVER;
    }

    @Override
    public synchronized void beforeExecute(final Thread t, final Runnable r) {
        if (!isCountable())
            startCounting();

        startHandling(t, r);
    }

    private void startHandling(final Thread t, final Runnable r) {
        final ThreadStatus threadStatus = getThreadStatus(t);
        runningThreads.add(t);

        threadStatus.startHandling();
        if (threadStatus.submittedCount.get() < executionTimesPerThread)
            inProgressThreads.add(t);
    }


    @Override
    public synchronized Result afterExecute(final Runnable r, final Throwable t) {

        final Thread currentThread = Thread.currentThread();
        final ThreadStatus threadStatus = getThreadStatus(currentThread);

        final long handlingTime = threadStatus.doneTask();
        final Result result = checkResult(r, t);
        times++;

        switch (result) {
            case SUCCESS:
                time4success += handlingTime;
                break;
            case ERROR:
                time4error += handlingTime;
                break;
            case BUSY:
                time4busy += handlingTime;
                break;
        }

        if (!threadStatus.isCountable()) {
            return result;
        }

        if (threadStatus.completedCount.get() >= executionTimesPerThread) {
            inProgressThreads.remove(currentThread);
            doneThreads.add(currentThread);
        }

        makeDecision();
        runningThreads.remove(currentThread);


        return result;
    }

    /**
     * check result of execution of task.
     * @param r
     * @param t
     * @return
     */
    protected abstract Result checkResult(final Runnable r, final Throwable t);

    /**
     * set the min cycle before evaluation. Unit: ms.
     * @param evaluationCycle
     */
    public void setEvaluationCycle(final int evaluationCycle) {
        this.evaluationCycle = evaluationCycle;
    }

    /**
     * set how many tasks executed before evaluation.
     * @param executionTimesPerThread
     */
    public void setExecutionTimesPerThread(final int executionTimesPerThread) {
        this.executionTimesPerThread = executionTimesPerThread;
    }


    private void makeDecision() {
        // must have enough samples or run over evaluationCycle.
        final long duration = System.currentTimeMillis() - started;
        /* all tasks are done or the ratio of done vs in-progress > 9:1 (sometimes some threads are starvation) */
        final boolean almostDone = inProgressThreads.isEmpty() || doneThreads.size() / inProgressThreads.size() >= 9;
        if (!almostDone && !(duration >= evaluationCycle * 1000)) {
            return;
        }

        final long timeSummary = time4busy + time4success + time4error;
        if (timeSummary==0) {
            doReset();
            return;
        }

        final long currErrPct = time4error * 100 / timeSummary;
        if (currErrPct >= errorPct) {
            scalable.failover();
            doReset();
            return;
        }

        // more than 80% threads are running and no busy response.
        if (time4busy==0 && runningThreads.size()>=(80*scalable.getThreadPoolSize()/100)) {
            scalable.upgrade(upgradePctPerTime);
            doReset();
            return;
        }

        // use handled time instead times to calculate percentage.
        final long currBusyPct = time4busy * 100 / timeSummary;
        if (currBusyPct >= busyPct) {
            scalable.downgrade((int) currBusyPct);
            doReset();
            return;
        }

        doReset();
    }

    private void resetThreadStatuses() {
        final Iterator<ThreadStatus> iterator = threadStatuses.values().iterator();
        while (iterator.hasNext()) {
            final ThreadStatus ts = iterator.next();
            // remove unused item or item whose last submitted task is more than 5 minutes.
            if (ts.lastSubmitted == 0 || System.currentTimeMillis()-ts.lastSubmitted > 300000) {
                iterator.remove();
                continue;
            }

            ts.reset();
        }

        inProgressThreads.clear();
        doneThreads.clear();
        runningThreads.clear();
    }

    private void startCounting() {
        if (isCountable())
            return;

        doReset();
    }

    private void doReset() {
        started = System.currentTimeMillis();

        times=0;
        time4success = time4error = time4busy = 0;

        resetThreadStatuses();

    }

    private boolean isCountable() {
        return started != 0;
    }

    private ThreadStatus getThreadStatus(final Thread thread) {
        final Thread t = MoreObjects.firstNonNull(thread, Thread.currentThread());
        ThreadStatus threadStatus = threadStatuses.get(t);
        if (threadStatus == null) {
            threadStatus = new ThreadStatus();
            threadStatuses.put(t, threadStatus);
        }
        return threadStatus;
    }

    private static class ThreadStatus {

        private final AtomicInteger submittedCount = new AtomicInteger(0);
        private final AtomicInteger completedCount = new AtomicInteger(0);
        private volatile long taskStarted;
        private volatile long lastSubmitted;
        private volatile boolean countable;

        void startHandling() {
            enableCounting();
            submittedCount.getAndIncrement();
            taskStarted = System.currentTimeMillis();
            lastSubmitted = taskStarted;
        }

        long doneTask() {
            completedCount.getAndIncrement();
            final long duration = System.currentTimeMillis() - taskStarted;
            taskStarted = 0;
            return duration;
        }

        void reset() {
            // discarded=true means this in-progress task should not be aggregated.
            disableCounting();
            submittedCount.set(0);
            completedCount.set(0);
        }

        boolean isCountable() {
            return countable;
        }

        private void disableCounting() {
            countable = false;
        }

        synchronized private void enableCounting() {
            countable = true;
        }
    }
}