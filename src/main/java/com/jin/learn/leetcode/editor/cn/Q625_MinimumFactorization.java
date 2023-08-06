//  [625]最小因式分解

//给定一个正整数 a，找出最小的正整数 b 使得 b 的所有数位相乘恰好等于 a。 
//
// 如果不存在这样的结果或者结果不是 32 位有符号整数，返回 0。 
//
// 
//
// 样例 1 
//
// 输入： 
//
// 48 
// 
//
// 输出： 
//
// 68 
//
// 
//
// 样例 2 
//
// 输入： 
//
// 15
// 
//
// 输出： 
//
// 35 
//
// 
// Related Topics 贪心 数学 
// 👍 26 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q625_MinimumFactorization{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 用最大 去除 9 作为最后一位
    // 168
    // 最后一位 8 -> 21 最后 第二位 7 -> 3 最后一位
    //
        public int smallestFactorization(int a) {
            if (a < 2)
                return a;
            long res = 0, mul = 1;
            // mul 相当于进位 先得到最后一位
            for (int i = 9; i >= 2; i--) { // a =1 最后
                while (a % i == 0) {
                    a /= i;
                    res = mul * i + res;
                    mul *= 10;
                }
            }
            return a < 2 && res <= Integer.MAX_VALUE ? (int)res : 0;
        }

}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().smallestFactorization(168);
        
    }
  
}
