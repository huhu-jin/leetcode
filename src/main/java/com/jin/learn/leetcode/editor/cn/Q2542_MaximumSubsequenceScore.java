//  [2542]最大子序列的分数

//给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，两者长度都是 n ，再给你一个正整数 k 。你必须从 nums1 中选一个长度为 k 的 
//子序列 对应的下标。 
//
// 对于选择的下标 i0 ，i1 ，...， ik - 1 ，你的 分数 定义如下： 
//
// 
// nums1 中下标对应元素求和，乘以 nums2 中下标对应元素的 最小值 。 
// 用公示表示： (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1
//], ... ,nums2[ik - 1]) 。 
// 
//
// 请你返回 最大 可能的分数。 
//
// 一个数组的 子序列 下标是集合 {0, 1, ..., n-1} 中删除若干元素得到的剩余集合，也可以不删除任何元素。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,3,3,2], nums2 = [2,1,3,4], k = 3
//输出：12
//解释：
//四个可能的子序列分数为：
//- 选择下标 0 ，1 和 2 ，得到分数 (1+3+3) * min(2,1,3) = 7 。
//- 选择下标 0 ，1 和 3 ，得到分数 (1+3+2) * min(2,1,4) = 6 。
//- 选择下标 0 ，2 和 3 ，得到分数 (1+3+2) * min(2,3,4) = 12 。
//- 选择下标 1 ，2 和 3 ，得到分数 (3+3+2) * min(1,3,4) = 8 。
//所以最大分数为 12 。
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,2,3,1,1], nums2 = [7,5,10,9,6], k = 1
//输出：30
//解释：
//选择下标 2 最优：nums1[2] * nums2[2] = 3 * 10 = 30 是最大可能分数。
// 
//
// 
//
// 提示： 
//
// 
// n == nums1.length == nums2.length 
// 1 <= n <= 10⁵ 
// 0 <= nums1[i], nums2[j] <= 10⁵ 
// 1 <= k <= n 
// 
//
// Related Topics 贪心 数组 排序 堆（优先队列） 👍 46 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.cn/problems/maximum-subsequence-score/solutions/2073096/zui-xiao-dui-wei-hu-zui-da-k-ge-shu-zhi-v6hdk/?envType=study-plan-v2&envId=leetcode-75
// 不会
public class Q2542_MaximumSubsequenceScore{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public long maxScore(int[] nums1, int[] nums2, int k) {
            long res = 0L;
            int n = nums1.length;

            // 数组 nums2 按降序排列后的下标。
            Integer[] ids = new Integer[n];
            for (int i = 0; i < n; ++i) ids[i] = i;
            Arrays.sort(ids, (i, j) -> nums2[j] - nums2[i]);

            // nums1 的前 k - 1 个值的和
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();  // 小根堆
            long sum1 = 0L;
            for (int i = 0; i < k - 1; ++i) {
                int id = ids[i];
                sum1 += nums1[id];
                minHeap.offer(nums1[id]);
            }

            // 从第 k 个元素（下标 k - 1）开始计算
            for (int i = k - 1; i < n; ++i) {
                int id = ids[i];
                int num1 = nums1[id];
                // 1. 加上 num1，构成 k 个数
                sum1 += num1;
                minHeap.offer(num1);
                // 2. 比较
                res = Math.max(sum1 * nums2[id], res);
                // 3. 删除 k 个数中最小的数
                sum1 -= minHeap.poll();
            }

            return res;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){

        new Solution().maxScore(new int[]{1,3,3,2}, new int[]{2,1,3,4}, 3);
        
    }
  
}