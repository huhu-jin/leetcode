//  [73]矩阵置零

//给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。 
// 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。 
// 你能想出一个仅使用常量空间的解决方案吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
//输出：[[1,0,1],[0,0,0],[1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[0].length 
// 1 <= m, n <= 200 
// -231 <= matrix[i][j] <= 231 - 1 
// 
// Related Topics 数组 
// 👍 419 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Arrays;


public class SetMatrixZeroes {


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {

            int[] r = new int[matrix.length];
            int[] l = new int[matrix[0].length];

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 0) {
                        r[i] = 1;
                        l[j] = 1;
                    }
                }
            }

            for (int x = 0; x < r.length; x++) {
                if (r[x] == 1) {
                    Arrays.fill(matrix[x], 0);
                }
            }

            for (int y = 0; y < l.length; y++) {
                if (l[y] == 1) {
                    for (int j = 0; j < matrix.length; j++) {
                        matrix[j][y] = 0;
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void testCase() {
        new Solution().setZeroes(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
    }

}