//  [245]最短单词距离 III

//给定一个单词列表和两个单词 word1 和 word2，返回列表中这两个单词之间的最短距离。 
//
// word1 和 word2 是有可能相同的，并且它们将分别表示为列表中两个独立的单词。 
//
// 示例: 
//假设 words = ["practice", "makes", "perfect", "coding", "makes"]. 
//
// 输入: word1 = “makes”, word2 = “coding”
//输出: 1
// 
//
// 输入: word1 = "makes", word2 = "makes"
//输出: 3
// 
//
// 注意: 
//你可以假设 word1 和 word2 都在列表里。 
// Related Topics 数组 字符串 
// 👍 35 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class ShortestWordDistanceIii{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 因为可以一样 退化单独指针
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int ans = Integer.MAX_VALUE;
        Integer pre = null;

        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1) || wordsDict[i].equals(word2)) {
                //wordsDict[i].equals(wordsDict[pre] :word1 和word2 不同的情况
                //word1.equals(word2) 相同时候
                if (pre != null && (!wordsDict[i].equals(wordsDict[pre]) || word1.equals(word2))) {
                    ans = Math.min(ans, Math.abs(i - pre));
                }
                pre = i;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}