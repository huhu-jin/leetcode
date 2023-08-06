//  [1292]元素和小于等于阈值的正方形的最大边长

//给你一个大小为 m x n 的矩阵 mat 和一个整数阈值 threshold。 
//
// 请你返回元素总和小于或等于阈值的正方形区域的最大边长；如果没有这样的正方形区域，则返回 0 。 
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
//输出：2
//解释：总和小于或等于 4 的正方形的最大边长为 2，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], 
//threshold = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 300 
// 0 <= mat[i][j] <= 10⁴ 
// 0 <= threshold <= 10⁵ 
// 
// Related Topics 数组 二分查找 矩阵 前缀和 👍 92 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q1292_MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 前缀和 + 二分查找
    int m, n;
        int[][] dp; // 从 (0, 0) 到 (i, j) 内元素的总和。
        public int maxSideLength(int[][] mat, int threshold) {
            m = mat.length;
            n = mat[0].length;
            dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = mat[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1]; // 假设知道 i-1 j-1
                }
            }
            int l = 0, h = Math.min(m, n);
            while (l <= h) {
                int mid = l + (h - l) / 2;
                if (l == h || l + 1 == h) {
                    break;
                }
                if (help(mid, threshold)) {
                    l = mid;
                } else {
                    h = mid - 1;
                }
            }
            if (help(h, threshold)) {
                return h;
            } else {
                return l;
            }
        }
        public boolean help(int k, int threshold) {
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i - k < 0 || j - k < 0) {
                        continue;
                    }
                    // 任意 矩阵区域的 和
                    if (dp[i][j] - dp[i - k][j] - dp[i][j - k] + dp[i - k][j - k] <= threshold) {
                        return true;
                    }
                }
            }
            return false;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
