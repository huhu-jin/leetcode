//  [剑指 Offer 04]二维数组中的查找

//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个
//整数，判断数组中是否含有该整数。 
//
// 
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// 
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// 给定 target = 5，返回 true。 
//
// 给定 target = 20，返回 false。 
//
// 
//
// 限制： 
//
// 0 <= n <= 1000 
//
// 0 <= m <= 1000 
//
// 
//
// 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/ 
// Related Topics 数组 双指针 
// 👍 343 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class QJZOffer04_ErWeiShuZuZhongDeChaZhaoLcof{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 逆时针旋转45度 把matrix 当做平衡二叉树, 右上角为树根

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length ==0) return false;

        int i = 0;
        int j = matrix[0].length - 1;
        for (; j >= 0 && i < matrix.length; ) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
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
