
//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// 
// 
// Related Topics 数组 回溯算法 
// 👍 537 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;


public class SubsetsIi{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        LinkedList<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        backTrack(nums, 0);
        return result;
    }

        void backTrack(int[] nums, Integer start) {
            result.push(new LinkedList<>(path));
            HashSet<Integer> uset = new HashSet<>();
            for (int i = start; i < nums.length; i++) {
                if (!uset.contains(nums[i])) {
                    uset.add(nums[i]);
                    path.add(nums[i]);
                    backTrack(nums, i + 1);
                    path.pollLast();
                }
            }

        }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().subsetsWithDup(new int[]{1, 2, 2});
    }
  
}