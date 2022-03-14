package com.jin.learn.template;

import org.testng.annotations.Test;

public class HeapSort {


    // 用数组 表示 一颗完全二叉树 具有以下特性.通过当前node i可以计算出父节点和子节点
    // parent = (i-1)/2
    // 左儿子= (i * 2) + 1;
    // 右儿子 = (i * 2) + 2;

    public void sort(int[] nums) {
        buildHeap(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            // 交换 顶节点(最大) 和 尾巴节点
            swap(nums, 0, i);
            maxHeapify(nums, 0, i);
        }
    }

    public void buildHeap(int[] nums){
        // 从最后一个子节点 的父节点开始 从低先上做 maxHeapify
        for (int i = nums.length / 2 -1; i >= 0; i--) {
            maxHeapify(nums, i, nums.length);
        }
    }


    // 从顶到底  递归Heapify (最大值在root节点) 打定对
    public void maxHeapify(int[] trees, int root, int len) {
        int l = (root * 2) + 1; // 左儿子
        int r = (root * 2) + 2; // 右儿子

        int max = root;

        if (l < len && trees[l] > trees[max]) { // 防止 越界
            max = l;
        }

        if (r < len && trees[r] > trees[max]) {
            max = r;
        }

        if (max != root) {
            swap(trees, root, max);
            maxHeapify(trees, max, len);
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    @Test
    public void testCase(){
        int[] temp = new int[]{5, 3, 7, 5,6,6,7,4, 6, 8, 2, 9, 1};
        new HeapSort().sort(temp);
        System.out.println("dddd");
    }

}
