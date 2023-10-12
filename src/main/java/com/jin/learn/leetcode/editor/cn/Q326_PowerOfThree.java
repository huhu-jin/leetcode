//  [326]3 的幂

//给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。 
//
// 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3ˣ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 27
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：n = 9
//输出：true
// 
//
// 示例 4： 
//
// 
//输入：n = 45
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= n <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能不使用循环或者递归来完成本题吗？ 
//
// Related Topics 递归 数学 👍 316 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q326_PowerOfThree{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public boolean isPowerOfThree(int n) {
            return n > 0 && 1162261467 % n == 0;
        }


        // https://leetcode.cn/problems/power-of-three/solutions/1012126/gong-shui-san-xie-yi-ti-san-jie-shu-xue-8oiip/
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}