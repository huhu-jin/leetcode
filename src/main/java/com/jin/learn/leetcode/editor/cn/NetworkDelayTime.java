//  [743]网络延迟时间

//有 n 个网络节点，标记为 1 到 n。 
//
// 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， 
//wi 是一个信号从源节点传递到目标节点的时间。 
//
// 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 1
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 2
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 100 
// 1 <= times.length <= 6000 
// times[i].length == 3 
// 1 <= ui, vi <= n 
// ui != vi 
// 0 <= wi <= 100 
// 所有 (ui, vi) 对都 互不相同（即，不含重复边） 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 最短路 堆（优先队列） 👍 678 👎 0


package com.jin.learn.leetcode.editor.cn;


import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.PriorityQueue;


public class NetworkDelayTime{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {

            int[] distance = new int[n];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[k - 1] = 0;

            int[][] graph = new int[n][n];

            for (int i = 0; i < graph.length; i++) {
                Arrays.fill(graph[i], -1);
            }

            for (int i=0;i<graph.length;i++) {
                graph[i][i] = 0;
            }


            for (int[] time : times) {
                graph[time[0] - 1][time[1] - 1] = time[2];
            }

            PriorityQueue<Node> queue = new PriorityQueue<>((i,j) -> i.distance - j.distance);
            queue.add(new Node(k - 1, 0));

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                int index = node.index;
                int dis = node.distance;

                if (dis > distance[index]) continue;

                for (int i = 0; i < n; i++) {
                    if (graph[index][i]  != -1) {
                        int newDis = dis + graph[index][i];
                        if (newDis < distance[i]) {
                            distance[i] = newDis;
                            queue.add(new Node(i, newDis));
                        }
                    }
                }
            }

            int max = 0;
            for (int i = 0; i < n; i++) {
                if (distance[i] == Integer.MAX_VALUE) return -1;
                max = Math.max(max, distance[i]);
            }
            return max;
        }

        public class Node {
            int index;
            int distance;

            public Node(int index, int distance) {
                this.index = index;
                this.distance = distance;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().networkDelayTime(new int[][]{{3, 5, 78}, {2, 1, 1}, {1, 3, 0}, {4, 3, 59}, {5, 3, 85}, {5, 2, 22}, {2, 4, 23}, {1, 4, 43}, {4, 5, 75}, {5, 1, 15}, {1, 5, 91}, {4, 1, 16}, {3, 2, 98}, {3, 4, 22}, {5, 4, 31}, {1, 2, 0}, {2, 5, 4}, {4, 2, 51}, {3, 1, 36}, {2, 3, 59}}, 5, 5);
        
    }
  
    
}