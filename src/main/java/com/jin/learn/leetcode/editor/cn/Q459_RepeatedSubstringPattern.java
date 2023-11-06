//  [459]重复的子字符串

//给定一个非空的字符串
// s ，检查是否可以通过由它的一个子串重复多次构成。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abab"
//输出: true
//解释: 可由子串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: s = "aba"
//输出: false
// 
//
// 示例 3: 
//
// 
//输入: s = "abcabcabcabc"
//输出: true
//解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
//
// Related Topics 字符串 字符串匹配 👍 1076 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.HashSet;


public class Q459_RepeatedSubstringPattern{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // https://leetcode.cn/problems/repeated-substring-pattern/solutions/114572/jian-dan-ming-liao-guan-yu-javaliang-xing-dai-ma-s/
        // 非常秀的解法
    public boolean repeatedSubstringPattern(String s) {


        String doubleStr = s +s;

        return doubleStr.substring(1, doubleStr.length() - 1).contains(s);


    }


    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){

        new Solution().repeatedSubstringPattern("abcabc");
        
    }
  
}