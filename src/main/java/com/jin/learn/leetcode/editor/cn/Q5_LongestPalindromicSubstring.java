//  [5]最长回文子串

//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3814 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q5_LongestPalindromicSubstring{
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // 中心扩散法
        // abba 的中心点
    // 注意中心 i i 或者是 i i+1
     String result = "";
    public String longestPalindrome(String s) {
        // ababa 求最长公共子串
        int len = s.length();
        for (int center = 0; center < len; center++) {
            expend(center, center, s, len);
            expend(center, center+1, s, len);
        }
        return result;
    }

    public void expend(int left, int right, String s, int len){
        while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
            String tmp = s.substring(left, right + 1);
            if (tmp.length() > result.length()) {
                result = tmp;
            }
            left--;
            right++;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().longestPalindrome("babad");
    }
  
}
