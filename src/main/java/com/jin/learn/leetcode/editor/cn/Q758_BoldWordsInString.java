//  [758]字符串中的加粗单词

//给定一个关键词集合 words 和一个字符串 S，将所有 S 中出现的关键词加粗。所有在标签 和 中的字母都会加粗。 
//
// 返回的字符串需要使用尽可能少的标签，当然标签应形成有效的组合。 
//
// 例如，给定 words = ["ab", "bc"] 和 S = "aabcd"，需要返回 "aabcd"。注意返回 "aabcd" 会使用更多的标签，因
//此是错误的。 
//
// 
//
// 提示： 
//
// 
// words 长度的范围为 [0, 50]。 
// words[i] 长度的范围为 [1, 10]。 
// S 长度的范围为 [0, 500]。 
// 所有 words[i] 和 S 中的字符都为小写字母。 
// 
//
// 
//
// 注：此题与「616 - 给字符串添加加粗标签」相同 - https://leetcode-cn.com/problems/add-bold-tag-in-
//string/ 
//
// 
// Related Topics 字典树 数组 哈希表 字符串 字符串匹配 
// 👍 38 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q758_BoldWordsInString{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 同 [616]给字符串添加加粗标签
    public String boldWords(String[] words, String s) {
        int size = s.length();
        boolean[] isBold = new boolean[size];

        for (String word : words) {
            int n = s.indexOf(word, 0);
            while (n != -1) {
                for (int i = n; i < n + word.length(); i++) isBold[i] = true;
                n = s.indexOf(word, n + 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (isBold[0]) sb.append("<b>");
        for (int i = 0; i < size; i++) {
            sb.append(s.charAt(i)); // 每一个加
            // 最后一个
            if (i == size - 1) {
                if (isBold[i]) sb.append("</b>");
                break;
            }
            if (isBold[i] && !isBold[i + 1]) sb.append("</b>");
            if (!isBold[i] && isBold[i + 1]) sb.append("<b>");
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
