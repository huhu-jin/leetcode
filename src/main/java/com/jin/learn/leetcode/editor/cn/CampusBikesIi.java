//  [1066]校园自行车分配 II

//在由 2D 网格表示的校园里有 n 位工人（worker）和 m 辆自行车（bike），n <= m。所有工人和自行车的位置都用网格上的 2D 坐标表示。 
//
//
// 我们为每一位工人分配一辆专属自行车，使每个工人与其分配到的自行车之间的曼哈顿距离最小化。 
//
// p1 和 p2 之间的曼哈顿距离为 Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|。 
//
// 返回每个工人与分配到的自行车之间的曼哈顿距离的最小可能总和。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
//输出：6
//解释：
//自行车 0 分配给工人 0，自行车 1 分配给工人 1 。分配得到的曼哈顿距离都是 3, 所以输出为 6 。
// 
//
// 示例 2： 
//
// 
//
// 输入：workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
//输出：4
//解释：
//先将自行车 0 分配给工人 0，再将自行车 1 分配给工人 1（或工人 2），自行车 2 给工人 2（或工人 1）。如此分配使得曼哈顿距离的总和为 4。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= workers[i][0], workers[i][1], bikes[i][0], bikes[i][1] < 1000 
// 所有工人和自行车的位置都不相同。 
// 1 <= workers.length <= bikes.length <= 10 
// 
// Related Topics 位运算 数组 动态规划 回溯 状态压缩 
// 👍 69 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class CampusBikesIi{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int minDistance = Integer.MAX_VALUE;
        public int assignBikes(int[][] workers, int[][] bikes) {
            return helper(workers, bikes, new int[bikes.length], 0);
        }

        /**
         *
         * @param workers
         * @param bikes
         * @param visited   代表访问过的自行车
         * @param index     代表当前遍历到的工人
         * @return
         */
        public int helper(int[][] workers, int[][] bikes, int[] visited, int index) {
            if (index == workers.length) {
                return 0;
            }

            for (int i = 0; i < bikes.length; i++) {
                if (visited[i] == 0) {
                    int distance = Manhattan(workers[index][0], workers[index][1], bikes[i][0], bikes[i][1]);
                    visited[i] = 1;
                    minDistance = Math.min(minDistance, distance + helper(workers, bikes, visited, index + 1));
                    visited[i] = 0;
                }
            }
            return minDistance;
        }

        public int Manhattan(int x1, int y1, int x2, int y2) {
            return Math.abs(x1 - x2) + Math.abs(y1 - y2);
        }

}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().assignBikes(new int[][]{{0, 0}, {2, 1}}, new int[][]{{1, 2}, {3, 3}});
    }
  
}