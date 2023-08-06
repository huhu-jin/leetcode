//  [283]移动零

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 1153 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Arrays;


public class Q283_MoveZeroes{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 把0移动到后面, 并保持顺序不变
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length ==1) return;

        int left =0;
        while (left< nums.length && nums[left]!= 0) { // l 找到第一个0
            left++;
        }

        for (int right = left; right < nums.length; right++) { // r 找到非0
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;// 关键
            }
        }
    }

        private void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().moveZeroes(new int[]{0,1,1,1,1,0,3});
    }
  
}
