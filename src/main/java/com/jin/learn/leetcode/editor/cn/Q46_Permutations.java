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


public class Q46_Permutations {


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ret = new LinkedList<>();
            if (nums == null || nums.length < 1) return ret;
            boolean[] used = new boolean[nums.length];
            backTrack(nums, 0, used, new LinkedList<>(), ret);
            return ret;
        }

        /**
         *  全排序
         * @param nums 输入的元素
         * @param depth 递归的深度
         * @param used 是否使用过
         * @param path 当前的路径
         * @param ret 最后的结果
         */
        private void backTrack(int[] nums, int depth, boolean[] used, LinkedList<Integer> path, List<List<Integer>> ret) {
            if (depth == nums.length) {
                ret.add(new LinkedList<>(path));
            }

            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    path.add(nums[i]);
                    backTrack(nums, depth + 1, used, path, ret);
                    // 回溯
                    path.pollLast();
                    used[i] = false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void testCase() {

    }

}
