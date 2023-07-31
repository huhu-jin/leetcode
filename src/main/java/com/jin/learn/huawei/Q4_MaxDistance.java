package com.jin.learn.huawei;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Q4_MaxDistance {


    public static class Node{

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
        int left;
        int right;
    }


    public int solution(int n, int[] seats) {
        // 用优先队列 来存储空位
        PriorityQueue<Node> nodes = new PriorityQueue<>((i, j) -> {
            int length = (i.right - i.left) - (j.right - j.left);
            if (length == 0) {
                return i.left - j.left;
            }
            return length;
        });


        Node node = new Node(Integer.MIN_VALUE, Integer.MAX_VALUE);
        nodes.add(node);

        int preIndex=0 ;
        for (int i : seats) {

            if (i == 1) {
                Node largestNode = nodes.poll();
                if (largestNode.left == Integer.MIN_VALUE) {
                    largestNode.left = 0;
                    nodes.add(largestNode);
                    preIndex=0;
                } else if (largestNode.right == Integer.MAX_VALUE) {
                    largestNode.right = n - 1;
                    nodes.add(largestNode);
                    preIndex =n-1;
                } else {
                     preIndex = largestNode.left + Math.round((largestNode.right - largestNode.left) / 2);
                    Node leftNode = new Node(largestNode.left, preIndex);
                    Node rightNode = new Node(preIndex, largestNode.right);
                    nodes.add(leftNode);
                    nodes.add(rightNode);
                }
            } else if (i < 0) {
                int newLeft = Integer.MIN_VALUE;
                int newRight = Integer.MAX_VALUE;
                Iterator<Node> iterator = nodes.iterator();
                while (iterator.hasNext()) {
                    Node next = iterator.next();
                    if (next.left == (-i)) {
                        newRight = next.right;
                        iterator.remove();
                    }else if (next.right == (-i)) {
                        newLeft = next.left;
                        iterator.remove();
                    }

                }
                Node newNode = new Node(newLeft, newRight);
                nodes.add(newNode);
            }else {
                throw new RuntimeException("invalid input");
            }





        }

        return preIndex;


    }


}
