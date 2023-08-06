//  [115]不同的子序列

//给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。 
//
// 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列
//，而 "AEC" 不是） 
//
// 题目数据保证答案符合 32 位带符号整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "rabbbit", t = "rabbit"
//输出：3
//解释：
//如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
//(上箭头符号 ^ 表示选取的字母)
//rabbbit
//^^^^ ^^
//rabbbit
//^^ ^^^^
//rabbbit
//^^^ ^^^
// 
//
// 示例 2： 
//
// 
//输入：s = "babgbag", t = "bag"
//输出：5
//解释：
//如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。 
//(上箭头符号 ^ 表示选取的字母)
//babgbag
//^^ ^
//babgbag
//^^    ^
//babgbag
//^    ^^
//babgbag
//  ^  ^^
//babgbag
//    ^^^ 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length, t.length <= 1000 
// s 和 t 由英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 399 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


public class Q115_DistinctSubsequences{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDistinct(String s, String t) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        StringBuffer clearString = new StringBuffer();
        for (char i : s.toCharArray()) {
            if (t.indexOf(i)!=-1) {
                clearString.append(i);
            }
        }

//        Map<String,Integer> map = new HashMap();
//        return count(clearString.toString(), t, 0, 0, map);
        return dp(clearString.toString(), t);
    }

        private int dp(String s, String t) {
            int m = s.length(), n = t.length();
            if (m < n) {
                return 0;
            }
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                dp[i][n] = 1;
            }
            for (int i = m - 1; i >= 0; i--) {
                char sChar = s.charAt(i);
                for (int j = n - 1; j >= 0; j--) {
                    char tChar = t.charAt(j);
                    if (sChar == tChar) {
                        dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                    } else {
                        dp[i][j] = dp[i + 1][j];
                    }
                }
            }
            return dp[0][0];
        }

        private int count(String s, String t, int index, int indexSub,Map<String,Integer> map ) {
            if (map.containsKey(index + "+" + indexSub)) {
                return map.get(index + "+" + indexSub);
            }
            if (s.length() == index || s.length() - index < t.length() - indexSub) {
                return 0;
            }
            if (t.length()-1 == indexSub) {
               return (int) s.substring(index).chars().filter(ch -> ch == t.charAt(indexSub)).count() ;
            }
            int newIndex = s.substring(index).indexOf(t.charAt(indexSub));
            if (newIndex == -1) {
                return 0;
            }
            index += newIndex;
            int ret = count(s, t, index + 1, indexSub + 1, map) + count(s, t, index + 1, indexSub, map);
            map.put(index + "+" + indexSub, ret);
            return ret;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        Assert.assertEquals(1,new Solution().numDistinct("eee'", "eee"));
        Assert.assertEquals(3,new Solution().numDistinct("rabbbit'", "rabbit"));
        Assert.assertEquals(5,new Solution().numDistinct("babgbag'", "bag"));
        Assert.assertEquals(1,new Solution().numDistinct("bag'", "bag"));
    }
  
}
