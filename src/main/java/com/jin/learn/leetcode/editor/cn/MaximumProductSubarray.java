//  [152]乘积最大子数组

//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 1194 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class MaximumProductSubarray {


    //leetcode submit region begin(Prohibit modification and deletion)
    // 首先想到滑动窗口 没滑起来
    // dp 和 53一样 可以得出 dp[n] = max(dp[n-1]*nums[n],nums[n])
    // 但是不满足 最优子结构 错误
    // 当前位置的最优解未必是由前一个位置的最优解转移得到的
    class Solution {
         public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] maxF = new int[length];
        int[] minF = new int[length];
        System.arraycopy(nums, 0, maxF, 0, length);
        System.arraycopy(nums, 0, minF, 0, length);
        for (int i = 1; i < length; ++i) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
        }
        int ans = maxF[0];
        for (int i = 1; i < length; ++i) {
            ans = Math.max(ans, maxF[i]);
        }
        return ans;
    }

    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void testCase() {
       new Solution().maxProduct(new int[]{2,1,-2,-1,-3});
    }

}