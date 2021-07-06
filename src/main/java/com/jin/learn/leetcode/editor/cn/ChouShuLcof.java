//  [剑指 Offer 49]丑数

//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 
// 👍 182 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class ChouShuLcof{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        public int nthUglyNumber(int n) {
            int a = 0, b = 0, c = 0;
            int[] dp = new int[n];
            dp[0] = 1;
            for(int i = 1; i < n; i++) {
                int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
                dp[i] = Math.min(Math.min(n2, n3), n5);
                if(dp[i] == n2) a++;
                if(dp[i] == n3) b++;
                if(dp[i] == n5) c++;
            }
            return dp[n - 1];
        }


    public int nthUglyNumber1(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int count = 2;
        int pos =2;
        while (pos <= n) {
            if (isUglyNumber(count)) {
                dp[pos] = count;
                pos++;
            }
            count++;
        }
        return dp[n];
    }

        private boolean isUglyNumber(int count) {
            while (true) {
                if(count == 1) return true;
                int a = count/5;
                int b = count%5;
                if(b ==0){
                    count = a;
                    continue;
                }

                 a = count/3;
                 b = count%3;
                if(b ==0){
                    count = a;
                    continue;
                }

                a = count/2;
                b = count%2;
                if(b ==0){
                    count = a;
                    continue;
                }
                return false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        int i = new Solution().nthUglyNumber(481);
    }
  
}