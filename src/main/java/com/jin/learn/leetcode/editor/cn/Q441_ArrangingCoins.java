//  [441]排列硬币

//你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。 
//
// 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 5
//输出：2
//解释：因为第三行不完整，所以返回 2 。
// 
//
// 示例 2： 
// 
// 
//输入：n = 8
//输出：3
//解释：因为第四行不完整，所以返回 3 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
//
// Related Topics 数学 二分查找 👍 286 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q441_ArrangingCoins{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 二分 注意越界
    public int arrangeCoins(int n) {
        long l = 0;
        long r = (long) n + 1;
        while (l + 1 < r) {
            long m = (l + r) / 2;
            if (getSize(m) <= n) {
                l = m;
            }else {
                r = m;
            }

        }

        return (int)l;

    }

        private long getSize(long m) {
            return (m + 1) * m / 2;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().arrangeCoins(2147483647);
    }
  
}