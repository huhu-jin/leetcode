//  [48]旋转图像

//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。 
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：[[1]]
// 
//
// 示例 4： 
//
// 
//输入：matrix = [[1,2],[3,4]]
//输出：[[3,1],[4,2]]
// 
//
// 
//
// 提示： 
//
// 
// matrix.length == n 
// matrix[i].length == n 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
// Related Topics 数组 数学 矩阵 
// 👍 933 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class RotateImage{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 水平翻转 + 主对角线翻转 等价于  旋转90度
    public void rotate(int[][] matrix) {

        // 水平翻转
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                swap(matrix, i, j, matrix.length - 1 - i, j);
            }
        }

        // 对角线翻转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                swap(matrix, i, j, j, i);
            }
        }

    }

        private void swap(int[][] matrix, int a, int b, int x, int y) {
            matrix[a][b] = matrix[a][b] ^ matrix[x][y];
            matrix[x][y] = matrix[a][b] ^ matrix[x][y];
            matrix[a][b] = matrix[a][b] ^ matrix[x][y];
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
  
}