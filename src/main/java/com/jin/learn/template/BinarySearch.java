package com.jin.learn.template;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.Arrays;

// https://www.youtube.com/watch?v=j2_JW3In9PE&list=PLV5qT67glKSErHD66rKTfqerMYz9OaTOs&index=3
public class BinarySearch {


    // 查找精确值
    // 循环条件 l<=r
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

    // 求 >= target 的地一个 如 1,2,3,3,4,5,5,  target =3  index=2
    // 不存在返回 数组长度
    public int search1(int[] arrays, int target) {
        int l = 0;
        int r = arrays.length - 1; // 左闭右闭
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arrays[mid] < target) {
                l = mid +1 ;
            } else  {
                r = mid-1 ;
            }
        }
        return l;
    }



    // (红)r l(蓝)
    // 左闭 右开
    public int search2(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] >  target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
    // rl 在一起 蓝开始


    public int search3(int[] nums, int target) {
        int n = nums.length;
        int l = -1, r = n; // 左开 右开
        while (l +1 < r) {
            int mid =(l + r) / 2;
            if (nums[mid] > target) r = mid;
            else l = mid;
        }
        return r;
    }
    // l(红) r(蓝)


    // https://www.bilibili.com/video/BV1d54y1q7k7/?spm_id_from=333.337.search-card.all.click
    public int binarySearch(int[] nums,int target) {
        int l =-1;
        int r = nums.length;
        while (l +1 < r) {
            int mid = (r-l)/2 + l;
            if (isRed()) { // 这里根据条件 修改
                l = mid  ;
            } else {
                r = mid;
            }
        }
        return l;

    }

    private boolean isRed() {
        return false;
    }


    @Test

    public void  test12312(){

        int i = binarySearch(new int[]{1, 2, 3, 5, 5, 5, 8, 9}, 5);
        System.out.println(i);
    }






    // 红 小 蓝大
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


        int exist2 = new BinarySearch().search1(new int[]{2, 2, 2 , 2, 2 , 6, 7}, 1);
        Assert.assertEquals(exist2,7);


        int exist = new BinarySearch().search1(new int[]{1, 1, 3 , 3, 3 , 6, 7}, 2);
        Assert.assertEquals(exist,2);
        int exist1 = new BinarySearch().search1(new int[]{1, 1, 2 , 2, 2 , 6, 7}, 8);
        Assert.assertEquals(exist1,7);
    }


}
