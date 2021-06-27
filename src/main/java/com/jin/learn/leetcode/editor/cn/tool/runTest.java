package com.jin.learn.leetcode.editor.cn.tool;

import com.jin.learn.leetcode.editor.cn.common.ListNode;

import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class runTest {

    public static void buyJob() throws InterruptedException {
        System.out.println("start: "+System.currentTimeMillis());

        Thread.sleep(1000);
        for(int i=0; i<200_0000_000L; i++ ){

        }
        System.out.println("end: "+System.currentTimeMillis());

    }

    public static class Task implements Runnable{

        private final int name;

        public  Task(int name){
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("run in task now !!!" + name );
            try {
                buyJob();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("finish tasking" + name);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 10, 2, TimeUnit.SECONDS, new LinkedBlockingDeque<>(4));
        for (int i = 0; i<10 ; i++) {
            System.out.println("put task: " + i);
            threadPoolExecutor.submit(new Task(i));
        }
        System.out.println("start: shutdown");
        threadPoolExecutor.shutdownNow();
        System.out.println("end: shutdown");
    }

}
