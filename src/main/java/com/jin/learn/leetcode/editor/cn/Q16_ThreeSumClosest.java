//  [16]最接近的三数之和

//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
// Related Topics 数组 双指针 排序 👍 1150 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Q16_ThreeSumClosest{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 同15 排序 + 双指针
    public int threeSumClosest(int[] nums, int target) {
        Integer ans  = null;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i-1>0 && nums[i] == nums[i-1]) continue;
            int l = i+1;
            int r = nums.length - 1;
            while (l < r) {
                int value = nums[i] + nums[l] + nums[r];
                if( value == target) return target;
                if (ans == null || Math.abs(target - value) < Math.abs(target - ans)) ans = value;
                if (value< target) l++;
                else r--;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
