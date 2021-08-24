//  [323]无向图中连通分量的数目

//给定编号从 0 到 n-1 的 n 个节点和一个无向边列表（每条边都是一对节点），请编写一个函数来计算无向图中连通分量的数目。 
//
// 示例 1: 
//
// 输入: n = 5 和 edges = [[0, 1], [1, 2], [3, 4]]
//
//     0          3
//     |          |
//     1 --- 2    4 
//
//输出: 2
// 
//
// 示例 2: 
//
// 输入: n = 5 和 edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
//
//     0           4
//     |           |
//     1 --- 2 --- 3
//
//输出:  1
// 
//
// 注意: 
//你可以假设在 edges 中不会出现重复的边。而且由于所以的边都是无向边，[0, 1] 与 [1, 0] 相同，所以它们不会同时在 edges 中出现。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 
// 👍 94 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Stack;


public class NumberOfConnectedComponentsInAnUndirectedGraph{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 固定套路
    // 邻接矩阵 dfs visited[] 涂黑
    //
    public int countComponents(int n, int[][] edges) {
        int [][] graph = new int[n][n];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
        int ans =0;

        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if(visited[i]) continue;
            stack.push(i);
            visited[i] = true;
            while (!stack.isEmpty()) {
                int cur = stack.pop();
                for (int j = 0; j < n; j++) {
                    if (graph[cur][j] == 1) {
                        if(visited[j]) continue; // 防止 01 10 回头
                        visited[j] = true;
                        stack.push(j);
                    }
                }
            }
            ans ++;
        }


        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        Solution solution = new Solution();
        int i = solution.countComponents(5, new int[][]{{0, 1}, {1, 2}, {3, 4}});
        System.out.println(i);
    }
  
}