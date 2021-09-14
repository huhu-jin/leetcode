//  [1058]最小化舍入误差以满足目标

//给定一系列价格 [p1,p2...,pn] 和一个目标 target，将每个价格 pi 舍入为 Roundi(pi) 以使得舍入数组 [Round1(p1)
//,Round2(p2)...,Roundn(pn)] 之和达到给定的目标值 target。每次舍入操作 Roundi(pi) 可以是向下舍 Floor(pi) 
//也可以是向上入 Ceil(pi)。 
//
// 如果舍入数组之和无论如何都无法达到目标值 target，就返回 -1。否则，以保留到小数点后三位的字符串格式返回最小的舍入误差，其定义为 Σ |Round
//i(pi) - (pi)|（ i 从 1 到 n ）。 
//
// 
//
// 示例 1： 
//
// 输入：prices = ["0.700","2.800","4.900"], target = 8
//输出："1.000"
//解释： 
//使用 Floor，Ceil 和 Ceil 操作得到 (0.7 - 0) + (3 - 2.8) + (5 - 4.9) = 0.7 + 0.2 + 0.1 
//= 1.0 。
// 
//
// 示例 2： 
//
// 输入：prices = ["1.500","2.500","3.500"], target = 10
//输出："-1"
//解释：
//达到目标是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 500 
// 表示价格的每个字符串 prices[i] 都代表一个介于 0 和 1000 之间的实数，并且正好有 3 个小数位。 
// target 介于 0 和 1000000 之间。 
// 
// Related Topics 贪心 数组 数学 字符串 
// 👍 27 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;


public class MinimizeRoundingErrorToMeetTarget{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 将浮点分为整数 和 小数部分 因为无论如何去round这个数，都是对小数部分进行操作。
    // 所以，我们将target 减掉整数部分的和，更新target.
    // [0.123,0.456,0.122,0.870], target = 2
    // 挑选最大的 前面几个小数 去变成1
    // 剩下 小数相加就是答案

    public String minimizeError(String[] prices, int target) {
        int intSum = 0;
        double [] db = new double[prices.length];
        int count =0;
        for (int i = 0; i < prices.length; i++) {
            double temp = Double.parseDouble(prices[i]);
            int tempInt = (int) Math.floor(temp);
            intSum += tempInt;
            if(tempInt != temp)
                ++count; // 可变动
            db[i] = temp -tempInt;
        }
        // 不可能的条件
        // ["1.500","2.500","3.500"]  5  target 太小
        // ["1.500","2.500","3.500"]  10 target 太大
        if (intSum > target || target > intSum + count) {
            return "-1";
        }
        target -= intSum;
        Arrays.sort(db);

        double ans=0;
        for (int i =0; i < prices.length; i++) {
            if (i >= prices.length - target) {
                ans += 1- db[i];
            }else {
                ans += db[i];
            }

        }
        return String.format("%.3f", ans);
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().minimizeError(new String[]{"0.700", "2.800", "4.900"}, 8);
    }
  
}