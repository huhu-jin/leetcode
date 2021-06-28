//  [200]岛屿数量

//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 1209 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class NumberOfIslands{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int numIslands(char[][] grid) {
        if(grid == null) return 0;
        int ret = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
               ret +=recur(grid, i, j);

            }
        }
        return ret;
    }

        private int recur(char[][] grid, int i, int j) {
            if(i<0 || j<0 || i>=grid.length || j>=grid[0].length){
                return 0;
            }

            if (grid[i][j] == '1') {
                grid[i][j] = '0';
                recur(grid, i - 1, j);
                recur(grid, i , j-1);
                recur(grid, i + 1, j);
                recur(grid, i , j+1);
                return 1;
            }
            return 0;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().numIslands(new char[][]{{'1'}});
    }
  
}