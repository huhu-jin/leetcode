//  [1135]最低成本联通所有城市

//想象一下你是个城市基建规划者，地图上有 N 座城市，它们按以 1 到 N 的次序编号。 
//
// 给你一些可连接的选项 conections，其中每个选项 conections[i] = [city1, city2, cost] 表示将城市 city1
// 和城市 city2 连接所要的成本。（连接是双向的，也就是说城市 city1 和城市 city2 相连也同样意味着城市 city2 和城市 city1 相连）
//。 
//
// 返回使得每对城市间都存在将它们连接在一起的连通路径（可能长度为 1 的）最小成本。该最小成本应该是所用全部连接代价的综合。如果根据已知条件无法完成该项任务
//，则请你返回 -1。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：N = 3, conections = [[1,2,5],[1,3,6],[2,3,1]]
//输出：6
//解释：
//选出任意 2 条边都可以连接所有城市，我们从中选取成本最小的 2 条。
// 
//
// 示例 2： 
//
// 
//
// 输入：N = 4, conections = [[1,2,3],[3,4,4]]
//输出：-1
//解释： 
//即使连通所有的边，也无法连接所有城市。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 10000 
// 1 <= conections.length <= 10000 
// 1 <= conections[i][0], conections[i][1] <= N 
// 0 <= conections[i][2] <= 10^5 
// conections[i][0] != conections[i][1] 
// 
// Related Topics 并查集 图 最小生成树 堆（优先队列） 
// 👍 62 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.*;


public class Q1135_ConnectingCitiesWithMinimumCost{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 2 个前提知识:
    // 并查集+ 最小生成树(Kruskal)

    // [0,1,2,3,4,5,6]    一个数字array union find 来判断是否连通

    //最小生成树:
    //  给定一个无向图，如果它任意两个顶点都联通并且是一棵树，那么我们就称之为生成树(Spanning Tree)。
    //  如果是带权值的无向图，那么权值之和最小的生成树，我们就称之为最小生成树(MST, Minimum Spanning Tree)。

    //Kruskal
    // 所有的边按照权值先从小到大排列，接着按照顺序选取每条边，如果这条边的两个端点
    public int minimumCost(int n, int[][] connections) {
        int ans = 0;
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]); // 从小到大排列
        queue.addAll(Arrays.asList(connections));

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent [i] =i;
        }

        int count = n - 1;
        while (!queue.isEmpty() && count > 0) {
            final int[] tem = queue.poll(); // 拿出小的
            if (find(parent,tem[0]-1) == find(parent,tem[1]-1)) {
                continue;
            }
            union(parent, tem[0]-1, tem[1]-1);
            ans += tem[2];
            count--;
        }

        if (count > 0) {
            return -1;
        }
        return ans;
    }


    // 并查集 用于判断连通性
    private int find(int[] parent, int index){
        while (parent[index] != index) {
            index = parent[index];
        }
        return index;
    }

    private void union(int[] parent, int index1, int index2){
        int i = find(parent, index1);
        int j = find(parent, index2);
        if (i != j) {
            if (i < j) {
                parent[i] = j;
            }else {
                parent[j] = i;
            }
        }
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
