//  [438]找到字符串中所有字母异位词

//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指字母相同，但排列不同的字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 104 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 579 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.*;


public class FindAllAnagramsInAString{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 窗口滑动
    // 1 用int[] 来统计String中的char
    // 2 right 每次都加, left用一个while循环去消除.
    //
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null) return Collections.EMPTY_LIST;
        // 这里需要想到
        int[] targetCnt = new int[26];
        int[] stringCnt = new int[26];

        for(int i = 0; i < p.length(); i++){
            targetCnt[p.charAt(i) - 'a'] ++;
        }
        LinkedList<Integer> ans = new LinkedList<>();
        int left =0;
        int right = 0;
        for(; right < s.length(); right++){
            int curRight = s.charAt(right) - 'a';
            stringCnt[curRight]++;
            // 循环是关键 主要作用消去 高于targetCnt的 统计内容:
            // 遇到不属于p的字符 会clear 所有的 stringCnt呢哦热评,  因为 stringCnt[curRight] 一直大于
            // 遇到属于p的字符, 会clear到 不多于targetCnt为止
            while(stringCnt[curRight] > targetCnt[curRight]){
                int curLeft = s.charAt(left) - 'a';
                stringCnt[curLeft]--;
                left++;
            }
            if(right - left + 1 == p.length()){ // 窗口长度检测
                ans.add(left);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    // 如何判断 连个字符串 所组成的字符一样
    private boolean isSameTerms(String original, String target) {
        int[] temp = new int[26];
        for(int i = 0; i < original.length(); i++){
            temp[original.charAt(i) - 'a'] ++;
        }

        for (int i = 0; i < target.length(); i++) {
            temp[target.charAt(i) - 'a'] ++;
        }

        for (int i : temp) {
            if(i !=0) return false;
        }
        return true;

    }


    @Test
    public void testCase(){
        List<Integer> test3 = new Solution().findAnagrams("cbabc", "abc");

        List<Integer> test1 = new Solution().findAnagrams("cbaebabacd", "abc");
        List<Integer> test4 = new Solution().findAnagrams("bbb", "abc");
        List<Integer> test2 = new Solution().findAnagrams("abab", "ab");
    }
  
}