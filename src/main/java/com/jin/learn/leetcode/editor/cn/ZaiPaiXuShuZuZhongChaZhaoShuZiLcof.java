//  [剑指 Offer 53 - I]在排序数组中查找数字 I

//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 145 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;


public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null) return 0;
        int count = 0;

        int pos = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            pos = (left + right) / 2;
            if (target < nums[pos]) {
                right = pos - 1; // 这步骤 比较关键
            } else if (target > nums[pos]) {
                left = pos + 1;
            } else {
                count++;
                break;
            }
        }


        // 向左搜索
        for (int i = pos-1; i >= 0; i--) {
            if (nums[i] == target) {
                count++;
            }else {
                break;
            }
        }

        // 向右搜索
        for (int i = pos+1; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
            }else {
                break;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        Assert.assertEquals(new Solution().search(new int[]{1,1,1,1,2,4,4,4,5,5,7,7,7,8,8,9,9,11,11,12,12,12,12}, 5),2);
        Assert.assertEquals(new Solution().search(new int[]{5,7,7,8,8,10}, 8),2);
        Assert.assertEquals(new Solution().search(new int[]{5,7,7,8,8,10}, 6),0);

    }
  
}