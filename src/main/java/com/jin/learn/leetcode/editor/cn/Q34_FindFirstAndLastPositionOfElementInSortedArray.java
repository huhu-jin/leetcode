//  [34]在排序数组中查找元素的第一个和最后一个位置

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 1109 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q34_FindFirstAndLastPositionOfElementInSortedArray{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length < 1) return new int[]{-1, -1};
        int pos = binarySearch(nums, target);
        int start = pos;
        int end = pos;

        for (;(start - 1 >= 0 && nums[start-1] == target) || ( end +1 < nums.length && nums[end+1] == target)  ; ) {
            if (start - 1 >= 0 &&  nums[start-1] == target) {
                start--;
            }
            if (end +1 < nums.length &&  nums[end+1] == target) {
                end++;
            }
        }

        return new int[]{start, end};
    }


    private int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
