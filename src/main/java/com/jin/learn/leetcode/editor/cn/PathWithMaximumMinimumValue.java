//  [1102]得分最高的路径

//给你一个 R 行 C 列的整数矩阵 A。矩阵上的路径从 [0,0] 开始，在 [R-1,C-1] 结束。 
//
// 路径沿四个基本方向（上、下、左、右）展开，从一个已访问单元格移动到任一相邻的未访问单元格。 
//
// 路径的得分是该路径上的 最小 值。例如，路径 8 → 4 → 5 → 9 的值为 4 。 
//
// 找出所有路径中得分 最高 的那条路径，返回其 得分。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[[5,4,5],[1,2,6],[7,4,6]]
//输出：4
//解释： 
//得分最高的路径用黄色突出显示。 
// 
//
// 示例 2： 
//
// 
//
// 输入：[[2,2,1,2,2,2],[1,2,2,2,1,2]]
//输出：2 
//
// 示例 3： 
//
// 
//
// 输入：[[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,6,5,4,3]]
//输出：3 
//
// 
//
// 提示： 
//
// 
// 1 <= R, C <= 100 
// 0 <= A[i][j] <= 10^9 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 堆（优先队列） 
// 👍 74 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.*;



public class PathWithMaximumMinimumValue{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    // 1 四个方向 暴力 超时

    //              1
    // 2 贪心 遇到  100 1 遇到周围小的case 失败
    //              1


    // 要的是 遇到2 情况还能回退,再从剩下最大开始走
    // 贪心 + 最大堆 选最大开始走, 再加 vis 防重复

    class Node{
        public int x;
        public int y;
        public int val;

        public Node(int x, int y, int val){
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }

    int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maximumMinimumPath(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        PriorityQueue<Node> queue = new PriorityQueue<Node>((o1,o2)->o2.val-o1.val); // the bigger is front fo queue
        queue.add(new Node(0, 0, grid[0][0]));

        int ans = Math.min(grid[0][0], grid[n - 1][m - 1]);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            ans = Math.min(cur.val, ans);
            if (cur.x == n-1 && cur.y == m-1) return ans;
            for (int[] d : direction) {
                int i = cur.x + d[0];
                int j = cur.y + d[1];
                if(i<0||j<0 || i>=n || j>=m|| vis[i][j] == 1) continue;
                vis[i][j] = 1;
                queue.add(new Node(i, j, grid[i][j]));
            }
        }
        return ans;
    }



    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().maximumMinimumPath(new int[][]{{5,4,5},{1,2,6},{7,4,6}});
    }


}