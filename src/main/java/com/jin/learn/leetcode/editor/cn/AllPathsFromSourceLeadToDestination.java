//  [1059]从始点到终点的所有路径

//给定有向图的边 edges，以及该图的始点 source 和目标终点 destination，确定从始点 source 出发的所有路径是否最终结束于目标终点
// destination，即： 
//
// 
// 从始点 source 到目标终点 destination 存在至少一条路径 
// 如果存在从始点 source 到没有出边的节点的路径，则该节点就是路径终点。 
// 从始点source到目标终点 destination 可能路径数是有限数字 
// 
//
// 当从始点 source 出发的所有路径都可以到达目标终点 destination 时返回 true，否则返回 false。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：n = 3, edges = [[0,1],[0,2]], source = 0, destination = 2
//输出：false
//说明：节点 1 和节点 2 都可以到达，但也会卡在那里。
// 
//
// 示例 2： 
//
// 
//
// 输入：n = 4, edges = [[0,1],[0,3],[1,2],[2,1]], source = 0, destination = 3
//输出：false
//说明：有两种可能：在节点 3 处结束，或是在节点 1 和节点 2 之间无限循环。
// 
//
// 示例 3： 
//
// 
//
// 输入：n = 4, edges = [[0,1],[0,2],[1,3],[2,3]], source = 0, destination = 3
//输出：true
// 
//
// 示例 4： 
//
// 
//
// 输入：n = 3, edges = [[0,1],[1,1],[1,2]], source = 0, destination = 2
//输出：false
//说明：从始点出发的所有路径都在目标终点结束，但存在无限多的路径，如 0-1-2，0-1-1-2，0-1-1-1-2，0-1-1-1-1-2 等。
// 
//
// 示例 5： 
//
// 
//
// 输入：n = 2, edges = [[0,1],[1,1]], source = 0, destination = 1
//输出：false
//说明：在目标节点上存在无限的自环。
// 
//
// 
//
// 提示： 
//
// 
// 给定的图中可能带有自环和平行边。 
// 图中的节点数 n 介于 1 和 10000 之间。 
// 图中的边数在 0 到 10000 之间。 
// 0 <= edges.length <= 10000 
// edges[i].length == 2 
// 0 <= source <= n - 1 
// 0 <= destination <= n - 1 
// 
// Related Topics 深度优先搜索 图 
// 👍 33 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AllPathsFromSourceLeadToDestination {


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
            int[] visited = new int[n];
            Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] e : edges){
            graph.computeIfAbsent(e[0], i -> new ArrayList<>()).add(e[1]);
        }

            return dfs(graph, visited, source, destination);

        }
//
    public boolean dfs(Map<Integer, List<Integer>> graph, int[] visited, int cur, int destination){
        if(!graph.containsKey(cur) && cur != destination) return false;
        visited[cur] = 1;
        if(graph.containsKey(cur)){
            for(int adj : graph.get(cur)){
                if(visited[adj] == 2) continue;
                if(visited[adj] == 1 || !dfs(graph, visited, adj, destination)) return false;
            }
        }
        visited[cur] = 2;
        return true;
    }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void testCase() {
        Solution solution = new Solution();
        boolean b = solution.leadsToDestination(4, new int[][]{{0, 1},{0,2},{1,3},{2,3}}, 0, 3);
        System.out.println(b);
    }

}