//  [360]有序转化数组

//给你一个已经 排好序 的整数数组 nums 和整数 a、b、c。对于数组中的每一个数 x，计算函数值 f(x) = ax2 + bx + c，请将函数值产生
//的数组返回。 
//
// 要注意，返回的这个数组必须按照 升序排列，并且我们所期望的解法时间复杂度为 O(n)。 
//
// 示例 1： 
//
// 输入: nums = [-4,-2,2,4], a = 1, b = 3, c = 5
//输出: [3,9,15,33]
// 
//
// 示例 2： 
//
// 输入: nums = [-4,-2,2,4], a = -1, b = 3, c = 5
//输出: [-23,-5,1,7]
// 
// Related Topics 数组 数学 双指针 排序 
// 👍 46 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.PriorityQueue;


public class Q360_SortTransformedArray{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int t = a * nums[i] * nums[i] + b * nums[i] + c;
            queue.offer(t);
        }
        for (int i = 0; i < n; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
