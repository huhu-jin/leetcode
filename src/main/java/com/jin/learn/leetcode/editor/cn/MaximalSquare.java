//  [221]最大正方形

//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 数组 动态规划 矩阵 
// 👍 819 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class MaximalSquare{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //pos(i,j)=min(pos(i−1,j),pos(i−1,j−1),pos(i,j−1))+1
    // 这个dp表示 某个位置 最大正方形
    // 不是原来dp 表示[m][n] 在m n 矩形内
    public int maximalSquare(char[][] matrix) {
        if(matrix == null) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] pos = new int[m+1][n+1];
        int maxlength = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    pos[i][j]= Math.min(pos[i-1] [j], Math.min(pos[i-1][j-1], pos[i][j-1]))+1;
                    maxlength = Math.max(pos[i][j], maxlength);
                }else {
                    pos[i][j] = 0;
                }

            }
        }
        return maxlength * maxlength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().maximalSquare(new char[][]{{'1', '1'},{ '1', '1'}});
        new Solution().maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}});
    }
  
}