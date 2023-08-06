//  [剑指 Offer 64]求1+2+…+n

//求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。 
//
// 
//
// 示例 1： 
//
// 输入: n = 3
//输出: 6
// 
//
// 示例 2： 
//
// 输入: n = 9
//输出: 45
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10000 
// 
// Related Topics 位运算 递归 脑筋急转弯 
// 👍 342 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;



public class QJZOffer64_Qiu12nLcof {
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumNums(int n) {
            if(n == 1) return 1;
        return add(n ,sumNums(n - 1));

    }
        // 看 剑指offer 65
        private int add(int a, int b) {
            while (b != 0) {
                int c = (a & b) << 1;
                a = a ^ b;
                b = c;
            }
            return a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}