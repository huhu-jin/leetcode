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


public class LongestPalindromicSubstring{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 中心扩散法
    public String longestPalindrome(String s) {
        if(s == null || "".equals(s)) return "";

        int maxLeft=0;
        int maxRight=0;
        for (int i = 0; i < s.length(); i++) {

           int len1 =  expandAroundCenter(i, i, s);// bab
           int len2 =  expandAroundCenter(i, i+1, s); // baab
            if (len1 > len2 && len1 > (maxRight - maxLeft + 1)) {
                maxLeft = i - len1 / 2;
                maxRight = i + len1 / 2;
            } else if (len2 > len1 && len2 > (maxRight - maxLeft + 1)) {
                maxLeft = i - len2 / 2 + 1;
                maxRight = i + len2 / 2;
            }

        }

        return s.substring(maxLeft, maxRight+1);
    }
        // 从中心开始扩散
        private int expandAroundCenter(int left, int right, String s) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return right - left - 1; // 会多走一步
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().longestPalindrome("babad");
    }
  
}