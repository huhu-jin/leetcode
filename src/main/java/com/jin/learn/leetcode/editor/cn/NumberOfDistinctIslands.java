//  [694]不同岛屿的数量

//给定一个非空 01 二维数组表示的网格，一个岛屿由四连通（上、下、左、右四个方向）的 1 组成，你可以认为网格的四周被海水包围。 
//
// 请你计算这个网格中共有多少个形状不同的岛屿。两个岛屿被认为是相同的，当且仅当一个岛屿可以通过平移变换（不可以旋转、翻转）和另一个岛屿重合。 
//
// 
//
// 示例 1： 
//
// 11000
//11000
//00011
//00011
// 
//
// 给定上图，返回结果 1 。 
//
// 示例 2： 
//
// 11011
//10000
//00001
//11011 
//
// 给定上图，返回结果 3 。 
// 
//注意： 
//
// 11
//1
// 
//
// 和 
//
//  1
//11
// 
//
// 是不同的岛屿，因为我们不考虑旋转、翻转操作。 
//
// 
//
// 提示：二维数组每维的大小都不会超过 50 。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 哈希表 哈希函数 
// 👍 90 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;


public class NumberOfDistinctIslands {


    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        private final HashSet<String> pathSet = new HashSet<>();

        public int numDistinctIslands(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        StringBuilder stringBuffer = new StringBuilder();
                        dfs(grid, i, j, stringBuffer);
                        if (!pathSet.contains(stringBuffer.toString())) {
                            pathSet.add(stringBuffer.toString());
                        }
                    }
                }
            }
            return pathSet.size();
        }

        // 会有问题的
        // 下右下
        //  10
        //  11
        //  01
        // 下右下
        //  10
        //  11
        //  10
        private void backTracking(int[][] grid, int i, int j, StringBuffer stringBuffer) {
            grid[i][j] = 0;
            // 右
            if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                stringBuffer.append("r");
                backTracking(grid, i, j + 1, stringBuffer);
            }
            // 下
            if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                stringBuffer.append("d");
                backTracking(grid, i + 1, j, stringBuffer);
            }
            // 左
            if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                stringBuffer.append("l");
                backTracking(grid, i, j - 1, stringBuffer);
            }
            // 上
            if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                stringBuffer.append("u");
                backTracking(grid, i - 1, j, stringBuffer);
            }
        }


        // 下右下
        //  10
        //  11
        //  01
        // 下右下
        //  10
        //  11
        //  10
        // 暗含 递归层级
        public void dfs(int[][] grid, int i, int j, StringBuilder sb) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1)
                return;
            grid[i][j] = 0;
            dfs(grid, i + 1, j, sb.append("d"));
            dfs(grid, i, j + 1, sb.append("r"));
            dfs(grid, i - 1, j, sb.append("u"));
            dfs(grid, i, j - 1, sb.append("l"));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void testCase() {
        new Solution().numDistinctIslands(new int[][]{
                {1,0},
                {1,1},
                {0,1},
                {1,0},
                {1,1},
                {1,0}

        });
    }



}