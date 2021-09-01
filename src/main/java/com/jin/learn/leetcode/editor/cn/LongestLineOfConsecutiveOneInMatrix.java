//  [562]矩阵中最长的连续1线段

//给定一个01矩阵 M，找到矩阵中最长的连续1线段。这条线段可以是水平的、垂直的、对角线的或者反对角线的。 
//
// 示例: 
//
// 输入:
//[[0,1,1,0],
// [0,1,1,0],
// [0,0,0,1]]
//输出: 3
// 
//
// 提示: 给定矩阵中的元素数量不会超过 10,000。 
// Related Topics 数组 动态规划 矩阵 
// 👍 44 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class LongestLineOfConsecutiveOneInMatrix{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // 最左边一列
        // 从最上面一行
        // 暴力计算
        public boolean overflow(int[][] M, int i, int j) {
            return i < 0 || j < 0 || i >= M.length || j >= M[0].length;
        }

        public int count(int[][] M, int i, int j, int direction_i, int direction_j) {
            int ans = 0, cur = 0;
            while (!overflow(M, i, j)) {
                if (M[i][j] == 1) {
                    ++cur;
                    ans = Math.max(ans, cur);
                } else {
                    cur = 0;
                }
                i += direction_i;
                j += direction_j;
            }
            return ans;
        }

        public int longestLine(int[][] M) {
            if (M.length == 0)
                return 0;
            int ans = 0;
            for (int i = 0; i != M.length; ++i) {
                // 左边界为起点，向右
                ans = Math.max(ans, count(M, i, 0, 0, 1));
                // 左边界为起点，向右下
                ans = Math.max(ans, count(M, i, 0, 1, 1));
                // 右边界为起点，向左下
                ans = Math.max(ans, count(M, i, M[0].length - 1, 1, -1));
            }
            for (int j = 0; j != M[0].length; ++j) {
                // 上边界为起点，向下
                ans = Math.max(ans, count(M, 0, j, 1, 0));
                // 上边界为起点，向右下
                ans = Math.max(ans, count(M, 0, j, 1, 1));
                // 上边界为起点，向左下
                ans = Math.max(ans, count(M, 0, j, 1, -1));
            }
            return ans;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}