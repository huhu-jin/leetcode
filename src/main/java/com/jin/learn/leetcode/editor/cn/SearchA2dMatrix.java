//  [74]搜索二维矩阵

//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
// Related Topics 数组 二分查找 矩阵 👍 675 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class SearchA2dMatrix{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left=0;
        int right = matrix.length-1;

        // 首位 小于target的 i 列
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        int i = left - 1;

        if (i<0) return false;
        left = 0;
        right = matrix[0].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[i][mid] == target) {
                return true;
            } else if (matrix[i][mid]<target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return false;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
         new Solution().searchMatrix(new int[][]{{1}}, 0);
    }
  
}