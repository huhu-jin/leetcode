//  [325]和等于 k 的最长子数组长度

//给定一个数组 nums 和一个目标值 k，找到和等于 k 的最长连续子数组长度。如果不存在任意一个符合要求的子数组，则返回 0。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,-1,5,-2,3], k = 3
//输出: 4 
//解释: 子数组 [1, -1, 5, -2] 和等于 3，且长度最长。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,-1,2,1], k = 1
//输出: 2 
//解释: 子数组 [-1, 2] 和等于 1，且长度最长。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 105 
// -104 <= nums[i] <= 104 
// -109 <= k <= 109 
// 
//
// 
//
// 进阶: 
//你能使时间复杂度在 O(n) 内完成此题吗? 
// Related Topics 数组 哈希表 
// 👍 126 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.HashMap;



public class MaximumSizeSubarraySumEqualsK{


    //leetcode submit region begin(Prohibit modification and deletion)
    // 利用前缀和
    // 核心思想: 其中preSum[j] 表示j位置的前缀和 不是数组
    // preSum[i] + k(多个连续子序列的和)  =  preSum[j]
    // preSum 和 index 放入map中作为key value,
    // j - map.get(preSum[j] - k) = k
    class Solution {

        private HashMap<Integer, Integer> map = new HashMap<>();
        private int ans =0;
        public int maxSubArrayLen(int[] nums, int k) {

            int preSum = -nums[0];// 为了构建0的前缀和0 方便迭代
            map.put(preSum, -1); //为了解决 [4] 4的case

            for (int i =0; i < nums.length; i++) {
                preSum += nums[i];
                // 越前面的 前缀和越好,所以防止再次put
                if(!map.containsKey(preSum)) map.put(preSum, i);
                if (map.containsKey(preSum - k)) {
                    ans = Math.max(ans, i - map.get(preSum - k));
                }
            }
            return ans;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        Solution solution = new Solution();
        solution.maxSubArrayLen(new int[]{1,-1,5,-2,3}, 3);
    }
  
}