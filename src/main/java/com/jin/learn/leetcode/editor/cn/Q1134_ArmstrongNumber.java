//  [1134]阿姆斯特朗数

//假设存在一个 k 位数 N，其每一位上的数字的 k 次幂的总和也是 N，那么这个数是阿姆斯特朗数。 
//
// 给你一个正整数 N，让你来判定他是否是阿姆斯特朗数，是则返回 true，不是则返回 false。 
//
// 
//
// 示例 1： 
//
// 输入：153
//输出：true
//示例： 
//153 是一个 3 位数，且 153 = 1^3 + 5^3 + 3^3。
// 
//
// 示例 2： 
//
// 输入：123
//输出：false
//解释： 
//123 是一个 3 位数，且 123 != 1^3 + 2^3 + 3^3 = 36。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 10^8 
// 
// Related Topics 数学 
// 👍 8 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q1134_ArmstrongNumber{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
    // 不用看
class Solution {
    public boolean isArmstrong(int n) {
        int len = String.valueOf(n).length();
        int temp=0;
        int ori = n;
        while (n != 0) {
            temp += Math.pow(n % 10, len);
            n = n / 10;
        }
        return temp == ori;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
