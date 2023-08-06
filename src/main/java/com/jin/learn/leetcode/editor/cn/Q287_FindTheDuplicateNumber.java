//  [287]寻找重复数

//给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。 
//
// 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。 
//
// 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,4,2,2]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,3,4,2]
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1]
//输出：1
// 
//
// 示例 4： 
//
// 
//输入：nums = [1,1,2]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 105 
// nums.length == n + 1 
// 1 <= nums[i] <= n 
// nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次 
// 
//
// 
//
// 进阶： 
//
// 
// 如何证明 nums 中至少存在一个重复的数字? 
// 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？ 
// 
// Related Topics 位运算 数组 双指针 二分查找 
// 👍 1318 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q287_FindTheDuplicateNumber{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 核心思想是 在i位上 具有i的值 .
    // 检查 i位上的值 的位置是否被占 .
    public int findDuplicate(int[] nums) {
        if(nums == null) return 0;
        int i = 0;
        while (i<nums.length){
            int value = nums[i];
            if(i+1 == value){
                i++;
                continue;
            }
            if(nums[value-1] == value) return value;
            swap(nums, i, value-1);
        }
        return 0;
    }

        private void swap(int[] nums, int i, int value) {
            int temp = nums[i];
            nums[i] = nums[value];
            nums[value] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        int[] input = new int[]{8, 7, 1, 10, 17, 15, 18, 11, 16, 9, 19, 12, 5, 14, 3, 4, 2, 13, 18, 18};
        new Solution().findDuplicate(input);
    }
  
}
