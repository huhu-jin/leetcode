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
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class GenerateParentheses{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**类似几种可能性的题目
         * 1 总路径
         * 2 当前路径 从从总路径中迭代出当前路劲, 并将当前路径赋予总路径 下次迭代
         * 3 去重
         */
        public List<String> generateParenthesis(int n) {
            Set<String> ret = new HashSet<>();
            for (int i = 0; i < n; i++) {
                Set<String> temp = new HashSet<>();
                if (ret.isEmpty()) {
                    temp.add("()");
                } else {
                    for (String s : ret) {
                        addParentThesis(temp, s);
                    }
                }
                ret = temp;
            }
            return new ArrayList<>(ret);

        }

        private void addParentThesis(Set<String> temp, String s) {
            int pos = -1;
            while ((pos = s.indexOf('(', pos + 1)) >= 0) {
                temp.add(s.substring(0, pos + 1) + "()" + s.substring(pos+1));
            }
            temp.add(s + "()");
        }

        /**
         * 递归的解法 单独 一个个 添加'(' 或者 ')'
         */

        public List<String> generateParenthesis2(int n) {
            List<String> ans = new ArrayList<>();
            backtrack(ans, new StringBuilder(), 0, 0, n);
            return ans;
        }

        public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
            if (cur.length() == max * 2) {
                ans.add(cur.toString()); // 结果出口
                return;
            }
            if (open < max) {
                cur.append('(');
                backtrack(ans, cur, open + 1, close, max);
                cur.deleteCharAt(cur.length() - 1); // 去除 已经上面的迭代过的情况
            }
            if (close < open) {
                cur.append(')');
                backtrack(ans, cur, open, close + 1, max);
                cur.deleteCharAt(cur.length() - 1);
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().generateParenthesis2(3);

    }
  
}