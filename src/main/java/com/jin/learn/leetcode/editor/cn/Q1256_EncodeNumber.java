//  [1256]加密数字

//给你一个非负整数 num ，返回它的「加密字符串」。 
//
// 加密的过程是把一个整数用某个未知函数进行转化，你需要从下表推测出该转化函数： 
//
// 
//
// 
//
// 示例 1： 
//
// 输入：num = 23
//输出："1000"
// 
//
// 示例 2： 
//
// 输入：num = 107
//输出："101100"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= num <= 10^9 
// 
// Related Topics 位运算 数学 字符串 
// 👍 15 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q1256_EncodeNumber{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String encode(int num) {
        return Integer.toBinaryString(num + 1).substring(1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
