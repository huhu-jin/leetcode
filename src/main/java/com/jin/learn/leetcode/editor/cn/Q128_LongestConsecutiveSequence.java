//  [128]最长连续序列

//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// 
// Related Topics 并查集 数组 哈希表 
// 👍 838 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.TreeSet;


public class Q128_LongestConsecutiveSequence{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        TreeSet<Integer> set = new TreeSet<>();
        public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length ==0) return 0;
        for (int i : nums) {
            set.add(i);
        }
        int max = Integer.MIN_VALUE;
        Integer pre = null;
        int temp = 1;
        for (int i : set) {
            if (pre != null && pre == i - 1) {
                max = Math.max(++temp, max);
            }else if(pre != null){
                temp =1;
            }
            pre = i;
        }
        return Math.max(temp, max);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
