//  [1087]花括号展开

//我们用一个特殊的字符串 S 来表示一份单词列表，之所以能展开成为一个列表，是因为这个字符串 S 中存在一个叫做「选项」的概念： 
//
// 单词中的每个字母可能只有一个选项或存在多个备选项。如果只有一个选项，那么该字母按原样表示。 
//
// 如果存在多个选项，就会以花括号包裹来表示这些选项（使它们与其他字母分隔开），例如 "{a,b,c}" 表示 ["a", "b", "c"]。 
//
// 例子："{a,b,c}d{e,f}" 可以表示单词列表 ["ade", "adf", "bde", "bdf", "cde", "cdf"]。 
//
// 请你按字典顺序，返回所有以这种方式形成的单词。 
//
// 
//
// 示例 1： 
//
// 输入："{a,b}c{d,e}f"
//输出：["acdf","acef","bcdf","bcef"]
// 
//
// 示例 2： 
//
// 输入："abcd"
//输出：["abcd"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 50 
// 你可以假设题目中不存在嵌套的花括号 
// 在一对连续的花括号（开花括号与闭花括号）之间的所有字母都不会相同 
// 
// Related Topics 广度优先搜索 字符串 回溯 
// 👍 37 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;


public class Q1087_BraceExpansion{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 模拟就好了
    public String[] expand(String s) {
        List<String> ans = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            List<String> temp = new LinkedList<>();
            LinkedList<Character> addItems = new LinkedList<>();
            if ('{' == s.charAt(i)){
                while ('}' != s.charAt(++i)) {
                    if (',' != s.charAt(i)) {
                        addItems.add(s.charAt(i));
                    }
                }

            }else{
                addItems.add(s.charAt(i));
            }

            for (Character item : addItems) {
                if (ans.size() == 0) {
                    temp.add("" + item);
                }else {
                    for (String a : ans) {
                        temp.add(a + item);
                    }
                }
            }

            ans = temp;
        }
        ans.sort((i, j) -> compare(i, j));
        return ans.toArray(new String[0]);
    }

        private int compare(String a, String b) {
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) !=b.charAt(i)) return a.charAt(i) - b.charAt(i);
            }
            return 0;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().expand("{a,b}c{d,e}f");
    }
  
}
