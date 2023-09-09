//  [2389]和有限的最长子序列

//给你一个长度为 n 的整数数组 nums ，和一个长度为 m 的整数数组 queries 。 
//
// 返回一个长度为 m 的数组 answer ，其中 answer[i] 是 nums 中 元素之和小于等于 queries[i] 的 子序列 的 最大 长度
// 。 
//
// 子序列 是由一个数组删除某些元素（也可以不删除）但不改变剩余元素顺序得到的一个数组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,2,1], queries = [3,10,21]
//输出：[2,3,4]
//解释：queries 对应的 answer 如下：
//- 子序列 [2,1] 的和小于或等于 3 。可以证明满足题目要求的子序列的最大长度是 2 ，所以 answer[0] = 2 。
//- 子序列 [4,5,1] 的和小于或等于 10 。可以证明满足题目要求的子序列的最大长度是 3 ，所以 answer[1] = 3 。
//- 子序列 [4,5,2,1] 的和小于或等于 21 。可以证明满足题目要求的子序列的最大长度是 4 ，所以 answer[2] = 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,3,4,5], queries = [1]
//输出：[0]
//解释：空子序列是唯一一个满足元素和小于或等于 1 的子序列，所以 answer[0] = 0 。 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// m == queries.length 
// 1 <= n, m <= 1000 
// 1 <= nums[i], queries[i] <= 10⁶ 
// 
//
// Related Topics 贪心 数组 二分查找 前缀和 排序 👍 120 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Arrays;

// https://leetcode.cn/problems/longest-subsequence-with-limited-sum/description/
public class Q2389_LongestSubsequenceWithLimitedSum{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] answerQueries(int[] nums, int[] queries) {
            Arrays.sort(nums);
            for (int i = 1; i < nums.length; ++i)
                nums[i] += nums[i - 1]; // 原地求前缀和
            for (int i = 0; i < queries.length; i++)
                queries[i] = upperBound(nums, queries[i]); // 复用 queries 作为答案
            return queries;
        }

        // https://www.bilibili.com/video/BV1AP41137w7/
        // 返回 nums 中第一个大于 target 的数的下标（注意是大于，不是大于等于）
        // 如果这样的数不存在，则返回 nums.length
        // 时间复杂度 O(log nums.length)
        // 采用开区间写法实现
        private int upperBound(int[] nums, int target) {
            int left = -1, right = nums.length; // 开区间 (left, right)
            while (left + 1 < right) { // 区间不为空
                // 循环不变量：
                // nums[left] <= target
                // nums[right] > target
                int mid = left + (right - left) / 2;
                if (nums[mid] > target)
                    right = mid; // 范围缩小到 (left, mid)
                else
                    left = mid; // 范围缩小到 (mid, right)
            }
            return right;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}