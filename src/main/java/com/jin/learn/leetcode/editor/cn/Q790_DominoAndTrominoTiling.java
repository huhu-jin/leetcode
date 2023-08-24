//  [790]多米诺和托米诺平铺

//有两种形状的瓷砖：一种是 2 x 1 的多米诺形，另一种是形如 "L" 的托米诺形。两种形状都可以旋转。 
//
// 
//
// 给定整数 n ，返回可以平铺 2 x n 的面板的方法的数量。返回对 10⁹ + 7 取模 的值。 
//
// 平铺指的是每个正方形都必须有瓷砖覆盖。两个平铺不同，当且仅当面板上有四个方向上的相邻单元中的两个，使得恰好有一个平铺有一个瓷砖占据两个正方形。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: n = 3
//输出: 5
//解释: 五种不同的方法如上所示。
// 
//
// 示例 2: 
//
// 
//输入: n = 1
//输出: 1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// 
//
// Related Topics 动态规划 👍 318 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q790_DominoAndTrominoTiling{

// https://leetcode.cn/problems/domino-and-tromino-tiling/solutions/1968516/by-endlesscheng-umpp/?envType=study-plan-v2&envId=leetcode-75

//     (f[i - 1] * 2 + f[i - 3]) 找不到规律
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //
    private  final long MOD = (long) 1e9 + 7;
    private  final long[] f = new long[1001];

         {
            f[0] = f[1] = 1;
            f[2] = 2;
            for (int i = 3; i <= 1000; ++i)
                f[i] = (f[i - 1] * 2 + f[i - 3]) % MOD;
        }

        public int numTilings(int n) {
            return (int) f[n];
        }

}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}