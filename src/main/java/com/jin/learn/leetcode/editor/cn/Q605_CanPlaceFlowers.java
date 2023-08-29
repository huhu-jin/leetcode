//  [605]种花问题

//假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。 
//
// 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则
//的情况下种入 n 朵花？能则返回 true ，不能则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：flowerbed = [1,0,0,0,1], n = 1
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：flowerbed = [1,0,0,0,1], n = 2
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= flowerbed.length <= 2 * 10⁴ 
// flowerbed[i] 为 0 或 1 
// flowerbed 中不存在相邻的两朵花 
// 0 <= n <= flowerbed.length 
// 
//
// Related Topics 贪心 数组 👍 609 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q605_CanPlaceFlowers{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 不用看
    public boolean canPlaceFlowers(int[] flowerbed, int n) {


        for (int i = 0; i < flowerbed.length; i++) {
            if (n == 0) return true;
            if (i - 1 >= 0 && i + 1 < flowerbed.length) {
                if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0 && flowerbed[i] == 0) {
                    flowerbed[i] =1;
                    n--;
                }
            }else if (i ==0 && i + 1 < flowerbed.length &&  flowerbed[i + 1] == 0 && flowerbed[i] == 0) {
                flowerbed[i] =1;
                n--;
            } else if (i == flowerbed.length - 1 && i - 1 >= 0  && flowerbed[i - 1] == 0 && flowerbed[i] == 0) {
                flowerbed[i] =1;
                n--;
            } else if (i == 0 && i == flowerbed.length - 1 && flowerbed[i] == 0) {
                flowerbed[i] =1;
                n--;
            }

        }

        return n == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().canPlaceFlowers(new int[]{0}, 1);
        new Solution().canPlaceFlowers(new int[]{1, 0, 0,0, 0, 1}, 2);
    }
  
}