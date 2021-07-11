//  [剑指 Offer 63]股票的最大利润

//假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？ 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 10^5 
//
// 
//
// 注意：本题与主站 121 题相同：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-s
//tock/ 
// Related Topics 数组 动态规划 
// 👍 131 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.Assert;
import org.testng.annotations.Test;


public class GuPiaoDeZuiDaLiRunLcof{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
    // 动态规划
    // 递推公式 前i日最大利润=max(前(i−1)日最大利润,第i日价格−前i日最低价格)
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length==0) return 0;
        int [] dp = new int [prices.length];
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - getmin(prices, i - 1));
        }
        return dp[dp.length - 1];
    }

        private int getmin(int[] prices, int pos) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i <= pos; i++) {
                min = Math.min(prices[i], min);
            }
            return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        Assert.assertEquals(new Solution().maxProfit(new int[]{1, 2}),1);
    }
  
}