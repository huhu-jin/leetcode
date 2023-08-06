//  [616]给字符串添加加粗标签

//给你一个字符串 s 和一个字符串列表 words ，你需要将在字符串列表中出现过的 s 的子串添加加粗闭合标签 <b> 和 </b> 。 
//
// 如果两个子串有重叠部分，你需要把它们一起用一对闭合标签包围起来。同理，如果两个子字符串连续被加粗，那么你也需要把它们合起来用一对加粗标签包围。 
//
// 返回添加加粗标签后的字符串 s 。 
//
// 
//
// 示例 1： 
//
// 
//输入： s = "abcxyz123", words = ["abc","123"]
//输出："<b>abc</b>xyz<b>123</b>"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaabbcc", words = ["aaa","aab","bc"]
//输出："<b>aaabbc</b>c"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// 0 <= words.length <= 100 
// 1 <= words[i].length <= 1000 
// s 和 words[i] 由英文字母和数字组成 
// words 中的所有值 互不相同 
// 
//
// 
//
// 注：此题与「758 - 字符串中的加粗单词」相同 - https://leetcode-cn.com/problems/bold-words-in-str
//ing 
//
// 
// Related Topics 字典树 数组 哈希表 字符串 字符串匹配 
// 👍 61 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q616_AddBoldTagInString{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 用index 把所有需要加粗的都 标记起来
    // 然后  append
    // 在边界 加 </b> 或者 <b>
    public String addBoldTag(String S, String[] words) {
            int size = S.length();
            boolean[] isBold = new boolean[size];

            for (String word : words) {
                int n = S.indexOf(word, 0);
                while (n != -1) {
                    for (int i = n; i < n + word.length(); i++) isBold[i] = true;
                    n = S.indexOf(word, n + 1);
                }
            }

            StringBuilder sb = new StringBuilder();
            if (isBold[0]) sb.append("<b>");
            for (int i = 0; i < size; i++) {
                sb.append(S.charAt(i)); // 每一个加
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
