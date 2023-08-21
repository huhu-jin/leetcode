//  [1493]删掉一个元素以后全为 1 的最长子数组

//给你一个二进制数组 nums ，你需要从中删掉一个元素。 
//
// 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。 
//
// 如果不存在这样的子数组，请返回 0 。 
//
// 
//
// 提示 1： 
//
// 
//输入：nums = [1,1,0,1]
//输出：3
//解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1,1,0,1,1,0,1]
//输出：5
//解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,1]
//输出：2
//解释：你必须要删除一个元素。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 要么是 0 要么是 1 。 
// 
//
// Related Topics 数组 动态规划 滑动窗口 👍 97 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q1493_LongestSubarrayOf1sAfterDeletingOneElement{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 同 1004
    public int longestSubarray(int[] nums) {
        int i = 0;
        int j = 0;
        int ans = 0;
        int temp =0;
        int k=1;
        while (j < nums.length) {

            if (nums[j] == 1) {
                temp ++ ;
                j++;
            } else if (nums[j] == 0 & k > 0) {
                j++;
                k--;
                temp++;
            }else {
                if (i < j && nums[i] == 0) {
                    k++;
                }

                if (i == j) {
                    j++;
                }else{
                    temp--;
                }

                i++;
            }


            ans = Math.max(ans, temp);
        }




        return ans-1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}