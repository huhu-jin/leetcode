//  [22]括号生成

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 1876 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class GenerateParentheses{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        /**
         * 递归的解法 单独 一个个 添加'(' 或者 ')'
         */

        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            backtracking(ans, new StringBuilder(), 0, 0, n);
            return ans;
        }

        public void backtracking(List<String> ans, StringBuilder cur, int open, int close, int max) {
            if (cur.length() == max * 2) {
                ans.add(cur.toString()); // 结果出口
                return;
            }
            if (open < max) {
                cur.append('(');
                backtracking(ans, cur, open + 1, close, max);
                cur.deleteCharAt(cur.length() - 1); // (回溯)  去除 已经上面的迭代过的情况
            }
            if (close < open) {
                cur.append(')');
                backtracking(ans, cur, open, close + 1, max);
                cur.deleteCharAt(cur.length() - 1);  // (回溯)  去除 已经上面的迭代过的情况
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().generateParenthesis(3);

    }
  
}