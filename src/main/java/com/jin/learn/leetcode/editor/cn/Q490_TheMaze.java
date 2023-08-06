//  [490]迷宫

//由空地（用 0 表示）和墙（用 1 表示）组成的迷宫 maze 中有一个球。球可以途经空地向 上、下、左、右 四个方向滚动，且在遇到墙壁前不会停止滚动。当球
//停下时，可以选择向下一个方向滚动。
// 
// 
// 
// 给你一个大小为 m x n 的迷宫 maze ，以及球的初始位置 start 和目的地 destination ，其中 start = [startrow
//, startcol] 且 destination = [destinationrow, destinationcol] 。请你判断球能否在目的地停下：如果可以
//，返回 true ；否则，返回 false 。 
//
// 你可以 假定迷宫的边缘都是墙壁（参考示例）。 
//
// 
//
// 示例 1： 
//
// 
//输入：maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start
// = [0,4], destination = [4,4]
//输出：true
//解释：一种可能的路径是 : 左 -> 下 -> 左 -> 下 -> 右 -> 下 -> 右。
// 
//
// 示例 2： 
//
// 
//输入：maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start
// = [0,4], destination = [3,2]
//输出：false
//解释：不存在能够使球停在目的地的路径。注意，球可以经过目的地，但无法在那里停驻。
// 
//
// 示例 3： 
//
// 
//输入：maze = [[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]], start
// = [4,3], destination = [0,1]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == maze.length 
// n == maze[i].length 
// 1 <= m, n <= 100 
// maze[i][j] is 0 or 1. 
// start.length == 2 
// destination.length == 2 
// 0 <= startrow, destinationrow <= m 
// 0 <= startcol, destinationcol <= n 
// 球和目的地都在空地上，且初始时它们不在同一位置 
// 迷宫 至少包括 2 块空地 
// 
// 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 
// 👍 113 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q490_TheMaze{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[][] maze ;
    private int[] destination ;
    private boolean [][] visited;
    // 理解题意
    // 1 球是滚动 一直到碰壁停下,而不是走一步换个方向, 2经过不算
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.destination = destination;
        this.maze = maze;
        this.visited =new boolean[maze.length][maze[0].length]; // 用另外的记录 记录在maze 会影响结果
        return dfs(start[0],start[1]);
    }
            // 一直滚, while -- 直到 遇到1换方向
            // 只记录 转弯的节点
            public boolean dfs( int i, int j) {
                if (visited[i][j]) return false;
                if (i == destination[0] && j == destination[1]) {
                    return true;
                }
                visited[i][j] = true;
                int r = j + 1, l = j - 1, u = i - 1, d = i + 1;

                while (r < maze[0].length && maze[i][r] == 0)  r++; // right
                if (dfs(i, r-1)) return true;

                while (l >= 0 && maze[i][l] == 0)  l--; //left
                if (dfs(i,l+1)) return true;

                while (u >= 0 && maze[u][j] == 0)  u--; //up
                if (dfs(u+1,j)) return true;

                while (d < maze.length && maze[d][j] == 0) d++; //down
                if (dfs(d-1,j))  return true;

                return false;
            }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        boolean b = new Solution().hasPath(new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 4}, new int[]{1, 2});
        System.out.println(b);
    }
  
}
