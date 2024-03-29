//  [387]字符串中的第一个唯一字符

//给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode"
//输出: 0
// 
//
// 示例 2: 
//
// 
//输入: s = "loveleetcode"
//输出: 2
// 
//
// 示例 3: 
//
// 
//输入: s = "aabb"
//输出: -1
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// s 只包含小写字母 
// 
//
// Related Topics 队列 哈希表 字符串 计数 👍 706 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q387_FirstUniqueCharacterInAString{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 不用看
    public int firstUniqChar(String s) {

        int[] memo = new int[26];

        for (char c : s.toCharArray()) {
            memo[c - 'a'] += 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if(memo[s.charAt(i)-'a'] == 1) return i;
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}