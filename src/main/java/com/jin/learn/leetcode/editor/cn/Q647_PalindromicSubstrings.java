//  [647]回文子串

//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 输入的字符串长度不会超过 1000 。 
// 
// Related Topics 字符串 动态规划 
// 👍 641 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


// 类同第5题
public class Q647_PalindromicSubstrings{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 回文子串中心扩散法 同样适合第五题目 查看第五题

    public int countSubstrings(String s) {
            int ans = 0;
            for (int center = 0; center < 2 * s.length() - 1; center++) {
                int left = center / 2;
                int right = left + center % 2;
                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                    ans++;
                    left--;
                    right++;
                }
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().countSubstrings("aaa");

    }

}
