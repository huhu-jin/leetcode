//  [311]稀疏矩阵的乘法

//给你两个 稀疏矩阵 A 和 B，请你返回 AB 的结果。你可以默认 A 的列数等于 B 的行数。 
//
// 请仔细阅读下面的示例。 
//
// 
//
// 示例： 
//
// 输入：
//
//A = [
//  [ 1, 0, 0],
//  [-1, 0, 3]
//]
//
//B = [
//  [ 7, 0, 0 ],
//  [ 0, 0, 0 ],
//  [ 0, 0, 1 ]
//]
//
//输出：
//
//     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
//AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
//                  | 0 0 1 |
// 
// Related Topics 数组 哈希表 矩阵 
// 👍 52 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class SparseMatrixMultiplication{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // i j p 有点晕 debug 慢慢写 没问题
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length;
        int n = mat2[0].length;
        int [][] ans =  new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = multi(mat1, mat2, i, j);
            }
        }
        return ans;
    }

    private int multi(int[][] mat1, int[][] mat2, int i, int j) {
        int ans =0;
        for (int p = 0; p < mat2.length; p++) {
            int temp = mat1[i][p] * mat2[p][j];
            ans += temp;
        }
        return ans;
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}