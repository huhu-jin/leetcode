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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Q15_ThreeSum {

    // 必须掌握

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 排序 双指针(注意去重复)
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();

            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i++) {
                int target = -nums[i];
                int l=i+1;
                int r =nums.length-1;
                while (l  < r) {
                    if (nums[l] + nums[r] < target) {
                        l++;
                    }

                   else if (nums[l] + nums[r] > target) {
                        r--;
                    }else{
                       ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
                       while (l < r   && nums[r] == nums[r-1]) r--;  // 去重复
                       while (l  < r && nums[l] == nums[l+1]) l++;  // 去重复
                       r--;
                       l++;
                    }
                }


                while (i +1< nums.length && nums[i] == nums[i+1]) i++; // 去重复
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
