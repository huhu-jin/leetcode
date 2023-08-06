//  [410]分割数组的最大值

//给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。 
//
// 设计一个算法使得这 m 个子数组各自和的最大值最小。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [7,2,5,10,8], m = 2
//输出：18
//解释：
//一共有四种方法将 nums 分割为 2 个子数组。 
//其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
//因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4,5], m = 2
//输出：9
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,4,4], m = 3
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 10⁶ 
// 1 <= m <= min(50, nums.length) 
// 
// Related Topics 贪心 数组 二分查找 动态规划 👍 692 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Arrays;



public class Q410_SplitArrayLargestSum{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int splitArray(int[] nums, int m) {
        // ans 一定是在最大 sum 和 单个最大 值 之间
        int sum = Arrays.stream(nums).sum();
        int max = Arrays.stream(nums).max().getAsInt();
        return binary(nums, m, sum, max);
    }
        // 二分查找
        private int binary(int[] nums, int m, int high, int low) {
            while (low <= high) {
                int mid = low +(high-low)/2;
                if (valid(nums, m, mid)) high = mid -1;
                else low = mid +1;
            }
            return low;
        }

        // 验证:  array分m份, 且每份< subArraySum
        private boolean valid(int[] nums, int m, int subArraySum) {
            int curSum = 0, count =1;
            for (int num : nums) {
                curSum += num;
                if (curSum > subArraySum) { // 累加到 >subArraySum时候 计算份书
                    curSum = num;
                    count ++;
                    if (count > m) return false;
                }
            }
            return true;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
