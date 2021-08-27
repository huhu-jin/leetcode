//  [408]有效单词缩写

//给一个 非空 字符串 s 和一个单词缩写 abbr ，判断这个缩写是否可以是给定单词的缩写。 
//
// 字符串 "word" 的所有有效缩写为： 
//
// ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1",
// "w1r1", "1o2", "2r1", "3d", "w3", "4"] 
//
// 注意单词 "word" 的所有有效缩写仅包含以上这些。任何其他的字符串都不是 "word" 的有效缩写。 
//
// 注意: 
//假设字符串 s 仅包含小写字母且 abbr 只包含小写字母和数字。 
//
// 示例 1: 
//
// 给定 s = "internationalization", abbr = "i12iz4n":
//
//函数返回 true.
// 
//
// 
//
// 示例 2: 
//
// 给定 s = "apple", abbr = "a2e":
//
//函数返回 false.
// 
//
// 
// Related Topics 双指针 字符串 
// 👍 28 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class ValidWordAbbreviation{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //测试用例恶心
    //    可以不看
    public boolean validWordAbbreviation(String word, String abbr) {
        if(word.equals(abbr)) return true;
        if(abbr.length() ==1) return abbr.equals(word.length() + "");

        int p=-1;
        int num=0;
        for (int i = 0; i < abbr.length(); i++) {
            if (abbr.charAt(i) >= 48 && abbr.charAt(i) <= 57) {
                num = num * 10 + (abbr.charAt(i) - 48);
                if (num == 0) {
                    return false;
                }
            } else {
                p += num;
                num = 0;
                p++;

                if (p >= word.length()|| abbr.charAt(i) != word.charAt(p)) {
                    return false;
                }

            }
        }
        if(num!=0) return p + num == word.length() - 1;
        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        Solution solution = new Solution();
        solution.validWordAbbreviation("ii", "i1");
    }
  
}