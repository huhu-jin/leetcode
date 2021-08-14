//  [243]最短单词距离

//给定一个单词列表和两个单词 word1 和 word2，返回列表中这两个单词之间的最短距离。 
//
// 示例: 
//假设 words = ["practice", "makes", "perfect", "coding", "makes"] 
//
// 输入: word1 = “coding”, word2 = “practice”
//输出: 3
// 
//
// 输入: word1 = "makes", word2 = "coding"
//输出: 1
// 
//
// 注意: 
//你可以假设 word1 不等于 word2, 并且 word1 和 word2 都在列表里。 
// Related Topics 数组 字符串 
// 👍 68 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class ShortestWordDistance {


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestDistance(String[] wordsDict, String word1, String word2) {
            if (wordsDict == null || wordsDict.length < 2) return 0;
            Integer p = null;
            Integer q = null;
            int ans = wordsDict.length;
            for (int i = 0; i < wordsDict.length; i++) {
                if (word1.equals(wordsDict[i])) p = i;
                if (word2.equals(wordsDict[i])) q = i;
                if (p != null && q != null) ans = Math.min(Math.abs(p - q), ans);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void testCase() {

    }

}