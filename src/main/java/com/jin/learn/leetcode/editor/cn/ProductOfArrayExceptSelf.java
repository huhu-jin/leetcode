//  [238]除自身以外数组的乘积

//给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之
//外其余各元素的乘积。 
//
// 
//
// 示例: 
//
// 输入: [1,2,3,4]
//输出: [24,12,8,6] 
//
// 
//
// 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。 
//
// 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 进阶： 
//你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。） 
// Related Topics 数组 前缀和 
// 👍 874 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class ProductOfArrayExceptSelf{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // nums [1,2,3,4] 前缀之积(除自己以外所有的乘机) * 后置之积 就是答案
    // 前缀之积 [1,1,2,6] ,在求解前缀之积时 是可以迭代的 n = input[n] * n-1
    // 后置之积  [24,12,4,1]
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        int[] after = new int[nums.length];
        pre[0]= 1;
        after[nums.length-1] = 1;

        // 前缀之积
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] * nums[i-1];
        }

        // 后置之积
        for (int j = nums.length-2; j >=0; j--) {
            after[j] = after[j + 1] * nums[j+1];
        }
        // 相乘
        for (int i = 0; i < nums.length; i++) {
            pre[i] *= after[i];
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}