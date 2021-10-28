//  [1230]抛掷硬币

//有一些不规则的硬币。在这些硬币中，prob[i] 表示第 i 枚硬币正面朝上的概率。 
//
// 请对每一枚硬币抛掷 一次，然后返回正面朝上的硬币数等于 target 的概率。 
//
// 
//
// 示例 1： 
//
// 输入：prob = [0.4], target = 1
//输出：0.40000
// 
//
// 示例 2： 
//
// 输入：prob = [0.5,0.5,0.5,0.5,0.5], target = 0
//输出：0.03125
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prob.length <= 1000 
// 0 <= prob[i] <= 1 
// 0 <= target <= prob.length 
// 如果答案与标准答案的误差在 10^-5 内，则被视为正确答案。 
// 
// Related Topics 数学 动态规划 概率与统计 
// 👍 36 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class TossStrangeCoins{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //dp[i][j] 表示 抛完第 i 枚后，有 j 个朝上的概率
    // dp[i][j] = dp[i-1][j-1]*prob[i] + dp[i-1][j]*(1-prob[i])
    public double probabilityOfHeads(double[] prob, int target) {
        int n = prob.length;
        double[][] dp = new double[n + 1][target + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= n; i++){
            dp[i][0] = dp[i - 1][0] * (1 - prob[i - 1]);
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= target; j++){
                dp[i][j] = dp[i - 1][j - 1] * prob[i - 1] + dp[i - 1][j] * (1 - prob[i - 1]);
            }
        }
        return dp[n][target];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}