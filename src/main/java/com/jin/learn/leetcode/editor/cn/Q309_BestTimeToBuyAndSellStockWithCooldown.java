//  [309]最佳买卖股票时机含冷冻期

//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 数组 动态规划 
// 👍 842 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q309_BestTimeToBuyAndSellStockWithCooldown{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 多状态的dp
    //dp[i][0]表示第i天交易完后无股票 利润，
    //dp[i][1]表示第i天交易完后有股票 利润
    //无股票：要么是今天本身没有股票,dp[i][0]=dp[i-1][0],要么就是今天卖出股票后导致没有股票，dp[i][0]=dp[i-1][1]+prices[i]，
    // 要么就是今天是冷冻期，那么就是昨天卖出了股票导致没有股票dp[i][0]=dp[i-1][0]，所以dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
    //有股票，要么是昨天有股票，dp[i][1]=dp[i-1][1]；要么是今天买入，那么昨天一定不能卖出股票dp[i][1]=dp[i-2][0]-prices[i]
    //所以dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
    //
    public int maxProfit(int[] prices) {

            if(prices.length <= 1) return 0;

            int[][] dp = new int[prices.length][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0]; // 买入的价格
            dp[1][0] = Math.max(dp[0][0],dp[0][1]+prices[1]);
            dp[1][1] = Math.max(dp[0][1],dp[0][0]-prices[1]); // 买入的价格

            for(int i = 2; i < prices.length; i ++) {
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
                dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
            }
            return dp[prices.length-1][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
