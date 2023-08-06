//  [剑指 Offer 39]数组中出现次数超过一半的数字

//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
// Related Topics 数组 哈希表 分治 计数 排序 
// 👍 169 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class QJZOffer39_ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
    // 摩尔投票 遇到 相同票数++ 不同票数--
class Solution {
    public int majorityElement(int[] nums) {
        int x =0;
        int count=0;
        for (int i : nums) {
            if (count == 0)  x = i;
            if (x == i) {
                count++;
            }else {
                count--;
            }
        }
    return x;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
