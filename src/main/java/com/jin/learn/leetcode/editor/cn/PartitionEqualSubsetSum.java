//  [416]分割等和子集

//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 
// 👍 881 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class PartitionEqualSubsetSum{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public boolean canPartition(int[] nums) {
            int n = nums.length;
            if (n < 2) {
                return false;
            }
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 != 0) {
                return false;
            }
            int target = sum / 2;
//
//            boolean[][] dp = new boolean[n][target + 1];
//            // 初始条件
//            for (int i = 0; i < n; i++) {
//                dp[i][0] = true;
//            }
//            if (nums[0] > target) {
//                return false;
//            }
//            dp[0][nums[0]] = true; // 初始条件
//
//            for (int i = 1; i < n; i++) {
//                for (int j = 1; j <= target; j++) {
//                    if (j >= nums[i]) {
//                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
//                    } else {
//                        dp[i][j] = dp[i - 1][j];
//                    }
//                }
//            }
//            return dp[n - 1][target];

            // 且需要注意的是第二层的循环我们需要从大到小计算，因为如果我们从小到大更新 dp 值，那么在计算 dp[j] 值的时候，
            // dp[j−nums[i]] 已经是被更新过的状态，不再是上一行的dp 值。
            // 采用从大到小更新
            boolean[] dp = new boolean[target + 1];
            dp[0] = true;
            for (int i = 0; i < n; i++) {
                for (int j = target; j >= nums[i]; --j) {
                    dp[j] |= dp[j - nums[i]];
                }
            }
            return dp[target];


        }


    }

//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().canPartition(new int[]{1, 5, 10, 6});
    }
  
}