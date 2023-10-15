//  [409]最长回文串

//给定一个包含大写字母和小写字母的字符串
// s ，返回 通过这些字母构造成的 最长的回文串 。 
//
// 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入:s = "abccccdd"
//输出:7
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
//
// 示例 2: 
//
// 
//输入:s = "a"
//输出:1
// 
//
// 示例 3： 
//
// 
//输入:s = "aaaaaccc"
//输出:7 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 2000 
// s 只由小写 和/或 大写英文字母组成 
// 
//
// Related Topics 贪心 哈希表 字符串 👍 561 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.HashSet;


public class Q409_LongestPalindrome{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 简单模拟 奇数个字母的个数
    public int longestPalindrome(String s) {
        int[] memo = new int[100];

        for (Character c : s.toCharArray()) {
            memo[c - 'A'] += 1;
        }
        int count = 0;

        for (int i : memo) {
            if ((i & 1) ==1) count++;
        }
        if (count > 0) {
            count--;
        }
        return s.length() - count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}