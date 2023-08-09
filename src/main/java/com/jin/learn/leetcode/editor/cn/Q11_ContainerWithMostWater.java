//  [11]盛最多水的容器

//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：height = [4,3,2,1,4]
//输出：16
// 
//
// 示例 4： 
//
// 
//输入：height = [1,2,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// n = height.length 
// 2 <= n <= 3 * 104 
// 0 <= height[i] <= 3 * 104 
// 
// Related Topics 贪心 数组 双指针 
// 👍 2602 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q11_ContainerWithMostWater{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
    // 双指针left right
    // 从两端向内移动,短那段向内移动
    //s(l,r) =  min(h[l],h[r])* (r-l)
    // 证明:
    // 1 如果 移动是长边 一定小于 未移动的面积.因为面积是短边决定

class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int l = 0;
        int r = height.length - 1;
        int size = 0;

        while (l < r) {
            size = Math.max(Math.min(height[l], height[r]) * (r - l), size);
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }

        return size;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution();
    }
  
}
