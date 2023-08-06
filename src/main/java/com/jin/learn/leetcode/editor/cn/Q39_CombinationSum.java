//  [39]组合总和

//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯 
// 👍 1431 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;


public class Q39_CombinationSum{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        List<List<Integer>> ret = new LinkedList<>();
        Set<String> memo = new HashSet<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if(candidates == null) return ret;
            backTrack(candidates, target, new LinkedList<>());
            return  ret;
    }
    // 回溯
    private void backTrack(int[] candidates, int target, LinkedList<Integer> path) {
        if (target == 0 ) {
            LinkedList<Integer> temp = new LinkedList<>(path);
            // 去重
            String key =  temp.stream().sorted().map(String::valueOf).reduce("", String::concat);
            if (!memo.contains(key)) {
                memo.add(key);
                ret.add(temp);
            }
        }

        for (int i = candidates.length - 1; i >= 0; i--) {
            if (candidates[i] <= target) { // 按条件减枝 去除不可能情况
                path.add(candidates[i]);
                backTrack(candidates, target - candidates[i], path);// 递归所有的情况
                path.pollLast(); // 回溯 ,回退路径  !!重要
            }
        }
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7);
    }
  
}
