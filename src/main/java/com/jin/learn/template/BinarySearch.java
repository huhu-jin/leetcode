package com.jin.learn.template;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class BinarySearch {


    public boolean isExist(int[] arrays, int target) {
        if (arrays == null) return false;
        Arrays.sort(arrays);

        int left = 0;
        int right = arrays.length-1;
        // 取到相等
        // p 加减1
        while (left <= right) {
            int p = (left + right) / 2;
            if(arrays[p] < target){
                left = p +1;
            }else if (arrays[p] > target){
                right = p -1;
            }else {
                return true;
            }
        }
        return false;
    }

    // 找到比他大 最进的数
    public int findNearest(int[] arrays, int target) {
        if (arrays == null) return -1;
        Arrays.sort(arrays);

        int left = 0;
        int right = arrays.length-1;

        int p =0;
        while (left <= right) {
             p = (left + right) / 2;
            if(arrays[p] < target){
                left = p +1;
            }else if (arrays[p] > target){
                right = p -1;
            }else {
                return arrays[p]; // 相等
            }
        }

        // 没有相等的
        while (p + 1 < arrays.length - 1 && Math.abs(arrays[p] - target) > Math.abs(arrays[p + 1] - target)) {
            p++;
        }
        return arrays[p];
    }


    @Test
    public void testCase (){
        boolean exist = new BinarySearch().isExist(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 6);
        Assert.assertTrue(exist);
        boolean exist1 = new BinarySearch().isExist(new int[]{1, 2, 3, 4, 6, 7, 8, 9}, 5);
        Assert.assertFalse(exist1);
        boolean exist2 = new BinarySearch().isExist(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 10);
        Assert.assertFalse(exist2);
    }


    @Test
    public void testCase2 (){
        int v = new BinarySearch().findNearest(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 6);
        Assert.assertEquals(6, v);

         v = new BinarySearch().findNearest(new int[]{1, 2, 3, 4, 6, 7, 8, 9}, 5);
        Assert.assertEquals(6, v);


    }


}
