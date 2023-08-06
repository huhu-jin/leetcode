//  [69]Sqrt(x)

//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。 
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。 
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 4
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x <= 231 - 1 
// 
// Related Topics 数学 二分查找 
// 👍 841 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q69_Sqrtx{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int mySqrt(int x) {
            if(x == 0 || x ==1 ) return x;
            int left = 0;
            int right = x;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (x / mid  <  mid) {
                    right = mid - 1;
                } else {
                    left = mid +1;
                }
            }
            return right;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        int i = new Solution().mySqrt(4);
        System.out.println(4);

    }
  
}
