//  [53]最大子序和

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：nums = [-1]
//输出：-1
// 
//
// 示例 5： 
//
// 
//输入：nums = [-100000]
//输出：-100000
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治 动态规划 
// 👍 3430 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class MaximumSubarray{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // dp 关键是看 tempMax是负数 就丢了
    public int maxSubArray(int[] nums) {
        int tempMax = nums[0];
        int max = tempMax;

        for (int i = 1; i < nums.length; i++) {
            if (tempMax  > 0) {
                tempMax += nums[i];
            }else {
                tempMax = nums[i];
            }
            max = Math.max(tempMax, max);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }
  
}