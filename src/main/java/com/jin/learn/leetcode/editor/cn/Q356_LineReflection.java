//  [356]直线镜像

//在一个二维平面空间中，给你 n 个点的坐标。问，是否能找出一条平行于 y 轴的直线，让这些点关于这条直线成镜像排布？ 
//
// 注意：题目数据中可能有重复的点。 
//
// 
//
// 进阶：你能找到比 O(n2) 更优的解法吗? 
//
// 
//
// 示例 1： 
//
// 
//输入：points = [[1,1],[-1,1]]
//输出：true
//解释：可以找出 x = 0 这条线。
// 
//
// 示例 2： 
//
// 
//输入：points = [[1,1],[-1,-1]]
//输出：false
//解释：无法找出这样一条线。 
//
// 
//
// 提示： 
//
// 
// n == points.length 
// 1 <= n <= 10^4 
// -10^8 <= points[i][j] <= 10^8 
// 
// Related Topics 数组 哈希表 数学 
// 👍 22 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.HashSet;


public class Q356_LineReflection{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public boolean isReflected(int[][] points) {
            int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
            HashSet<String> set = new HashSet<>(); // 存储不重复的元素
            for (int[] point : points) {
                minX = Math.min(minX, point[0]);
                maxX = Math.max(maxX, point[0]);
                set.add(point[0] + "" + point[1]);
            }
            double sum = minX + maxX; // x坐标 对称点
            for (int[] point : points) {
                if (!set.contains((int)(sum-point[0]) + "" + point[1])) // 查找对称点
                    return false;
            }
            return true;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().isReflected(new int[][]{{1, 1}, {-1, 1}});
    }
  
}
