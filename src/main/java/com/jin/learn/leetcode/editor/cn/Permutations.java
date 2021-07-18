//  [46]全排列

//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 
// 👍 1448 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Permutations{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<Integer>> ret = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length<1) return ret;
        backTrack(nums, new LinkedList<>());
        return ret;
    }

        private void backTrack(int[] nums, LinkedList<Integer> path) {

            if (path.size() == nums.length) {
                ret.add(new LinkedList<>(path));
            }
            for (int i : nums) {
                if(!path.contains(i)) {// 剪枝
                    path.add(i);
                    backTrack(nums, path);
                    path.pollLast(); // 回溯
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}