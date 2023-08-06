//  [剑指 Offer 46]把数字翻译成字符串

//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 231 
// 
// Related Topics 字符串 动态规划 
// 👍 245 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class QJZOffer46_BaShuZiFanYiChengZiFuChuanLcof{


    //leetcode submit region begin(Prohibit modification and deletion)
    // 动态规划
    // f(n) = f(n-1) 当最后一个数字不能组合
    // f(n) = f(n-2) + f(n-1)
    class Solution {
        public int translateNum(int num) {
            String s = String.valueOf(num);
            int[] dp = new int[s.length() + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 1; i < s.length(); i++) {
                if (Integer.parseInt(s.substring(i - 1, i + 1)) > 25 || '0' == s.charAt(i - 1)) {
                    dp[i + 1] = dp[i];
                } else {
                    dp[i + 1] = dp[i] + dp[i - 1];
                }
            }

            return dp[s.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().translateNum(506);
        new Solution().translateNum(25);
    }
  
}
