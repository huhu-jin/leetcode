//  [31]下一个排列

//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 双指针 
// 👍 1217 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Arrays;


public class NextPermutation {


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 1 p <- nums.length-2, m <- nums.length-1, m--, 在m>p,  找一个 nums[p]<nums[m]
        // 2 交换
        // 3 p+1以后排序
        public void nextPermutation(int[] nums) {
            if (nums == null || nums.length <= 1) return;
            // 关键在于如何找升序 才是 next
            for (int p = nums.length - 2; p >= 0; p--) {
                for (int m = nums.length -1 ; m >p; m--) {
                    if (nums[p] < nums[m]) {
                        swap(nums, m, p);
                        Arrays.sort(nums, p+1, nums.length);
                        return;
                    }
                }
            }
            Arrays.sort(nums); // 都是逆序
        }

        private void swap(int[] nums, int h, int l) {
            nums[h] = nums[h] ^ nums[l];
            nums[l] = nums[h] ^ nums[l];
            nums[h] = nums[h] ^ nums[l];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void testCase() {
        new Solution().nextPermutation(new int[]{4, 2, 0, 2, 3, 2, 0});
        new Solution().nextPermutation(new int[]{1, 2, 3});
        new Solution().nextPermutation(new int[]{1,2});
    }

}