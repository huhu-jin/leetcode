package com.jin.learn.huawei;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;

public class DrinkingWater {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String value = in.next();
            System.out.println(solution(Integer.parseInt(value)));
        }
    }


    public static int solution(int count){

        int [] dp = new int[101];

        dp[0] = 0;
        dp[1] = 0;
        dp[2] =1;

        if (count<=2) return dp[count];
        for(int i =3;i<=count;i++){
            dp[i]= dp[i/3+ i%3] + i/3;
        }
        return dp[count];

    }

    @Test
    public void testCase(){
        Assert.assertEquals(0,solution(0));
        Assert.assertEquals(0,solution(1));
        Assert.assertEquals(1,solution(2));
        Assert.assertEquals(1,solution(3));
        Assert.assertEquals(2,solution(4));
        Assert.assertEquals(2,solution(5));
        Assert.assertEquals(5,solution(10));
        Assert.assertEquals(40,solution(81));







    }
}
