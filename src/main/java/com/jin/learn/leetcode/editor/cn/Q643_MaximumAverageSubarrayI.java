//  [643]子数组最大平均数 I

//给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。 
//
// 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。 
//
// 任何误差小于 10⁻⁵ 的答案都将被视为正确答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,12,-5,-6,50,3], k = 4
//输出：12.75
//解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
// 
//
// 示例 2： 
//
// 
//输入：nums = [5], k = 1
//输出：5.00000
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= k <= n <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 滑动窗口 👍 307 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

// 窗口滑动
// 不用看 主要边界条件
public class Q643_MaximumAverageSubarrayI{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length==1) return nums[0];
        int l =0;
        int r = k-1;
        double ans =0;
        double sum=0;

        for (int i = 0; i <=r; i++) {
            sum += nums[i];
        }
        ans = sum/k;

        l++;
        r++;

        while (r < nums.length) {

            sum = sum -nums[l-1] + nums[r];
            double temp = sum/k;
            ans = Math.max(ans, temp);
            l++;
            r++;

        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().findMaxAverage(new int[]{1, 12, -5, -6, 50, 3},1);
        new Solution().findMaxAverage(new int[]{1, 12, -5, -6, 50, 3},4);
    }
  
}