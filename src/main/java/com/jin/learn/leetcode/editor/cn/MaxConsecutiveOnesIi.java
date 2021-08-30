//  [487]最大连续1的个数 II

//给定一个二进制数组，你可以最多将 1 个 0 翻转为 1，找出其中最大连续 1 的个数。 
//
// 示例 1： 
//
// 输入：[1,0,1,1,0]
//输出：4
//解释：翻转第一个 0 可以得到最长的连续 1。
//     当翻转以后，最大连续 1 的个数为 4。
// 
//
// 
//
// 注： 
//
// 
// 输入数组只包含 0 和 1. 
// 输入数组的长度为正整数，且不超过 10,000 
// 
//
// 
//
// 进阶： 
//如果输入的数字是作为 无限流 逐个输入如何处理？换句话说，内存不能存储下所有从流中输入的数字。您可以有效地解决吗？ 
// Related Topics 数组 动态规划 滑动窗口 
// 👍 71 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class MaxConsecutiveOnesIi{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 窗口滑动 (遇到连续什么的 就要想到)
    // 遇到0  left = 前一个0的位置
    // 遇到1  right++
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans =0, left =0, right =0 ;
        Integer preZeroPosition = null;
        while (right < nums.length) {
            if(nums[right] == 0){
                if (preZeroPosition != null) left = preZeroPosition+1; // 窗口收缩
                preZeroPosition = right; // 记录当前0位置 到preZeroPosition
            }
            ans = Math.max(ans, right - left+1 );
            right++; // 窗口扩大
        }
        return ans;
    }

    //另一种窗口滑动
    //只用维护一个区间，这个区间中最多只包含一个0。当区间中包含两个0的时候，直接移动左边界l直到区间只包含一个0即可
    public int findMaxConsecutiveOnes2(int[] nums) {
        int res = 0, count = 0;
        for(int l = 0, r = 0; r < nums.length; r++) {
            if(nums[r] == 0) {
                count++;
                while(count > 1) {
                    count -= nums[l++] == 0 ? 1 : 0;
                }
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }



}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0});
        
    }
  
}