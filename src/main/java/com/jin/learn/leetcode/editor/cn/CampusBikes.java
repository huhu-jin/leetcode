//  [1057]校园自行车分配

//在由 2D 网格表示的校园里有 n 位工人（worker）和 m 辆自行车（bike），n <= m。所有工人和自行车的位置都用网格上的 2D 坐标表示。 
//
//
// 我们需要为每位工人分配一辆自行车。在所有可用的自行车和工人中，我们选取彼此之间曼哈顿距离最短的工人自行车对 (worker, bike) ，并将其中的自行
//车分配給工人。如果有多个 (worker, bike) 对之间的曼哈顿距离相同，那么我们选择工人索引最小的那对。类似地，如果有多种不同的分配方法，则选择自行车索
//引最小的一对。不断重复这一过程，直到所有工人都分配到自行车为止。 
//
// 给定两点 p1 和 p2 之间的曼哈顿距离为 Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|。 
//
// 返回长度为 n 的向量 ans，其中 a[i] 是第 i 位工人分配到的自行车的索引（从 0 开始）。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
//输出：[1,0]
//解释：
//工人 1 分配到自行车 0，因为他们最接近且不存在冲突，工人 0 分配到自行车 1 。所以输出是 [1,0]。
// 
//
// 示例 2： 
//
// 
//
// 输入：workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
//输出：[0,2,1]
//解释：
//工人 0 首先分配到自行车 0 。工人 1 和工人 2 与自行车 2 距离相同，因此工人 1 分配到自行车 2，工人 2 将分配到自行车 1 。因此输出为 
//[0,2,1]。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= workers[i][j], bikes[i][j] < 1000 
// 所有工人和自行车的位置都不相同。 
// 1 <= workers.length <= bikes.length <= 1000 
// 
// Related Topics 贪心 数组 排序 
// 👍 72 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class CampusBikes{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        class Wrapper {

            int worker;

            int bike;

            int distance;

            Wrapper(int _worker, int _bike, int[] p1, int[] p2) {
                worker = _worker;
                bike = _bike;
                distance = manhattan(p1[0], p1[1], p2[0], p2[1]);
            }
        }

        // 排序 校园自行车分配
        public int[] assignBikes(int[][] workers, int[][] bikes) {
            int n = workers.length;
            int m = bikes.length;
            int[] ans = new int[n];
            List<Wrapper> collector = new ArrayList<>();
            Set<Integer> w = new HashSet<>();
            Set<Integer> v = new HashSet<>();
            // 全都排序
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    collector.add(new Wrapper(i, j, workers[i], bikes[j]));
                }
            }
            // 排序 距离优先 , 再是worker 再是bike
            collector.sort((o1, o2) -> o1.distance != o2.distance ? o1.distance - o2.distance : o1.worker != o2.worker ? o1.worker - o2.worker : o1.bike - o2.bike);
            for (Wrapper wrapper : collector) {
                if (!w.contains(wrapper.worker) && !v.contains(wrapper.bike)) {
                    ans[wrapper.worker] = wrapper.bike;
                    w.add(wrapper.worker);
                    v.add(wrapper.bike);
                }
            }
            return ans;
        }

        private int manhattan(int x1, int y1, int x2, int y2) {
            return Math.abs(x1 - x2) + Math.abs(y1 - y2);
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}