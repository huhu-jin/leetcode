//  [139]单词拆分

//给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 
// 👍 1066 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.*;


public class WordBreak{


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //dp 完全背包问题
        public boolean wordBreak(String s, List<String> wordDict){
            boolean[] dp = new boolean[s.length() + 1]; // 默认是false
            dp[0] = true;
            for (int i = 1; i < dp.length; i++) {
                for (int j =  0 ; j < i; j++) {
                    if (dp[j] && wordDict.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[dp.length - 1];
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        // s = "applepenapple", wordDict = ["apple", "pen"]
        new Solution().wordBreak("applepenapple", Arrays.asList("apple", "pen"));
        new Solution().wordBreak("a", Arrays.asList("a"));
    }
  
}