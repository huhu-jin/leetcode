//  [剑指 Offer 57]和为s的两个数字

//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,7,11,15], target = 9
//输出：[2,7] 或者 [7,2]
// 
//
// 示例 2： 
//
// 输入：nums = [10,26,30,31,47,60], target = 40
//输出：[10,30] 或者 [30,10]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^6 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 116 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class HeWeiSdeLiangGeShuZiLcof{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /*
      双指针i =0 j = nums.length-1;
      nums[i] + nums[j] > target; j--;
      nums[i] + nums[j] < target; i++;
     */


    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        int left = 0;
        int right = nums.length -1;
        while (left < right) {
            int togeter = nums[left] + nums[right];
            if (togeter < target) {
                left++;
            } else if (togeter > target) {
                right--;
            }else{
                return new int[]{nums[left], nums[right]};
            }
        }
        return new int[2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}