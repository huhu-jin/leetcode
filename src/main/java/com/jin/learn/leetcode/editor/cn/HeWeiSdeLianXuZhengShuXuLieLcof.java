//  [剑指 Offer 57 - II]和为s的连续正数序列

//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// Related Topics 数学 双指针 枚举 
// 👍 282 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;


public class HeWeiSdeLianXuZhengShuXuLieLcof{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> ret = new LinkedList<>();
        int i = 1;
        int j = 2;
        while (i < j) {
            while (i < j && (i + j)*(j-i+1)/2<target) j++;
            while (i < j && (i + j)*(j-i+1)/2>target) i++;
            if ((i + j) * (j - i + 1) / 2 == target) {
                ret.add(toArray(i, j));
                j++;
            }
        }
        return ret.toArray(new int[0][0]);
    }


        private int[] toArray(int i, int j) {
           int []ret =  new int[j - i + 1];
            for (int pos=0; pos < ret.length; pos++) {
                ret[pos] = pos + i;
            }
           return ret;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().findContinuousSequence(9);

    }
  
}