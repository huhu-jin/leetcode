//  [17]电话号码的字母组合

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 
// 👍 1391 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Q17_LetterCombinationsOfAPhoneNumber{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || "".equals(digits)) {
            return Collections.emptyList();
        }
        List<String>ret = new LinkedList<>();
        for (char c : digits.toCharArray()) {
            LinkedList<String> temp = new LinkedList<>();
            int start = 97 + 3 * (c - 50);
            int count = 3;
            if (c == '7') {
                count++;
            } else if (c == '8') {
                start++;
            } else if (c == '9') {
                start++;
                count++;
            }

            for (int i = start; i < start+count; i++) {
                if (ret.isEmpty()) {
                    temp.add( Character.toString((char)i));
                }else{
                    for (String s : ret) {
                        temp.add(s + Character.toString((char)i));
                    }

                }

            }
            ret = temp;
        }
        return ret;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().letterCombinations("9");

    }
  
}
