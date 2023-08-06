//  [1119]删去字符串中的元音

//给你一个字符串 S，请你删去其中的所有元音字母（ 'a'，'e'，'i'，'o'，'u'），并返回这个新字符串。 
//
// 
//
// 示例 1： 
//
// 输入："leetcodeisacommunityforcoders"
//输出："ltcdscmmntyfrcdrs"
// 
//
// 示例 2： 
//
// 输入："aeiou"
//输出：""
// 
//
// 
//
// 提示： 
//
// 
// S 仅由小写英文字母组成。 
// 1 <= S.length <= 1000 
// 
// Related Topics 字符串 
// 👍 15 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q1119_RemoveVowelsFromAString{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
    // 不用看
class Solution {
    public String removeVowels(String s) {
       return s.replaceAll("[aeiou]", "");

    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
