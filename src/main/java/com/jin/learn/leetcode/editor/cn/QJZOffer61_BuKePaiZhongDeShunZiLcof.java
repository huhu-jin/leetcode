//  [剑指 Offer 61]扑克牌中的顺子

//从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任
//意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// Related Topics 数组 排序 
// 👍 142 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;


public class QJZOffer61_BuKePaiZhongDeShunZiLcof{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isStraight(int[] nums) {
             Arrays.sort(nums);
            int temp = 0;
            int zeroCount = 0;
            for(int n: nums){
                if(n == 0) {
                    zeroCount++;
                    continue;
                }
                if(temp == 0) {temp = n; continue;}

                if((temp +1+zeroCount) >= n && temp != n) { //  不重复 且 当前值加上大小王可以组成顺子
                    zeroCount -= n-temp-1;
                    temp=n;
                }else{
                    return false;
                }

            }
            return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        Assert.assertFalse(new Solution().isStraight(new int[]{0, 0, 1, 1, 5}));
        Assert.assertTrue(new Solution().isStraight(new int[]{0, 0, 1, 3, 5}));
        Assert.assertTrue(new Solution().isStraight(new int[]{0, 0, 2, 4, 5}));
        Assert.assertTrue(new Solution().isStraight(new int[]{1, 2, 3, 4, 5}));
    }
  
}
