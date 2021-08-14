//  [244]最短单词距离 II

//请设计一个类，使该类的构造函数能够接收一个单词列表。然后再实现一个方法，该方法能够分别接收两个单词 word1 和 word2，并返回列表中这两个单词之间的
//最短距离。您的方法将被以不同的参数调用 多次。 
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
// 注意: 
//你可以假设 word1 不等于 word2, 并且 word1 和 word2 都在列表里。 
// Related Topics 设计 数组 哈希表 双指针 字符串 
// 👍 50 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ShortestWordDistanceIi{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class WordDistance {
        // 题目需要多次调用, 所有用hashmap 缓存起来
        // 第二个难点是 如何在两个排序数组中 找茬最小.
    private Map<String, List<Integer>> memo = new HashMap<>();

    public WordDistance(String[] wordsDict) {
        for (int i = 0; i < wordsDict.length; i++) {
            List<Integer> orDefault = memo.getOrDefault(wordsDict[i], new ArrayList<>());
            orDefault.add(i);
            memo.put(wordsDict[i], orDefault);
        }

    }
    
    public int shortest(String word1, String word2) {
        List<Integer> word1List = memo.get(word1);
        List<Integer> word2List = memo.get(word2);
        int p = 0;
        int q = 0;
        int ans = Integer.MAX_VALUE;
        while (p < word1List.size() && q < word2List.size()) {
            ans = Math.min(Math.abs(word1List.get(p) - word2List.get(q)), ans);
            if(ans == 1) return 1; //最小是1

            // 重点如何 比较
            if (word1List.get(p) < word2List.get(q)) {
                p++;
            }else{
                q++;
            }
        }
        return ans;

    }

}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}