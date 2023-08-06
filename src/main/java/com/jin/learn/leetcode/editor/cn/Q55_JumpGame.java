//  [55]跳跃游戏

//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// 0 <= nums[i] <= 105 
// 
// Related Topics 贪心 数组 动态规划 
// 👍 1268 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q55_JumpGame{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 如果一个位置能够到达，那么这个位置左侧所有位置都能到达
    // 逐个迭代范围内,找最远的位置,扩大范围 再迭代
    public  boolean canJump(int[] nums) {
        if (nums == null) return false;
        int maxLength = 0;
        for (int i = 0; i <= maxLength; i++) {
            maxLength = Math.max(i + nums[i], maxLength); // 迭代计算每一个元素,到达位置
            if (maxLength >= nums.length - 1) return true; // 已经超过最远的位置 return true
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution();
    }
  
}
