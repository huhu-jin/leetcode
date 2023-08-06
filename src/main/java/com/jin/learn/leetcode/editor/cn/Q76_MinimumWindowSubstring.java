//  [76]最小覆盖子串

//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 
// 👍 1247 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


public class Q76_MinimumWindowSubstring{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
    // 滑动窗口
    // 有 l r 两个边界. 不满足条件时,r 扩大, 满足条件时 l缩小.

    class Solution {

        HashMap<Character, Integer> required = new HashMap<Character, Integer>(); // 要求
        HashMap<Character, Integer> now = new HashMap<Character, Integer>(); // 现在

        public String minWindow(String s, String t) {

            if ("".equals(s) || s == null) return "";

            // 初始化要求的 map
            for (char c : t.toCharArray()) {
                required.put(c, required.getOrDefault(c, 0) + 1);
            }
            // 存储返回结果
            int resR=0;
            int resL=0;
            // 滑动窗口的边界
            int l=0;
            int r=-1;
            boolean isFirst = true;
            while (++r < s.length()) {
                // 关心的 加入now中
                if (t.indexOf(s.charAt(r)) >= 0) {
                    now.put(s.charAt(r), now.getOrDefault(s.charAt(r), 0) + 1);
                }

                while (check()) {
                    if (isFirst || ((r - l) < (resR - resL))) {
                        resR = r;
                        resL = l;
                        isFirst = false;
                    }

                    if (now.containsKey(s.charAt(l))) {
                        now.put(s.charAt(l), now.get(s.charAt(l)) - 1);
                    }

                    l++;
                }
            }
            if(isFirst) return "";
            return s.substring(resL, resR + 1);
        }

        private boolean check() {
            for (Map.Entry<Character, Integer> entry: required.entrySet()) {
                 if (now.getOrDefault(entry.getKey(),0)<entry.getValue()) return false;
            }
            return true;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().minWindow("ADOBECODEBANC", "ABC");
    }
  
}
