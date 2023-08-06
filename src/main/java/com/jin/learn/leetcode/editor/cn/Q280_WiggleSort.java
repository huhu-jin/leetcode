//  [280]摆动排序

//给你一个无序的数组 nums, 将该数字 原地 重排后使得 nums[0] <= nums[1] >= nums[2] <= nums[3]...。 
//
// 示例: 
//
// 输入: nums = [3,5,2,1,6,4]
//输出: 一个可能的解答是 [3,5,1,6,2,4] 
// Related Topics 贪心 数组 排序 
// 👍 66 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Arrays;


public class Q280_WiggleSort{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i+1 < nums.length; i += 2) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i+1] = temp;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
