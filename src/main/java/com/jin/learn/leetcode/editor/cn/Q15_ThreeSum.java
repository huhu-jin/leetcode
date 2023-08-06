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
import java.util.LinkedList;
import java.util.List;


public class Q15_ThreeSum {

    // 必须掌握

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 排序 双指针(注意去重复)
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new LinkedList<>();
            if (nums == null || nums.length < 3) return ans;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i>0&& nums[i-1] == nums[i]) continue; // 去除重复 -1 -1 -1 0 2
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[i] + nums[left] + nums[right] > 0) {
                        right--;
                    } else if (nums[i] + nums[left] + nums[right] < 0) {
                        left++;
                    } else {
                        ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left+1]) left++; // 去重 -1 0 0 0 1
                        while (left < right && nums[right] == nums[right-1]) right--; // 去重 -1 0 1 1 1
                        left++;
                        right--;
                    }
                }
            }
            return ans;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void testCase() {
        new Solution().threeSum(new int[]{-1,0,1,2,-1,-4});
    }

}
