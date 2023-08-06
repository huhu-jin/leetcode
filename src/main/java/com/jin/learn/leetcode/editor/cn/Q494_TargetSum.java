//  [494]目标和

//给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
// Related Topics 数组 动态规划 回溯 
// 👍 854 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q494_TargetSum{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // dp类似01背包问题
    // 递推公式比较理解 dp[i][j] = dp[i - 1][j - nums[i]] + dp[i - 1][j + nums[i]];
    // 两倍长度比较难 边界条件比较难
    public int findQ494_TargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        // 绝对值范围超过了sum的绝对值范围则无法得到
        if (Math.abs(target) > Math.abs(sum)) return 0;
        int len = nums.length;
        int range = sum * 2 + 1;//因为要包含负数所以要两倍，又要加上0这个中间的那个情况
        int[][] dp = new int[len][range];//这个数组是从总和为-sum开始的
        //加上sum纯粹是因为下标界限问题，赋第二维的值的时候都要加上sum
        // 初始化   第一个数只能分别组成+-nums[i]的一种情况
        dp[0][sum + nums[0]] += 1;
        dp[0][sum - nums[0]] += 1;
        for (int i = 1; i < len; i++) {
            for (int j = -sum; j <= sum; j++) {
                if((j+nums[i]) > sum) {//+不成立 加上当前数大于了sum   只能减去当前的数
                    dp[i][j+sum] = dp[i-1][j-nums[i]+sum]+0;
                }else if((j-nums[i]) < -sum) {//-不成立  减去当前数小于-sum   只能加上当前的数
                    dp[i][j+sum] = dp[i-1][j+nums[i]+sum]+0;
                }else {//+-都可以
                    dp[i][j+sum] = dp[i-1][j+nums[i]+sum]+dp[i-1][j-nums[i]+sum];
                }
            }
        }
        return dp[len - 1][sum + target]; // - 0 + 中间位置sum值
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().findQ494_TargetSumWays(new int[]{1, 1, -1,1, -1, 1,1}, 3);
    }
  
}
