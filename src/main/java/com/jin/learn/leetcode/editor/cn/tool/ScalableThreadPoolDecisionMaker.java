package com.jin.learn.leetcode.editor.cn.tool;

public interface ScalableThreadPoolDecisionMaker {

    /**
     * call it prior to executing Task {@code r} on Thread {@code t}.
     * @param t
     * @param r
     */
    void beforeExecute(Thread t, Runnable r);

    /**
     * check the result of execution of task.
     * @param r
     * @param t
     */
    Result afterExecute(final Runnable r, final Throwable t);


    enum Result {
        SUCCESS,
        ERROR,
        BUSY;
    }
}
