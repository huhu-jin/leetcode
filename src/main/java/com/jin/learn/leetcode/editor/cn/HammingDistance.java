//  [461]汉明距离

//两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。 
//
// 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 1, y = 4
//输出：2
//解释：
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//上面的箭头指出了对应二进制位不同的位置。
// 
//
// 示例 2： 
//
// 
//输入：x = 3, y = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x, y <= 231 - 1 
// 
// Related Topics 位运算 
// 👍 503 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class HammingDistance{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 异或 统计1的个数
    public int hammingDistance(int x, int y) {
        int temp = x ^ y;
        int ans =0;

        while (temp != 0) {
            if((temp & 1) !=0) ans++;
            temp = temp >> 1;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().hammingDistance(2, 4);
    }
  
}