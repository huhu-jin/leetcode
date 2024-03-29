//  [1271]十六进制魔术数字

//你有一个十进制数字，请按照此规则将它变成「十六进制魔术数字」：首先将它变成字母大写的十六进制字符串，然后将所有的数字 0 变成字母 O ，将数字 1 变成字
//母 I 。 
//
// 如果一个数字在转换后只包含 {"A", "B", "C", "D", "E", "F", "I", "O"} ，那么我们就认为这个转换是有效的。 
//
// 给你一个字符串 num ，它表示一个十进制数 N，如果它的十六进制魔术数字转换是有效的，请返回转换后的结果，否则返回 "ERROR" 。 
//
// 
//
// 示例 1： 
//
// 输入：num = "257"
//输出："IOI"
//解释：257 的十六进制表示是 101 。
// 
//
// 示例 2： 
//
// 输入：num = "3"
//输出："ERROR"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 10^12 
// 给定字符串不会有前导 0 。 
// 结果中的所有字母都应该是大写字母。 
// 
// Related Topics 数学 字符串 
// 👍 9 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q1271_Hexspeak{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // Long.toHexString
    //  Integer.toBinaryString()
    public String toQ1271_Hexspeak(String num) {

        String s = Long.toHexString(Long.parseLong(num)).replaceAll("0", "O").replaceAll("1", "I").toUpperCase();
        String s1 = s.replaceAll("[ABCDEFIO]", "");
        return s1.equals("") ? s : "ERROR";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().toQ1271_Hexspeak("747823223228");
    }
  
}
