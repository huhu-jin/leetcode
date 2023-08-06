//  [64]最小路径和

//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics 数组 动态规划 矩阵 
// 👍 937 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.LinkedList;


public class Q64_MinimumPathSum{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 第一眼是backTrack,结果超时了
        // 用dp

        public int minPathSum(int[][] grid) {
            if(grid == null) return 0;
            int[][] dp = new int[grid.length][grid[0].length];

            dp[0][0] = grid[0][0];
            for (int i = 1; i < grid.length; i++) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }

            for (int j = 1;j < grid[0].length; j++) {
                dp[0][j] = dp[0][j - 1] + grid[0][j];
            }

            for (int i = 1; i < grid.length; i++) {
                for (int j = 1; j < grid[0].length; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }

            return dp[grid.length - 1][grid[0].length - 1];
        }


//    int minLength =Integer.MAX_VALUE;
//    public int minPathSum(int[][] grid) {
//        if(grid == null) return 0;
//        backTracking(grid, 0, 0, new LinkedList<>());
//        return minLength;
//    }

//    private void backTracking(int[][] grid, int i, int j, LinkedList<Integer> path) {
//        if (i == grid.length - 1 && j == grid[0].length - 1) {
//            minLength = Math.min(sum(path) + grid[i][j], minLength);
//            return;
//        }
//        if (i >= grid.length || j >= grid[0].length) {
//            return;
//        }
//        path.add(grid[i][j]);
//        backTracking(grid, i+1, j, new LinkedList<>(path));
//        backTracking(grid, i, j+1, new LinkedList<>(path));
//        path.pollLast();
//    }

//    private int sum(LinkedList<Integer> path) {
//        int res=0;
//        for (int i : path) {
//            res += i;
//        }
//        return res;
//    }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
        
    }
  
}
