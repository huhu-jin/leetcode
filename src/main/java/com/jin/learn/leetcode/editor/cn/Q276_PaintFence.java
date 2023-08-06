//  [276]栅栏涂色

//有 k 种颜色的涂料和一个包含 n 个栅栏柱的栅栏，请你按下述规则为栅栏设计涂色方案： 
//
// 
// 每个栅栏柱可以用其中 一种 颜色进行上色。 
// 相邻的栅栏柱 最多连续两个 颜色相同。 
// 
//
// 给你两个整数 k 和 n ，返回所有有效的涂色 方案数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, k = 2
//输出：6
//解释：所有的可能涂色方案如上图所示。注意，全涂红或者全涂绿的方案属于无效方案，因为相邻的栅栏柱 最多连续两个 颜色相同。
// 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：n = 7, k = 2
//输出：42
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 50 
// 1 <= k <= 105 
// 题目数据保证：对于输入的 n 和 k ，其答案在范围 [0, 231 - 1] 内 
// 
// Related Topics 动态规划 
// 👍 124 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q276_PaintFence{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 关于题意的理解: 相邻的栅栏柱 最多连续两个 颜色相同。 1100 0011 这样是可以的
    public int numWays(int n, int k) {
        if (k==1 && n>2) return 0;
        if(k==1 && n>=1) return 1;
        int [][]dp = new int[n][2];
        dp[0][0] = 0; // 状态 0 表示与上一个颜色相同
        dp[0][1] = k; // 状态 1 表示与上一个颜色不同
        for (int i = 1; i < n; ++i) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][1]) * (k - 1);
        }
        return dp[n - 1][0] + dp[n - 1][1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().numWays(4, 2);
    }
  
}
