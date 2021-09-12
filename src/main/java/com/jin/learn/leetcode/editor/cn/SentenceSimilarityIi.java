//  [737]句子相似性 II

//给定两个句子 words1, words2 （每个用字符串数组表示），和一个相似单词对的列表 pairs ，判断是否两个句子是相似的。 
//
// 例如，当相似单词对是 pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"
//]]的时候，words1 = ["great", "acting", "skills"] 和 words2 = ["fine", "drama", "talen
//t"] 是相似的。 
//
// 注意相似关系是 具有 传递性的。例如，如果 "great" 和 "fine" 是相似的，"fine" 和 "good" 是相似的，则 "great" 和 
//"good" 是相似的。 
//
// 而且，相似关系是具有对称性的。例如，"great" 和 "fine" 是相似的相当于 "fine" 和 "great" 是相似的。 
//
// 并且，一个单词总是与其自身相似。例如，句子 words1 = ["great"], words2 = ["great"], pairs = [] 是相似的
//，尽管没有输入特定的相似单词对。 
//
// 最后，句子只会在具有相同单词个数的前提下才会相似。所以一个句子 words1 = ["great"] 永远不可能和句子 words2 = ["double
//plus","good"] 相似。 
//
// 注： 
//
// 
// words1 and words2 的长度不会超过 1000。 
// pairs 的长度不会超过 2000。 
// 每个pairs[i] 的长度为 2。 
// 每个 words[i] 和 pairs[i][j] 的长度范围为 [1, 20]。 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 哈希表 字符串 
// 👍 47 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class SentenceSimilarityIi{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if(sentence1.length != sentence2.length) return false;
        HashMap<String, Set<String>> map = new HashMap<>();
        for (List<String> pair : similarPairs) {
            map.computeIfAbsent(pair.get(0) , i-> new HashSet<>()).add( pair.get(1));
            map.computeIfAbsent(pair.get(1) , i-> new HashSet<>()).add( pair.get(0));
        }

        for (int i = 0; i < sentence1.length; i++) {
            if (!sentence1[i].equals(sentence2[i]) &&
                    (!map.containsKey(sentence1[i])
                            || !isInMap(map, sentence1[i], sentence2[i], new HashSet<>()))) {
                return false;
            }
        }
        return true;
    }

        private boolean isInMap(HashMap<String, Set<String>> map, String input, String target, Set<String> path) {
            if (input.equals(target)) return true;
            if(path.contains(input)) return false;
            Set<String> set = map.get(input);
            for (String i: set) {
                HashSet<String> tempPath = new HashSet<>(path);
                tempPath.add(input);
                if (isInMap(map, i, target, tempPath)) {
                    return true;
                }
            }
            return false;
        }

}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}