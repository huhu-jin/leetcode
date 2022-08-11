//  [1971]寻找图中是否存在路径

//有一个具有 n个顶点的 双向 图，其中每个顶点标记从 0 到 n - 1（包含 0 和 n - 1）。图中的边用一个二维整数数组 edges 表示，其中 
//edges[i] = [ui, vi] 表示顶点 ui 和顶点 vi 之间的双向边。 每个顶点对由 最多一条 边连接，并且没有顶点存在与自身相连的边。 
//
// 请你确定是否存在从顶点 start 开始，到顶点 end 结束的 有效路径 。 
//
// 给你数组 edges 和整数 n、start和end，如果从 start 到 end 存在 有效路径 ，则返回 true，否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, edges = [[0,1],[1,2],[2,0]], start = 0, end = 2
//输出：true
//解释：存在由顶点 0 到顶点 2 的路径:
//- 0 → 1 → 2 
//- 0 → 2
// 
//
// 示例 2： 
//
// 
//输入：n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], start = 0, end = 5
//输出：false
//解释：不存在由顶点 0 到顶点 5 的路径.
// 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 2 * 10⁵ 
// 0 <= edges.length <= 2 * 10⁵ 
// edges[i].length == 2 
// 0 <= ui, vi <= n - 1 
// ui != vi 
// 0 <= start, end <= n - 1 
// 不存在双向边 
// 不存在指向顶点自身的边 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 👍 40 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class FindIfPathExistsInGraph{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer,List<Integer>> adj = new HashMap<>();
        // 构建邻接表
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], (i)->new LinkedList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], (i)->new LinkedList<>()).add(edge[0]);
        }

        int[] visited = new int[n];

        if (source == destination) return true;

        return dfs(adj, visited, source, destination);
    }

    private boolean dfs(Map<Integer,List<Integer>> adj, int[] visited, int source, int destination ){

        if (adj.get(source).contains(destination)) {
            return true;
        }

        if (visited[source] == 0) {
            visited[source] = 1;
            for (int i : adj.get(source)) {
                if (dfs(adj, visited, i, destination)) {
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().validPath(6, new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5);
    }
  
}