//  [剑指 Offer 65]不用加减乘除做加法

//写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。 
//
// 
//
// 示例: 
//
// 输入: a = 1, b = 1
//输出: 2 
//
// 
//
// 提示： 
//
// 
// a, b 均可能是负数或 0 
// 结果不会溢出 32 位整数 
// 
// Related Topics 位运算 数学 
// 👍 190 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.Assert;
import org.testng.annotations.Test;


public class BuYongJiaJianChengChuZuoJiaFaLcof{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)

    // 用位运算实现加法。
    // a +b 可以转化为 a ^b +( a &b) <<1
    // 放置不断进位 用递归
class Solution {
        public int add(int a, int b) {
            while(b != 0) { // 当进位为 0 时跳出
                int c = (a & b) << 1;  // c = 进位
                a ^= b; // a = 非进位和
                b = c; // b = 进位
            }
            return a;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        Assert.assertEquals(9,new Solution().add(5, 4));
    }
  
}