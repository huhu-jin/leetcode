//  [15]三数之和

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 排序 
// 👍 3488 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;


public class ThreeSum{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            LinkedList<List<Integer>> rets = new LinkedList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3) return Collections.emptyList();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && nums[i]<=0; i++) {
            twoSum(0 - nums[i], nums, i+1);
        }

        return rets;
    }

        HashSet<String> set = new HashSet<>();

        private void twoSum(int target, int[] nums, int start) {
            int end = nums.length-1;
            while (start < end) {
                if (nums[start] + nums[end] == target &&
                        !set.contains(""+(0-target)+nums[start]+nums[end])) {
                    set.add("" +(0-target) + nums[start] + nums[end]);
                    rets.add(Arrays.asList(nums[start], nums[end], 0 - target));
                } else if (nums[start] + nums[end] > target) {
                    end--;
                }else {
                    start++;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().threeSum(new int[]{-2,0,1,1,2});
    }
  
}