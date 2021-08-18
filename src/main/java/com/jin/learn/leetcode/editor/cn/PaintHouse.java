//  [256]粉刷房子

//假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。 
//
// 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵 cos
//ts 来表示的。 
//
// 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。 
//
// 请计算出粉刷完所有房子最少的花费成本。 
//
// 
//
// 示例 1： 
//
// 
//输入: costs = [[17,2,17],[16,16,5],[14,3,19]]
//输出: 10
//解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
//     最少花费: 2 + 5 + 3 = 10。
// 
//
// 示例 2： 
//
// 
//输入: costs = [[7,6,2]]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// costs.length == n 
// costs[i].length == 3 
// 1 <= n <= 100 
// 1 <= costs[i][j] <= 20 
// 
// Related Topics 数组 动态规划 
// 👍 126 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


public class PaintHouse{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private int[][] costs;
        private Map<String, Integer> memo;

        public int minCost(int[][] costs) {
            if (costs.length == 0) {
                return 0;
            }
            this.costs = costs;
            this.memo = new HashMap<>();
            return Math.min(paintCost(0, 0), Math.min(paintCost(0, 1), paintCost(0, 2)));
        }

        private int paintCost(int n, int color) {
            if (memo.containsKey(getKey(n, color))) {
                return memo.get(getKey(n, color));
            }
            int totalCost = costs[n][color];
            if (n == costs.length - 1) {
            } else if (color == 0) { // Red
                totalCost += Math.min(paintCost(n + 1, 1), paintCost(n + 1, 2));
            } else if (color == 1) { // Green
                totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 2));
            } else { // Blue
                totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 1));
            }
            memo.put(getKey(n, color), totalCost);

            return totalCost;
        }

        private String getKey(int n, int color) {
            return n + " " + color;
        }

}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}