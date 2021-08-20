//  [286]墙与门

//你被给定一个 m × n 的二维网格 rooms ，网格中有以下三种可能的初始化值： 
//
// 
// -1 表示墙或是障碍物 
// 0 表示一扇门 
// INF 无限表示一个空的房间。然后，我们用 231 - 1 = 2147483647 代表 INF。你可以认为通往门的距离总是小于 2147483647 
//的。 
// 
//
// 你要给每个空房间位上填上该房间到 最近门的距离 ，如果无法到达门，则填 INF 即可。 
//
// 
//
// 示例 1： 
//
// 
//输入：rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1]
//,[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
//输出：[[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
// 
//
// 示例 2： 
//
// 
//输入：rooms = [[-1]]
//输出：[[-1]]
// 
//
// 示例 3： 
//
// 
//输入：rooms = [[2147483647]]
//输出：[[2147483647]]
// 
//
// 示例 4： 
//
// 
//输入：rooms = [[0]]
//输出：[[0]]
// 
//
// 
//
// 提示： 
//
// 
// m == rooms.length 
// n == rooms[i].length 
// 1 <= m, n <= 250 
// rooms[i][j] 是 -1、0 或 231 - 1 
// 
// Related Topics 广度优先搜索 数组 矩阵 
// 👍 159 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class WallsAndGates{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    private  int INF = Integer.MAX_VALUE;
//    private int i;
//    private int j;
//    public void wallsAndGates(int[][] rooms) {
//        for ( i = 0; i < rooms.length; i++) {
//            for ( j = 0; j < rooms[i].length; j++) {
//                if (rooms[i][j] != 0 && rooms[i][j] != -1) {
//                    rooms[i][j] = backTacking(rooms, i, j);
//                }
//            }
//        }
//    }
//
//    private int backTacking(int[][] rooms, int i, int j) {
//        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] == -1) {
//            return INF;
//        }
//        // 防止 修改已经以前的值
//        if(rooms[i][j] == 0 || ( i* rooms[0].length + j< this.j + this.i* rooms[0].length)) return rooms[i][j];
//        rooms[i][j] = -1;
//        int near = Math.min(Math.min( backTacking(rooms, i + 1, j), backTacking(rooms, i - 1, j)), Math.min(backTacking(rooms, i, j -1), backTacking(rooms, i, j + 1)));
//        if (near != INF) {
//            rooms[i][j] = near + 1;
//        } else {
//            rooms[i][j] = INF;
//        }
//        return rooms[i][j];
//    }

        private  final int EMPTY = Integer.MAX_VALUE;
        private  final int GATE = 0;
        private  final List<int[]> DIRECTIONS = Arrays.asList(
                new int[] { 1,  0},
                new int[] {-1,  0},
                new int[] { 0,  1},
                new int[] { 0, -1}
        );

        public void wallsAndGates(int[][] rooms) {
            int m = rooms.length;
            int n = rooms[0].length;
            Queue<int[]> q = new LinkedList<>();
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (rooms[row][col] == GATE) {
                        q.add(new int[] { row, col });
                    }
                }
            }
            while (!q.isEmpty()) {
                int[] point = q.poll();
                int row = point[0];
                int col = point[1];
                for (int[] direction : DIRECTIONS) {
                    int r = row + direction[0];
                    int c = col + direction[1];
                    // 越近的越 快定位 所有 可以 通过 EMPTY 避免重复set
                    if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
                        continue;
                    }
                    rooms[r][c] = rooms[row][col] + 1;
                    q.add(new int[] { r, c });
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
//    new Solution().wallsAndGates(new int[][] {{0,2147483647,2147483647,0,-1,-1,0,0,0,-1,-1,0,2147483647,2147483647},{2147483647,-1,2147483647,-1,2147483647,0,-1,2147483647,-1,2147483647,2147483647,-1,-1,2147483647},{0,0,-1,2147483647,-1,2147483647,-1,-1,2147483647,0,0,2147483647,0,2147483647},{-1,0,2147483647,-1,0,0,-1,2147483647,0,2147483647,0,-1,0,-1}});
    new Solution().wallsAndGates(new int[][] {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}});


    }
  
}