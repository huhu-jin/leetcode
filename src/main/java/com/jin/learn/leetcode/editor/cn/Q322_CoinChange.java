//  [322]零钱兑换

//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 广度优先搜索 数组 动态规划 
// 👍 1399 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Arrays;


public class Q322_CoinChange{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // dp 这题是 从前面的 某个状态推到 当前状态
    // 不是斐波那契 当前状态是 直接由前面两个推的
    // dp[n] =  min(dp[n-coins[i]])+1 迭代左右的硬币
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int temp = Integer.MAX_VALUE;
            for (int j = coins.length - 1; j >= 0; j--) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] >= 0) {
                    temp = Math.min(dp[i - coins[j]] + 1, temp); // 递推关系
                }
            }
            if (temp == Integer.MAX_VALUE) {
                dp[i] = -1;
            }else {
                dp[i] = temp;
            }
        }
        return dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().coinChange(new int[]{186,419,83,408}, 6249);
    }
  
}
