//  [42]接雨水

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 
// 👍 2490 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Deque;
import java.util.LinkedList;


public class Q42_TrappingRainWater{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    // 单调递减栈
    // 他是一层一层 计算的
    // https://leetcode.cn/problems/trapping-rain-water/solution/trapping-rain-water-by-ikaruga/
    public int trap(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < height.length; ++i) {

            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop(); // 底
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek(); // 新顶做为left
                int currWidth = i - left - 1; // i -left + 1 -2   i 为右边,
                int currHeight = Math.min(height[left], height[i]) - height[top]; //  height[top] 想对高度
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }




}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }
  
}
