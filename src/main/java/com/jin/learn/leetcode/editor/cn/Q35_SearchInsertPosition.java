//  [35]搜索插入位置

//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 为 无重复元素 的 升序 排列数组 
// -10⁴ <= target <= 10⁴ 
// 
// Related Topics 数组 二分查找 👍 1593 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Q35_SearchInsertPosition{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 二分搜索
    public int searchInsert(int[] nums, int target) {
        int l =0;
        int r = nums.length-1;
        while (l <= r) {
            int mid = l + (r-l)/2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid+1;  //  找小的 l 先, return l
            }else {
                r = mid - 1;
            }
        }
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        int i = new Solution().searchInsert(new int[]{1, 3, 5, 6}, 5);
        Assert.assertEquals(i, 2);

         i = new Solution().searchInsert(new int[]{1, 3, 5, 6}, 2);
        Assert.assertEquals(i, 1);

         i = new Solution().searchInsert(new int[]{1, 3, 5, 6}, 7);
        Assert.assertEquals(i, 4);
    }
  
}
