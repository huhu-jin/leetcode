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
    // abba 的中心点
    // a ab b bb b ba a 一共5个
    // 这个迭代法很神奇. 两个变量, left right 0,0   0,1   1,1    1,2 迭代
    // center / 2 , center / 2 + center % 2    这样迭代
    public String longestPalindrome(String s) {
        // ababa 求最长公共子串
        int len = s.length();
        String result = "";

        for (int center = 0; center < len * 2 - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                String tmp = s.substring(left, right + 1);
                if (tmp.length() > result.length()) {
                    result = tmp;
                }
                left--;
                right++;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().longestPalindrome("babad");
    }
  
}