//  [47]全排列 II

//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 👍 1408 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Q47_PermutationsIi{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> ret = new LinkedList<>();
            if (nums == null || nums.length < 1) return ret;
            Arrays.sort(nums); // 排序（升序或者降序都可以），排序是剪枝的前提
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
                    // https://leetcode.cn/problems/permutations-ii/solutions/9917/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
                    if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                        continue;
                    }
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
    public void testCase(){
        
    }
  
}
