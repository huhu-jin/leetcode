package com.jin.learn.leetcode.editor.cn.common;

import com.jin.learn.leetcode.editor.cn.ConvertBinarySearchTreeToSortedDoublyLinkedList;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node random;



    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
