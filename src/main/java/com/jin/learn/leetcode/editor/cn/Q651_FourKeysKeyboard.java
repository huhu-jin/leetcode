//  [651]4键键盘

//假设你有一个特殊的键盘包含下面的按键： 
//
// Key 1: (A)：在屏幕上打印一个 'A'。 
//
// Key 2: (Ctrl-A)：选中整个屏幕。 
//
// Key 3: (Ctrl-C)：复制选中区域到缓冲区。 
//
// Key 4: (Ctrl-V)：将缓冲区内容输出到上次输入的结束位置，并显示在屏幕上。 
//
// 现在，你只可以按键 N 次（使用上述四种按键），请问屏幕上最多可以显示几个 'A'呢？ 
//
// 样例 1: 
//
// 输入: N = 3
//输出: 3
//解释: 
//我们最多可以在屏幕上显示三个'A'通过如下顺序按键：
//A, A, A
// 
//
// 
//
// 样例 2: 
//
// 输入: N = 7
//输出: 9
//解释: 
//我们最多可以在屏幕上显示九个'A'通过如下顺序按键：
//A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V
// 
//
// 
//
// 注释: 
//
// 
// 1 <= N <= 50 
// 结果不会超过 32 位有符号整数范围。 
// 
//
// 
// Related Topics 数学 动态规划 
// 👍 66 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q651_FourKeysKeyboard{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int maxA(int n) {
        int [] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            dp[i] = dp[i-1] + 1; // 先是直接按A
            for (int j = 2; j < i; j++) { // j是按ctrl+C的地方
                // i-j是连续按了多少次ctrl+V，+1是因为原来就有dp[j-2]的A在那里，所以总数是dp[j-2] * (i-j+1)
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        Solution solution = new Solution();
    }
  
}
