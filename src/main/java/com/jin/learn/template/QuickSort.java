package com.jin.learn.template;

import org.testng.annotations.Test;

public class QuickSort {

    public  void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private  void sort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            sort(arr, low, p - 1);
            sort(arr, p + 1, high);
        }
    }


    private  int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {

            while (low < high && arr[high] >= pivot) {
                high--; //在高位 找 小的
            }
            arr[low] = arr[high];

            while (low < high && arr[low] <= pivot){
                low++; //在低位 找 大的
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }


    @Test
    public void testCase(){
        new QuickSort().sort(new int[]{5, 3, 7, 4, 6, 8, 2, 9, 1});
    }
}
