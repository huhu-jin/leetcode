//  [59]螺旋矩阵 II

//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 
// 👍 353 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q59_SpiralMatrixIi{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int x =0 ,y =0;
        int l =0; int  r = n;
        int u = 0; int d = n;
        for (int i = 1; i <= n * n;) {
            for (; y < r; y++) {
                if(ret[x][y] ==0) ret[x][y] = i++;
            }
            y--;
            r--;
            for (; x< d; x++) {
                if(ret[x][y] ==0) ret[x][y] = i++;
            }
            d--;
            x--;
            for (; y >= l; y--) {
                if(ret[x][y] ==0) ret[x][y] = i++;
            }
            l++;
            y++;
            for (; x >= u; x--) {
                if(ret[x][y] ==0) ret[x][y] = i++;
            }
            u++;
            x++;
            x++; y++;
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().generateMatrix(1);
        new Solution().generateMatrix(17);
    }
  
}
