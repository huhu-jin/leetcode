//  [704]二分查找

//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。 
//
// 
//示例 1: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
// 
//
// 示例 2: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设 nums 中的所有元素是不重复的。 
// n 将在 [1, 10000]之间。 
// nums 的每个元素都将在 [-9999, 9999]之间。 
// 
// Related Topics 二分查找 
// 👍 219 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Q704_BinarySearch{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null) return -1;
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            }else {
                return -1;
            }
        }
        int end = nums.length-1;
        int start = 0;
        while (start < end) {
            if(nums[start] == target) return start;
            if(nums[end] == target) return end;
            int middle = (start+end)/2;
            if (nums[middle] ==target){
                return middle;
            }else if(nums[middle] < target){
                if(start == middle) return -1;
                start = middle;
            }else {
                end = middle;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        Assert.assertEquals(-1,new Solution().search(new int[]{5},-5));
        Assert.assertEquals(0,new Solution().search(new int[]{5},5));
        Assert.assertEquals(4,new Solution().search(new int[]{-1,0,3,5,9,12},9));
        Assert.assertEquals(-1,new Solution().search(new int[]{-1,0,3,5,9,12},15));
    }
  
}
