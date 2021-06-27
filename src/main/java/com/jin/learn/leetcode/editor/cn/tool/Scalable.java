package com.jin.learn.leetcode.editor.cn.tool;

public interface Scalable {

    /**
     * Notify pool to downgrade.
     * @param percentage
     */
    void downgrade(final int percentage);

    /**
     * Notify pool to upgrade.
     * @param percentage
     */
    void upgrade(final int percentage);

    /**
     * Notify pool to failover.
     */
    void failover();

    /**
     * get pool size.
     * @return
     */
    int getThreadPoolSize();

}
