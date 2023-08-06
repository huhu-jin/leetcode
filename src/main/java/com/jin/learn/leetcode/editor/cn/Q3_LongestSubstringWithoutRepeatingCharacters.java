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

import java.util.HashMap;

public class Q3_LongestSubstringWithoutRepeatingCharacters{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         *  滑动窗口:
         *  代码采用了一个hashmap记录窗口中元素信息(其中key为窗口元素,value为窗口元素的位置). 一个left位置指针,right位置指针, 在维护滑动窗口大小
         *  右边界right比较明确, 就是i
         *  左边界left? 遇到相同元素,去掉相同元素之前 窗口部分.如图pwabcw  pwabc -> abcw
         *  关键点:窗口边界如何滑动?
         *  此题中,left边界一定是遇到相同元素时, 从原先的同元素位置 开始算.
         */
    public int lengthOfLongestSubstring(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0; int left = 0;
        for(int right = 0; right < s.length(); right++){
            if(map.containsKey(s.charAt(right))){ // 重复元素
                left = Math.max(left, map.get(s.charAt(right))+1); //关键
            }
            map.put(s.charAt(right), right);
            max = Math.max(max, right -left+1); // 计算窗口大小 i(right) - left +1
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    @Test
    public void testCase(){
        Assert.assertEquals(new Solution().lengthOfLongestSubstring("tmmzuxt"),2);
        Assert.assertEquals(new Solution().lengthOfLongestSubstring("abcabcbb"),3);
        Assert.assertEquals(new Solution().lengthOfLongestSubstring("bbbbbbbb"),1);
  }


}
