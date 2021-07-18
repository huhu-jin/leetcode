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
        // 1 l 从倒数第2个开始, h 从最后一个开始, 找升序
        // 2  升序交换
        public void nextPermutation(int[] nums) {
            if (nums == null || nums.length <= 1) return;

            for (int l = nums.length - 2; l >= 0; l--) {
                for (int h = nums.length - 1; l < h; h--) {
                    if (nums[l] < nums[h]) {
                        swap(nums, h, l);
                        Arrays.sort(nums, l + 1, nums.length);
                        return;
                    }
                }
            }
            Arrays.sort(nums);
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
        new Solution().nextPermutation(new int[]{1,2});
        new Solution().nextPermutation(new int[]{4, 2, 0, 2, 3, 2, 0});
    }

}