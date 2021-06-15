//  [剑指 Offer 03]数组中重复的数字

//找出数组中重复的数字。 
//
// 
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。 
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000 
// Related Topics 数组 哈希表 
// 👍 442 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class ShuZuZhongZhongFuDeShuZiLcof{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findRepeatNumber(int[] nums) {
        if(nums == null) return -1 ;

        byte [] memo = new byte[100000];

        for(int num : nums){
            if(memo[num] == 1) return num;
            memo[num] =1;
        }
        return -1;
    }

    // 原地换位 在i位置 就是i.
    public int findRepeatNumber2(int[] nums) {

        if (nums == null) return -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == i) {
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i]) return nums[i]; // nums[nums[i]] == nums[i] 这里比较秀
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){

        new ShuZuZhongZhongFuDeShuZiLcof.Solution().findRepeatNumber(new int[]{1, 2, 3, 1});
        
    }
  
}