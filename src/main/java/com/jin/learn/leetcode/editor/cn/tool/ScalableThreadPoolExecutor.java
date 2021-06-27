package com.jin.learn.leetcode.editor.cn.tool;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class ScalableThreadPoolExecutor implements Executor, Scalable, Closeable {


    private final String executorName;
    private final ThreadPoolExecutor executor;
    private final Thread busyQueueMonitor;
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final ArrayBlockingQueue<Runnable> busyQueue;
    private final Condition notFull4Busy = lock.newCondition();

    private final AtomicLong completedTaskCount = new AtomicLong();
    private final AtomicLong completedSuccessTaskCount = new AtomicLong();

    private volatile ScalableThreadPoolDecisionMaker decisionMaker;
    private final int maxPoolSize;
    private volatile int currPoolSize;

    private volatile boolean working = true;


    public ScalableThreadPoolExecutor(final String executorName, final int poolSize, final int maxPoolSize,
                                      final int queueCapacity, final ThreadFactory threadFactory) {
        this.executorName = executorName;

        // always set maxSize=coreSize.
        executor = new InternalThreadPoolExecutor(poolSize, poolSize, Integer.MAX_VALUE, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(queueCapacity), threadFactory);
        currPoolSize = poolSize;
        this.maxPoolSize = maxPoolSize;
        this.busyQueue = new ArrayBlockingQueue<>(queueCapacity * 10);
        busyQueueMonitor = new Thread("Busy-Queue-Monitor-4-" + executorName) {
            @Override
            public void run() {
                super.run();

                for (; working; ) {
                    Runnable command = null;
                    try {
                        command = busyQueue.take();
                    } catch (InterruptedException e) {
                    }
                    if (command == null)
                        continue;

                    lock.lock();
                    try {
                        while (executor.getQueue().remainingCapacity() == 0) {
                            notFull4Busy.await();
                        }
                        executor.execute(command);
                    } catch (Exception e1) {
                        busyQueue.offer(command);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };
        busyQueueMonitor.setDaemon(true);
        busyQueueMonitor.start();


        Thread show= new Thread("monoitor" + executorName) {
            @Override
            public void run() {
                for (; working; ) {

                int corePoolSize = executor.getCorePoolSize();
                int maximumPoolSize = executor.getMaximumPoolSize();
                int poolSize = executor.getPoolSize();
                long taskCount = executor.getTaskCount();

                    try {
                        Thread.sleep(2_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                System.out.print("corePoolSize:"+corePoolSize);
                    System.out.print("maximumPoolSize:"+maximumPoolSize);
                    System.out.print("poolSize:"+poolSize);
                    System.out.println("taskCount:"+taskCount);

                }}
        };
        show.setDaemon(true);
        show.start();

    }

    public void setDecisionMaker(final ScalableThreadPoolDecisionMaker decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    @Override
    public void execute(final Runnable command) {
            executor.execute(command);
    }

    /**
     * Returns the approximate total number of tasks that have completed execution.
     * Because the states of tasks and threads may change dynamically during computation,
     * the returned value is only an approximation, but one that does not ever decrease across successive calls.
     * @return the number of tasks
     */
    public long getCompletedTaskCount() {
        return completedTaskCount.get();
    }
    /**
     * Returns the approximate total number of tasks that have completed execution successfully.
     * Because the states of tasks and threads may change dynamically during computation,
     * the returned value is only an approximation, but one that does not ever decrease across successive calls.
     * @return the number of tasks
     */
    public long getCompletedSuccessTaskCount() {
        return completedSuccessTaskCount.get();
    }

    @Override
    public void downgrade(final int percentage) {
        // currPoolsize=5, percentage=73, then newPoolSize should be 2
        int newPoolSize = (100 - percentage) * currPoolSize / 100 + ((100 - percentage) * currPoolSize % 100 > 0 ? 1 : 0);
        newPoolSize = Math.max(newPoolSize, 1);
        changePoolSize(newPoolSize);
    }

    private void changePoolSize(final int newPoolSize) {
        if (newPoolSize < currPoolSize) {
            executor.setCorePoolSize(newPoolSize);
            executor.setMaximumPoolSize(newPoolSize);
        } else {
            executor.setMaximumPoolSize(newPoolSize);
            executor.setCorePoolSize(newPoolSize);
        }
        currPoolSize = newPoolSize;
    }

    @Override
    public void upgrade(final int percentage) {
        // currSize=5, percentage=10, then newSize should be 6.
        int newPoolSize = (100 + percentage) * currPoolSize / 100;
        if (newPoolSize == currPoolSize) {
            newPoolSize++;
        }

        newPoolSize = Math.min(newPoolSize, maxPoolSize);
        changePoolSize(newPoolSize);
    }

    @Override
    public void failover() {
        changePoolSize(1);
    }

    @Override
    public int getThreadPoolSize() {
        return currPoolSize;
    }

    int getCurrPoolSize() {
        return currPoolSize;
    }

    /**
     * Check whether queue is full.
     * @return
     */
    public boolean isFull() {
        return executor.getQueue().remainingCapacity() == 0;
    }

    @Override
    public void close() throws IOException {
        working = false;
        busyQueueMonitor.interrupt();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {

        } finally {
            executor.shutdownNow();
        }
    }

    private class InternalThreadPoolExecutor extends ThreadPoolExecutor {

        public InternalThreadPoolExecutor(final int corePoolSize, final int maximumPoolSize, final long keepAliveTime,
                                          final TimeUnit unit, final BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        }

        public InternalThreadPoolExecutor(final int corePoolSize, final int maximumPoolSize, final long keepAliveTime,
                                          final TimeUnit unit, final BlockingQueue<Runnable> workQueue, final ThreadFactory threadFactory) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
        }

        public InternalThreadPoolExecutor(final int corePoolSize, final int maximumPoolSize, final long keepAliveTime,
                                          final TimeUnit unit, final BlockingQueue<Runnable> workQueue, final RejectedExecutionHandler handler) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
        }

        public InternalThreadPoolExecutor(final int corePoolSize, final int maximumPoolSize, final long keepAliveTime,
                                          final TimeUnit unit, final BlockingQueue<Runnable> workQueue, final ThreadFactory threadFactory,
                                          final RejectedExecutionHandler handler) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
        }

        @Override
        protected void beforeExecute(final Thread t, final Runnable r) {

            // only notify busy queue.
            lock.lock();
            try {
                notFull4Busy.signal();
            } finally {
                lock.unlock();
            }

            if (decisionMaker!=null) decisionMaker.beforeExecute(t, r);
        }

        @Override
        protected void afterExecute(final Runnable r, final Throwable t) {
            ScalableThreadPoolDecisionMaker.Result result = null;
            if (decisionMaker != null) {
                result = decisionMaker.afterExecute(r, t);
            }

            completedTaskCount.incrementAndGet();
            if (result == null || ScalableThreadPoolDecisionMaker.Result.SUCCESS == result) {
                completedSuccessTaskCount.incrementAndGet();
            }

            if (ScalableThreadPoolDecisionMaker.Result.BUSY == result) {
                busyQueue.add(r);
                dealBusy();
            }

            lock.lock();
            try {
                // notify busy queue first.
                notFull4Busy.signal();
                notFull.signal();
            } finally {
                lock.unlock();
            }
        }

        private void dealBusy() {
            // harden the retry-after with 1 seconds.
            // FIXME: (Pollin) get new design about how long next retry happen to avoid this hard-code 1 second delay.
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // no action to take.
            }
        }
    }
}
