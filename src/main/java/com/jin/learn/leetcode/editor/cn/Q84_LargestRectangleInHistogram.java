//  [84]柱状图中最大的矩形

//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
// Related Topics 栈 数组 单调栈 👍 1992 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Deque;



public class Q84_LargestRectangleInHistogram{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        // 暴力  O(n2)
        public int largestRectangleArea1(int[] heights) {
            int ans =0;
            for (int i = 0; i < heights.length; i++) {
                int v = heights[i];
                int l = i;
                int r = i;

                while (l>=0 && heights[l] >= v) l--;
                while (r< heights.length && heights[r] >= v) r++;

                ans = Math.max(ans, (r - l-1) * v);
            }
            return ans;
        }



        // 单调递增栈
        public int largestRectangleArea2(int[] heights) {
            int len = heights.length;
            if (len == 0) {
                return 0;
            }
            if (len == 1) {
                return heights[0];
            }

            int res = 0;
            Deque<Integer> stack = new ArrayDeque<>(len);
            for (int i = 0; i < len; i++) {

                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    int curHeight = heights[stack.pop()];

                    // 找一个左边界 小于 当前值
                    while (!stack.isEmpty() && curHeight < heights[stack.peek()]  ) {
                        stack.pop();
                    }

                    int curWidth;
                    if (stack.isEmpty()) {
                        curWidth = i;
                    } else {
                        curWidth = i - stack.peek() - 1;
                    }

                    res = Math.max(res, curHeight * curWidth);
                }
                // 比当前大的, 入栈 (因为面积可以扩大)
                stack.push(i);
            }
            // 解决 : 扩散到最后
            // [2,3,4,4]
            while (!stack.isEmpty()) {
                int curHeight = heights[stack.pop()];
                while (!stack.isEmpty() && heights[stack.peek()] == curHeight) {
                    stack.pop();
                }
                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = len;
                } else {
                    curWidth = len - stack.peek() - 1;
                }
                res = Math.max(res, curHeight * curWidth);
            }
            return res;
        }

        // 哨兵模式
        public int largestRectangleArea3(int[] heights) {
            heights= extend(heights);
            int len = heights.length;
            int res = 0;
            Deque<Integer> stack = new ArrayDeque<>(len);
            for (int i = 0; i < len; i++) {

                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    int curHeight = heights[stack.pop()];

                    // 找一个左边界 小于 当前值
                    while (!stack.isEmpty() && curHeight < heights[stack.peek()] ) stack.pop();

                    int curWidth = i - stack.peek() - 1;
                    res = Math.max(res, curHeight * curWidth);
                }
                // 比当前大的, 入栈 (因为面积可以扩大)
                stack.push(i);
            }
            return res;
        }

        // 左右都加 0, 不需要判空
        public int[]  extend (int[] heights){
            int[] ret = new int[heights.length + 2];
            System.arraycopy(heights, 0, ret, 1, heights.length);
            return ret;
        }


}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        int i = new Solution().largestRectangleArea1(new int[]{2, 1, 5, 6, 2, 3});
    }
  
}
