//  [485]最大连续 1 的个数

//给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,0,1,1,1]
//输出：3
//解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
// 
//
// 示例 2: 
//
// 
//输入：nums = [1,0,1,1,0,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 不是 0 就是 1. 
// 
//
// Related Topics 数组 👍 416 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q485_MaxConsecutiveOnes{
  
  // 不用看
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans =0;
        int i=0;
        int temp=0;
        for (i=0; i< nums.length;i++) {
            if (nums[i] ==  0) {
                ans = Math.max(temp, ans);
                temp =0;
            }else {

                temp++;
            }
        }
        return Math.max(temp, ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1});
    }
  
}