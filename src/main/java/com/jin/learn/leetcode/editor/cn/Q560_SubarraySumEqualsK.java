//  [560]和为K的子数组

//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。 
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
// 
//
// 说明 : 
//
// 
// 数组的长度为 [1, 20,000]。 
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。 
// 
// Related Topics 数组 哈希表 前缀和 
// 👍 1036 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q560_SubarraySumEqualsK{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // 首先是不能窗口滑动,因为有负数
        // 注意:前缀和概念
        // 前缀和相减就是 当前的数组
        public int subarraySum(int[] nums, int k) {
            int len = nums.length;

            int[] preSum = new int[len + 1];// 前缀和多一个
            preSum[0] = 0;
            //前缀和数组 除当前位置 所有前面和
            for (int i = 0; i < len; i++) {
                preSum[i + 1] = preSum[i] + nums[i];
            }

            int count = 0;
            for (int left = 0; left < len; left++) {
                for (int right = left; right < len; right++) {
                    // 区间和 [left..right]，注意下标偏移
                    if (preSum[right + 1] - preSum[left] == k) {
                        count++;
                    }
                }
            }
            return count;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().subarraySum(new int[]{1, 2, 2, 3, 4, 4}, 4);
        
    }
  
}
