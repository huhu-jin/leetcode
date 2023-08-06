//  [85]最大矩形

//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = [["0","0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 0 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 栈 数组 动态规划 矩阵 单调栈 
// 👍 973 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q85_MaximalRectangle{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //https://leetcode-cn.com/problems/maximal-rectangle/solution/jie-jin-shuang-100javajie-fa-su-kan-by-w-47dv/
    //   找出每个位置从上到下连续1的数目，如
    // a
    //1 1 0
    //1 0 1
    //1 1 1
    //可以记作：
    // b
    //1 1 0
    //2 0 1
    //3 1 2
    // 然后每个a矩阵点计算: 方法是 相同位置点在b中, 向左找大于等于该数的个数,cnt++，向右找大于等于该数的个数,cnt++，
    //    cnt * b[i][j]
    public int maximalRectangle(char[][] matrix) {
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
