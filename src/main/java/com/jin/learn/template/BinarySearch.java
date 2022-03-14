package com.jin.learn.template;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.Arrays;

// https://www.youtube.com/watch?v=j2_JW3In9PE&list=PLV5qT67glKSErHD66rKTfqerMYz9OaTOs&index=3
public class BinarySearch {


    // 查找精确值
    // 循环条件 l<=r
    // 收缩空间 l = mid +1 , r = mid-1
    public int search(int[] arrays, int target) {
        if (arrays == null) return -1;
        Arrays.sort(arrays);

        int l = 0;
        int r = arrays.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arrays[mid] < target) {
                l = mid + 1;
            } else if (arrays[mid] > target) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // 查找模糊值(比4大的最小数)
    // l< r
    // 收缩空间 l = mid +1 , r = mid 或者 l = mid , r = mid-1
    public int search1(int[] arrays, int target) {
        if (arrays == null) return -1;
        Arrays.sort(arrays);

        int l = 0;
        int r = arrays.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arrays[mid] < target) {
                l = mid +1 ;
            } else  {
                r = mid ;
            }
        }
        return l;
    }


    // 万用型 最接近k
    // l<r-1
    // l = mid, r = mid
    public int search2(int[] arrays, int target) {
        if (arrays == null) return -1;
        Arrays.sort(arrays);

        int l = 0, r = arrays.length - 1;
        while (l < r-1) {
            int mid = (l + r) / 2;
            if (arrays[mid] < target) {
                l = mid;
            } else  {
                r = mid ;
            }
        }

        if (arrays[r] < target) {
            return r;
        } else if (arrays[l] > target) {
            return l;
        }else {
            return target - arrays[l] < arrays[r] - target ? l : r;
        }
    }




    @Test
    public void testCase() {
        int exist = new BinarySearch().search(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 6);
        Assert.assertEquals(exist,5);
        int exist1 = new BinarySearch().search(new int[]{1, 2, 3, 4, 6, 7, 8, 9}, 5);
        Assert.assertEquals(exist1,-1);
        int exist2 = new BinarySearch().search(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 10);
        Assert.assertEquals(exist2,-1);
    }


    @Test
    public void testCase1() {
        int exist = new BinarySearch().search1(new int[]{1, 1, 2 , 2, 2 , 6, 7}, 2);
        Assert.assertEquals(exist,2);
        int exist1 = new BinarySearch().search1(new int[]{1, 1, 2 , 2, 2 , 6, 7}, 8);
        Assert.assertEquals(exist1,6);

    }


}
