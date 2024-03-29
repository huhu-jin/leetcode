//  [1]两数之和

//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 103 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
// Related Topics 数组 哈希表 
// 👍 10441 👎 0


package com.jin.learn.leetcode.editor.cn;


import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Q1_TwoSum {
    //leetcode submit region begin(Prohibit modification and deletion)
    // 0(n) 关键点在于 边迭代边add 入map中
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[]{map.get(complement), i};
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }
    // nlog(n) 排序双指针
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void testCase() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] ints = new Solution().twoSum(nums, target);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }


}
