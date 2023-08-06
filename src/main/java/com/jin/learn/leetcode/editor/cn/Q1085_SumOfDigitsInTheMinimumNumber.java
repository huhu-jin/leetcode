//  [1085]最小元素各数位之和

//给你一个正整数的数组 A。 
//
// 然后计算 S，使其等于数组 A 当中最小的那个元素各个数位上数字之和。 
//
// 最后，假如 S 所得计算结果是 奇数 ，返回 0 ；否则请返回 1。 
//
// 
//
// 示例 1: 
//
// 
//输入：[34,23,1,24,75,33,54,8]
//输出：0
//解释：
//最小元素为 1 ，该元素各个数位上的数字之和 S = 1 ，是奇数所以答案为 0 。
// 
//
// 示例 2： 
//
// 
//输入：[99,77,33,66,55]
//输出：1
//解释：
//最小元素为 33 ，该元素各个数位上的数字之和 S = 3 + 3 = 6 ，是偶数所以答案为 1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 100 
// 1 <= A[i] <= 100 
// 
// Related Topics 数组 数学 
// 👍 6 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Arrays;


public class Q1085_SumOfDigitsInTheMinimumNumber{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumOfDigits(int[] nums) {
        Arrays.sort(nums);
        if(nums.length == 0) return 0;
        int temp = nums[0];
        int sum =0;
        while (temp > 0) {
            sum += temp % 10;
            temp = temp / 10;
        }
        return (sum & 1) == 0 ? 1 : 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
