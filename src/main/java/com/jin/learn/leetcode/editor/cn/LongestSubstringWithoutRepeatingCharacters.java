//  [3]无重复字符的最长子串

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 5082 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LongestSubstringWithoutRepeatingCharacters{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlength=0;
        if ("".equals(s) || s == null) {
            return maxlength;
        }
        int p =0;
        int q =p;
        for ( p = 0; p < s.length(); p++) {
            boolean[] exist = new boolean[128];
            for ( q = p ; q < s.length(); q++) {
                if (!addIfNotExist(exist, s.charAt(q))) {
                    maxlength = Math.max(q - p, maxlength);
                    break;
                }
            }
            maxlength = Math.max(q - p, maxlength);
            if (maxlength > s.length() - p) {
                break;
            }
        }
        return maxlength;
    }

    private boolean addIfNotExist(boolean [] exist, char c) {
        if (exist[c]) {
            return false;
        }else{
            exist[c] = true;
            return true;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    @Test
    public void testCase(){
        Assert.assertEquals(new Solution().lengthOfLongestSubstring(" "),1);
        Assert.assertEquals(new Solution().lengthOfLongestSubstring("abcabcbb"),3);
        Assert.assertEquals(new Solution().lengthOfLongestSubstring("bbbbbbbb"),1);
        Assert.assertEquals(new Solution().lengthOfLongestSubstring("pwwkew"),3);
  }

}