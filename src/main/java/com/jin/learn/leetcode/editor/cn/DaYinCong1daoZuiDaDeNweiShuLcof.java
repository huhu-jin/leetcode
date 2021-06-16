//  [剑指 Offer 17]打印从1到最大的n位数

//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。 
//
// 示例 1: 
//
// 输入: n = 1
//输出: [1,2,3,4,5,6,7,8,9]
// 
//
// 
//
// 说明： 
//
// 
// 用返回一个整数列表来代替打印 
// n 为正整数 
// 
// Related Topics 数学 
// 👍 130 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class DaYinCong1daoZuiDaDeNweiShuLcof{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] printNumbers(int n) {
        if( n == 0) return new int[0];
        int size = (int) Math.pow(10, n) - 1;
        int[] ret = new int[size];
        for (int i = 0; i < size; i++) {
            ret[i] = i+1;
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
    }
  
}