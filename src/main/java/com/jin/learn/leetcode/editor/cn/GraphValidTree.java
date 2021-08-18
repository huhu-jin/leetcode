//  [261]以图判树

//给定从 0 到 n-1 标号的 n 个结点，和一个无向边列表（每条边以结点对来表示），请编写一个函数用来判断这些边是否能够形成一个合法有效的树结构。 
//
// 示例 1： 
//
// 输入: n = 5, 边列表 edges = [[0,1], [0,2], [0,3], [1,4]]
//输出: true 
//
// 示例 2: 
//
// 输入: n = 5, 边列表 edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
//输出: false 
//
// 注意：你可以假定边列表 edges 中不会出现重复的边。由于所有的边是无向边，边 [0,1] 和边 [1,0] 是相同的，因此不会同时出现在边列表 edg
//es 中。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 
// 👍 122 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.*;


public class GraphValidTree{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 题目意思是 是否可以转化树 可以是多叉树
    // 1 判断是否存在环
    // 2 是否连通    [1, 2] [3, 4]

        //DFS
        // 固定套路
        // 邻接矩阵 graph [i] [j] 表示 i->j 是通的
        public boolean validTree(int n, int[][] edges) {
            //构建邻接矩阵
            int[][] graph = new int[n][n];
            //有边的元素设置为1，没有边的元素设置为0
            for (int[] edge : edges) {
                graph[edge[0]][edge[1]] = 1;
                graph[edge[1]][edge[0]] = 1;
            }

            //进行DFS
            Stack<Integer> stack = new Stack<>();
            stack.add(0); // 某一点出发 把它能到到达的位置 加入栈中
            boolean[] visited = new boolean[n];
            while(!stack.isEmpty()){
                Integer cur = stack.pop();
                visited[cur] = true;
                // 判断 和其他节点的连通性
                for(int i = 0;i < n;i++){
                    if(graph[cur][i] == 1){
                        if(visited[i]) return false;

                        visited[i] = true;
                        graph[cur][i] = 0;
                        graph[i][cur] = 0;
                        stack.add(i);
                    }
                }
            }

            //判断是否为单连通分量
            for (int i = 0; i < n; i++) {
                if (!visited[i])
                    return false;
            }
            return true;
        }


        // 并查集
        public boolean validTree1(int n, int[][] edges) {
            DisjointSet disjointSet = new DisjointSet(n);
            for (int[] edge : edges) {
                if (!disjointSet.union(edge[0], edge[1]))
                    return false;
            }
            return disjointSet.getCount() == 1;
        }

    }
    //并查集
    class DisjointSet {
        int n;
        int[] parent;
        int[] rank;
        int count; //连同分量

        DisjointSet(int n) {
            this.n = n;
            this.parent = new int[n];
            Arrays.fill(parent, -1);
            this.rank = new int[n];
            this.count = n;
        }

        //寻找父节点
        private int findRoot(int x) {
            int root = x;
            while (parent[root] != -1) {
                root = parent[root];
            }
            return root;
        }

        public boolean union(int x, int y) {
            int xRoot = findRoot(x);
            int yRoot = findRoot(y);
            //如果两个在同一颗树上，直接返回false
            if (xRoot == yRoot) return false;
            //压缩路径
            if (rank[xRoot] > rank[yRoot]) {
                parent[yRoot] = xRoot;
            } else if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
            } else if (rank[xRoot] == rank[yRoot]) {
                parent[xRoot] = yRoot;
                rank[yRoot]++;
            }
            count--;
            return true;
        }

        public int getCount() {
            return this.count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().validTree1(5, new int[][]{{0, 1},{1, 2},{1, 4}, {2, 3}});
    }
  
}