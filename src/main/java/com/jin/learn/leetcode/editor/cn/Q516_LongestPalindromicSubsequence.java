//  [516]最长回文子序列

//给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。 
//
// 
//
// 示例 1: 
//输入: 
//
// "bbbab"
// 
//
// 输出: 
//
// 4
// 
//
// 一个可能的最长回文子序列为 "bbbb"。 
//
// 示例 2: 
//输入: 
//
// "cbbd"
// 
//
// 输出: 
//
// 2
// 
//
// 一个可能的最长回文子序列为 "bb"。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 只包含小写英文字母 
// 
// Related Topics 动态规划 
// 👍 410 👎 0

// 动态规划 要先理解题意,得出如何才能递归!!!!!!!!
// 比如这里 start,end 判断是否相等.相等就缩小范围 count+2
// if (s.charAt(start) == s.charAt(end)) {
//        ans = helper(s, start + 1, end - 1) + 2;
//    } else {
//        ans = Math.max(helper(s, start + 1, end),
//                       helper(s, start, end - 1));
//    }
// 如果按背包问题去走 f(i,rest).要不要i个元素,要的话 怎样 不要怎样.这样去做思路混乱.
// 得到迭代过程就很容易得到状态转移方程.


package com.jin.learn.leetcode.editor.cn;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Q516_LongestPalindromicSubsequence{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindromeSubseq(String s) {
        return dynamicProgram(s);
    }


    // 递归解法
    public int recursion(String s) {
        Integer [][] memo = new Integer[s.length()][s.length()];
        return doRecursion(s,0,s.length()-1,memo);
    }

    private int doRecursion(String s, int start, int end, Integer[][] memo) {
        if (memo[start][end] != null) return memo[start][end];
        int ret;
        if (start == end) {
            ret =1;
        } else if (start > end) {
            ret =0;
        } else {
            if (s.charAt(start) == s.charAt(end)) {
                ret = doRecursion(s, start + 1, end - 1, memo) + 2;
            } else {
                ret = Math.max(doRecursion(s, start + 1, end, memo), doRecursion(s, start, end - 1, memo));
            }
        }
        memo[start][end] = ret;
        return ret;
    }

    // 动态规划
    public int dynamicProgram(String s){
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i +1][j -1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i +1][j], dp[i][j -1]);
                    }
                }
            }
        }
        return dp[0][s.length()-1];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        Assert.assertEquals(4,new Solution().dynamicProgram("bbbab"));
    }
  
}
