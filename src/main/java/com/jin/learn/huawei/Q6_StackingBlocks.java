package com.jin.learn.huawei;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 题目描述
 * 有一堆长方体积木，它们的高度和宽度都相同，但长度不一
 * 小橙想把这堆积木成一面墙，墙的每层可以放一个积木，也可以将两个积木拼接起来，要求每层的长度相同
 * 着必须用完这些积木，叠成的最多为多少层？
 * 如下是叠成的一面墙的图示，积木仅按宽和高所在的面进行拼接，
 * 高长宽
 * 输入描述
 * 输入为一行，为各个积木的长度，数字为正整数，并由空格分隔。积木的数量和长度都不超过5000。
 * 输出描述
 * 输出一个数字，为墙的最大层数，如果无法按要求叠成每层长度一致的墙，则输出1
 * 用例
 * 输入
 * 36333
 * 输出3说明以0为底的，第一层为0，第二层为3+3，第三层3+3
 * 输入9995322222
 * 输出5
 */
public class Q6_StackingBlocks {


    public int solution(Integer[] arrays) {
        Arrays.sort(arrays);

        int min = arrays[arrays.length - 1];

        int sum = 0;
        for (int i = 0; i < arrays.length; i++) {
            sum += arrays[i];
        }
        int max = sum / 2;

        int i = min;

        for (; i <= max; i++) {

            if (sum % i != 0) continue;

            int subSum = sum / i;

            if (partition(new LinkedList<>(Arrays.asList(arrays)), 0, new int[i], subSum)) {
                return i;
            }


        }



        return -1;
    }

    // 回溯法
    // links 从大到小排列
    // buckets 临时存储 入选的值
    public static boolean partition(LinkedList<Integer> link, int index, int[] buckets, int subSum) {
        if (index == link.size()) return true;


        int selected = link.get(index);

        for (int i=0; i< buckets.length; i++){
            if(i>0 && buckets[i] == buckets[i-1]) continue;
            if (selected + buckets[i] <= subSum){
                buckets[i] += selected;
                if (partition(link, index+1, buckets, subSum)) return true;
                buckets[i] -= selected;
            }
        }


        return false;


    }

    @Test
    public void test() {
        System.out.println(solution(new Integer[]{3, 6, 3, 3, 3}));

        partition(new LinkedList<>(Arrays.asList(8,7,5,4,2,1,1,1,1)), 0, new int[3], 10);
    }


}
