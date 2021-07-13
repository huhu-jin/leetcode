//  [20]有效的括号

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2496 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.LinkedList;


public class ValidParentheses{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if ('{' == c || '[' == c || '(' == c) {
                queue.add(c);
            } else if ('}' == c) {
                Character item = queue.pollLast();
                if (item == null || '{' != item) {
                    return false;
                }
            }else if (']' == c) {
                Character item = queue.pollLast();
                if (item == null || '[' != item) {
                    return false;
                }
            }else if (')' == c) {
                Character item = queue.pollLast();
                if (item == null || '(' != item) {
                    return false;
                }
            }
        }

        return queue.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().isValid("([)]");
    }
  
}