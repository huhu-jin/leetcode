//  [505]迷宫 II

//由空地和墙组成的迷宫中有一个球。球可以向上下左右四个方向滚动，但在遇到墙壁前不会停止滚动。当球停下时，可以选择下一个方向。 
//
// 给定球的起始位置，目的地和迷宫，找出让球停在目的地的最短距离。距离的定义是球从起始位置（不包括）到目的地（包括）经过的空地个数。如果球无法停在目的地，返回
// -1。 
//
// 迷宫由一个0和1的二维数组表示。 1表示墙壁，0表示空地。你可以假定迷宫的边缘都是墙壁。起始位置和目的地的坐标通过行号和列号给出。 
//
// 
//
// 示例 1: 
//
// 输入 1: 迷宫由以下二维数组表示
//
//0 0 1 0 0
//0 0 0 0 0
//0 0 0 1 0
//1 1 0 1 1
//0 0 0 0 0
//
//输入 2: 起始位置坐标 (rowStart, colStart) = (0, 4)
//输入 3: 目的地坐标 (rowDest, colDest) = (4, 4)
//
//输出: 12
//
//解析: 一条最短路径 : left -> down -> left -> down -> right -> down -> right。
//             总距离为 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12。
//
// 
//
// 示例 2: 
//
// 输入 1: 迷宫由以下二维数组表示
//
//0 0 1 0 0
//0 0 0 0 0
//0 0 0 1 0
//1 1 0 1 1
//0 0 0 0 0
//
//输入 2: 起始位置坐标 (rowStart, colStart) = (0, 4)
//输入 3: 目的地坐标 (rowDest, colDest) = (3, 2)
//
//输出: -1
//
//解析: 没有能够使球停在目的地的路径。
//
// 
//
// 
//
// 注意: 
//
// 
// 迷宫中只有一个球和一个目的地。 
// 球和目的地都在空地上，且初始时它们不在同一位置。 
// 给定的迷宫不包括边界 (如图中的红色矩形), 但你可以假设迷宫的边缘都是墙壁。 
// 迷宫至少包括2块空地，行数和列数均不超过100。 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 最短路 堆（优先队列） 
// 👍 89 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Q505_TheMazeIi{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
       // 二维数组 distance[i, j] 表示: 起点 到 点(i,j) 最小步数
       // 当前起始位置 + count  到达位置
       // 以当前 (i,j) 为基础 遍历
        private  int[][] distance;
        private int [][] maze;
        int[][] dirs= {{0,1}, {0,-1}, {-1,0}, {1,0}};
        public int shortestDistance(int[][] maze, int[] start, int[] dest) {
            distance = new int[maze.length][maze[0].length];
            this.maze = maze;
            for (int[] row: distance)
                Arrays.fill(row, Integer.MAX_VALUE);
            distance[start[0]][start[1]] = 0;
            dfs(start[0], start[1]);
            return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
        }

        public void dfs(int i, int j) {
            for (int[] dir: dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                int count = 0;
                // 一直滚
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }

                // 而从 原先的点(i j )+ count <  新到达的点
                // 那就赋值 再新的点出发
                if (distance[i][j] + count < distance[x - dir[0]][y - dir[1]]) {
                    distance[x - dir[0]][y - dir[1]] = distance[i][j] + count;
                    dfs(x - dir[0] , y - dir[1]);
                }
            }
        }




        //广度遍历 借助队列
        public int shortestDistance2(int[][] maze, int[] start, int[] dest) {
            int[][] distance = new int[maze.length][maze[0].length];
            for (int[] row: distance)
                Arrays.fill(row, Integer.MAX_VALUE);
            distance[start[0]][start[1]] = 0;
            Queue< int[] > queue = new LinkedList< >();
            queue.add(start);
            while (!queue.isEmpty()) {
                int[] s = queue.remove();
                for (int[] dir: dirs) {
                    int x = s[0] + dir[0];
                    int y = s[1] + dir[1];
                    int count = 0;
                    while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                        x += dir[0];
                        y += dir[1];
                        count++;
                    }
                    if (distance[s[0]][s[1]] + count < distance[x - dir[0]][y - dir[1]]) {
                        distance[x - dir[0]][y - dir[1]] = distance[s[0]][s[1]] + count;
                        queue.add(new int[] {x - dir[0], y - dir[1]});
                    }
                }
            }
            return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
        }


}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        int ret = new Solution().shortestDistance(new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 4}, new int[]{1, 2});
        System.out.println(ret);

    }
  
}
