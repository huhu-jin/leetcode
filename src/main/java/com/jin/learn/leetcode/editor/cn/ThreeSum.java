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


public class ThreeSum {


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 类似于两数字和,关键在于去重
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new LinkedList<>();
            if (nums == null || nums.length < 3) return ans;

            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i++) {
                if(nums[i]>0) break; // 不可能, 节约时间
                if (i>0 && nums[i] == nums[i-1]) continue; // 去重
                int left = i +1;
                int right = nums.length - 1;

                while (left < right) {
                    if (left == i || nums[left] + nums[right] + nums[i] < 0) {
                        left++;
                    } else if (right == i || nums[left] + nums[right] + nums[i] > 0) {
                        right--;
                    } else {
                        ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        // 去重
                        while (left < right && nums[left] == nums[left+1]) left++;
                        while (left < right && nums[right] == nums[right-1]) right--;
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