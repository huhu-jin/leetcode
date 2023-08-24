//  [1318]或运算的最小翻转次数

//给你三个正整数 a、b 和 c。 
//
// 你可以对 a 和 b 的二进制表示进行位翻转操作，返回能够使按位或运算 a OR b == c 成立的最小翻转次数。 
//
// 「位翻转操作」是指将一个数的二进制表示任何单个位上的 1 变成 0 或者 0 变成 1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：a = 2, b = 6, c = 5
//输出：3
//解释：翻转后 a = 1 , b = 4 , c = 5 使得 a OR b == c 
//
// 示例 2： 
//
// 输入：a = 4, b = 2, c = 7
//输出：1
// 
//
// 示例 3： 
//
// 输入：a = 1, b = 2, c = 3
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a <= 10^9 
// 1 <= b <= 10^9 
// 1 <= c <= 10^9 
// 
//
// Related Topics 位运算 👍 57 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

// https://leetcode.cn/problems/minimum-flips-to-make-a-or-b-equal-to-c/solutions/72753/qing-xi-jian-dan-you-qu-de-tui-li-yan-suan-by-hlxi/?envType=study-plan-v2&envId=leetcode-75
public class Q1318_MinimumFlipsToMakeAOrBEqualToC{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int minFlips(int a, int b, int c) {
            int ans = 0;
            while (c != 0 || a != 0 || b != 0) {
                // 二进制的第一位数字
                int cv = c & 1, av = a & 1, bv = b & 1;
                c >>= 1;
                a >>= 1;
                b >>= 1;
                // 不需要进行翻转
                if ((av | bv) == cv) {
                    continue;
                }
                // 需要进行翻转
                if (cv == 1) {
                    ans += 1;
                } else {
                    if (av == 1) {
                        ans += 1;
                    }
                    if (bv == 1) {
                        ans += 1;
                    }
                }
            }
            return ans;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}