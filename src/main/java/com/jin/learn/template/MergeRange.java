package com.jin.learn.template;

import java.util.Arrays;

public class MergeRange {


    // 比如开始会议 [1,10], [2,14], [10,23]
    // 一个人最多能参加 几个会议
    public void solution(){

        int[][] ranges = new int[10][10];

        Arrays.sort(ranges, (a,b) -> a[1] - b[1]);

        int t = ranges[0][1];

        int ans =1;

        for (int i = 1; i < ranges.length; i++) {


            int l = ranges[i][0];
            int r = ranges[i][1];

            if (l > t){ // 如果有间隔 l -t > 间隔
                ans ++;
                t =r;
            }
        }


        System.out.println(ans);
    }
}
