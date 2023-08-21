//  [1071]字符串的最大公因子

//对于字符串 s 和 t，只有在 s = t + ... + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。 
//
// 给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 x 能除尽 str2 。 
//
// 
//
// 示例 1： 
//
// 
//输入：str1 = "ABCABC", str2 = "ABC"
//输出："ABC"
// 
//
// 示例 2： 
//
// 
//输入：str1 = "ABABAB", str2 = "ABAB"
//输出："AB"
// 
//
// 示例 3： 
//
// 
//输入：str1 = "LEET", str2 = "CODE"
//输出：""
// 
//
// 
//
// 提示： 
//
// 
// 1 <= str1.length, str2.length <= 1000 
// str1 和 str2 由大写英文字母组成 
// 
//
// Related Topics 数学 字符串 👍 341 👎 0


package com.jin.learn.leetcode.editor.cn;


import org.testng.Assert;
import org.testng.annotations.Test;


public class Q1071_GreatestCommonDivisorOfStrings{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 简单的模拟
    public String gcdOfStrings(String str1, String str2) {
        String sh;
        String lo;
        if (str1.length() < str2.length()) {
            sh = str1;
            lo = str2;
        }else {
            sh = str2;
            lo = str1;
        }

        int size = sh.length();

        while (size > 0 ) {
            String item = sh.substring(0, size);
            if (isGcdOfString(sh, item) && isGcdOfString(lo, item)) {
                return item;
            }

            size --;
            while (size >0 && (sh.length() % size) != 0) {
                size --;
            }


        }
        return "";
    }

        private boolean isGcdOfString(String sh, String item) {
            if (sh.length() % item.length() == 0) {
                return buildStr( item, sh.length() / item.length()).equals(sh);
            }
            return false;
        }

        private String buildStr(String item, int length) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < length; i++) {
                builder.append(item);
            }
            return builder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        Assert.assertEquals(new Solution().gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"), "TAUXX");
        Assert.assertEquals(new Solution().gcdOfStrings("ABCDEF", "ABC"), "");
        Assert.assertEquals(new Solution().gcdOfStrings("ABABAB", "ABAB"), "AB");
        Assert.assertEquals(new Solution().gcdOfStrings("ABABABCC", "ABAB"), "");
        Assert.assertEquals(new Solution().gcdOfStrings("ABcABc", "ABc"), "ABc");
        ;
        
    }
  
}