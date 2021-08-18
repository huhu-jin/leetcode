//  [266]回文排列

//给定一个字符串，判断该字符串中是否可以通过重新排列组合，形成一个回文字符串。 
//
// 示例 1： 
//
// 输入: "code"
//输出: false 
//
// 示例 2： 
//
// 输入: "aab"
//输出: true 
//
// 示例 3： 
//
// 输入: "carerac"
//输出: true 
// Related Topics 位运算 哈希表 字符串 
// 👍 45 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class PalindromePermutation{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 排列以后你能够组成 回文字符 必须是
    // 所有的奇数字符数 小于等于1
    public boolean canPermutePalindrome(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) cnt[s.charAt(i) - 'a']++;
        int count = 0;
        for (int c : cnt) if (c % 2 == 1) count++;
        return count <= 1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}