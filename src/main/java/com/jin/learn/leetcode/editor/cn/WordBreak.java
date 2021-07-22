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
        // DFS  逐个字母 剩下的再递归
        HashMap<Integer, Boolean> memo = new HashMap<>();
        public boolean wordBreak1(String s, List<String> wordDict) {
            return recursion(s, wordDict, 0);
        }

        private boolean recursion(String s, List<String> wordDict, int start) {
            if(memo.containsKey(start)) return memo.get(start);
            if(start == s.length()) return true;
            for (int end = start; end < s.length(); end++) { // 从长到短
                // 当前 s的子串 在 wordDict中
                if (wordDict.contains(s.substring(start, end+1))) {
                    // s剩余部分 递归判断
                    if (recursion(s, wordDict, end + 1)) {  // 不能return recursion(s, wordDict, end + 1)
                        memo.put(end + 1, true);
                        return true;
                    }
                }
            }
            memo.put(start, false);
            return false;
        }

        //bfs
        public boolean wordBreak2(String s, List<String> wordDict) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);

            int slength = s.length(); // 长度
            boolean[] visited = new boolean[slength + 1];


            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int start = queue.poll();
                    for (String word : wordDict) {
                        int nextStart = start + word.length();
                        if (nextStart > slength || visited[nextStart]) {
                            continue;
                        }

                        if (s.indexOf(word, start) == start) {
                            if (nextStart == slength) {
                                return true;
                            }

                            queue.add(nextStart);
                            visited[nextStart] = true;
                        }
                    }
                }
            }
        return false;
        }

        //dp
        public boolean wordBreak(String s, List<String> wordDict){
            int maxWordLength = 0;
            Set<String> wordSet = new HashSet<>(wordDict.size());
            for (String word : wordDict) {
                wordSet.add(word);

                if (word.length() > maxWordLength) {
                    maxWordLength = word.length();
                }
            }

            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i < dp.length; i++) {
                for (int j = (i - maxWordLength < 0 ? 0 : i - maxWordLength); j < i; j++) {
                    if (dp[j] && wordSet.contains(s.substring(j, i))) {
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