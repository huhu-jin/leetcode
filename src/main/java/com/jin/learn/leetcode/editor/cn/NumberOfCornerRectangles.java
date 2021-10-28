//  [750]角矩形的数量

//给定一个只包含 0 和 1 的网格，找出其中角矩形的数量。 
//
// 一个「角矩形」是由四个不同的在网格上的 1 形成的轴对称的矩形。注意只有角的位置才需要为 1。并且，4 个 1 需要是不同的。 
//
// 
//
// 示例 1： 
//
// 输入：grid = 
//[[1, 0, 0, 1, 0],
// [0, 0, 1, 0, 1],
// [0, 0, 0, 1, 0],
// [1, 0, 1, 0, 1]]
//输出：1
//解释：只有一个角矩形，角的位置为 grid[1][2], grid[1][4], grid[3][2], grid[3][4]。
// 
//
// 示例 2： 
//
// 输入：grid = 
//[[1, 1, 1],
// [1, 1, 1],
// [1, 1, 1]]
//输出：9
//解释：这里有 4 个 2x2 的矩形，4 个 2x3 和 3x2 的矩形和 1 个 3x3 的矩形。
// 
//
// 示例 3： 
//
// 输入：grid = 
//[[1, 1, 1, 1]]
//输出：0
//解释：矩形必须有 4 个不同的角。
// 
//
// 
//
// 提示： 
//
// 
// 网格 grid 中行和列的数目范围为 [1, 200]。 
// 每个网格 grid[i][j] 中的值不是 0 就是 1 。 
// 网格中 1 的个数不会超过 6000。 
// 
//
// 
// Related Topics 数组 数学 动态规划 矩阵 
// 👍 62 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class NumberOfCornerRectangles{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 没有算法技巧
    // 枚举两条不同的边r1、r2作为长方形的上下边
    // 然后逐列比较
    public int countCornerRectangles(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        int ans =0;
        for (int r1 = 0; r1 < rowCount; r1++) {
            for (int r2 = r1 + 1; r2 < rowCount; r2++) {
                int count =0;
                for (int l = 0; l < colCount; l++) {
                    if (grid[r1][l] == 1 &&grid[r2][l] == 1) count++;
                }
                // 组合 C2n
                ans += count * (count - 1) / 2;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}