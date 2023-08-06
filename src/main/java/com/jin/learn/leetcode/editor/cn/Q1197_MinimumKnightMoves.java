//  [1197]进击的骑士

//一个坐标可以从 -infinity 延伸到 +infinity 的 无限大的 棋盘上，你的 骑士 驻扎在坐标为 [0, 0] 的方格里。 
//
// 骑士的走法和中国象棋中的马相似，走 “日” 字：即先向左（或右）走 1 格，再向上（或下）走 2 格；或先向左（或右）走 2 格，再向上（或下）走 1 格
//。 
//
// 每次移动，他都可以按图示八个方向之一前进。 
//
// 
//
// 现在，骑士需要前去征服坐标为 [x, y] 的部落，请你为他规划路线。 
//
// 最后返回所需的最小移动次数即可。本题确保答案是一定存在的。 
//
// 
//
// 示例 1： 
//
// 输入：x = 2, y = 1
//输出：1
//解释：[0, 0] → [2, 1]
// 
//
// 示例 2： 
//
// 输入：x = 5, y = 5
//输出：4
//解释：[0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
// 
//
// 
//
// 提示： 
//
// 
// |x| + |y| <= 300 
// 
// Related Topics 广度优先搜索 
// 👍 55 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.*;


public class Q1197_MinimumKnightMoves{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
    // bfs + 剪枝
class Solution {

        private class Node{
            int count;
            int x;
            int y;

            public Node(int count, int x, int y ){
                this.count= count;
                this.x = x;
                this.y = y;
            }


        }

        private int [][] directs = new int[][]{{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2}}; // 必须8个方向,{1,2},{2,1}留两个是不对的
        public int minKnightMoves(int x, int y) {

            Deque<Node> deque = new LinkedList<>();
            deque.add(new Node(0, 0, 0));
            boolean[][] visited = new boolean[601][601];

            while (!deque.isEmpty()) {
                Deque<Node> tempQueue = new LinkedList<>();


                while (!deque.isEmpty()) {
                    Node node = deque.pop();
                    if (node.x == x && node.y == y) return node.count;

                    if (visited[node.x + 300][node.y + 300]) continue;
                    visited[node.x + 300][node.y + 300] = true;

                    int preDis = getDis(node.x, node.y, x, y);
                    for (int[] d : directs) {
                        // 剪枝 不是走每一个分支,选择距离越来越短的 较小的距离 不需要 剪枝Math.abs(x) + Math.abs(y)<=4
                        if (preDis > getDis(d[0] + node.x, d[1] + node.y, x, y) ||  Math.abs(x) + Math.abs(y)<=4 ) {
                            tempQueue.add(new Node(node.count + 1, d[0] + node.x, d[1] + node.y));
                        }

                    }
                }
               deque = tempQueue;
            }

        return -1;

    }
        private int getDis(int srcX, int srcY, int dstX, int dstY) { // 计算曼哈顿距离
            return Math.abs(srcX - dstX) + Math.abs(srcY - dstY);
        }



    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().minKnightMoves(2, 1);
    }
  
}
