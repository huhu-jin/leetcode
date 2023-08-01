package com.jin.learn.huawei;

import org.testng.annotations.Test;

import java.util.PriorityQueue;
import java.util.StringJoiner;

public class Q7_Printer {

    static class Node{

        int priority;
        int index;

        public Node(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }


    public String solution(int[] tasks) {


        PriorityQueue<Node> nodes = new PriorityQueue<>((i, j) -> j.priority - i.priority);
        for (int i = 0; i < tasks.length; i++) {
            nodes.add(new Node(tasks[i], i));
        }
        StringJoiner stringBuilder = new StringJoiner(",");

        while (!nodes.isEmpty()) {
            stringBuilder.add(String.valueOf(nodes.poll().index));
        }

        return stringBuilder.toString();

    }



    @Test
    public void test() {
        System.out.println(solution(new int[]{1, 2, 3, 4, 5}));
    }




}
