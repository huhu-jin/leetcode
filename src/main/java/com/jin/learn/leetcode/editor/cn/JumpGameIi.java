//  [45]跳跃游戏 II

//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 假设你总是可以到达数组的最后一个位置。 
//
// 
//
// 示例 1: 
//
// 
//输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 105 
// 
// Related Topics 贪心算法 数组 
// 👍 1022 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

// 典型的 贪心算法
// 每一步选择最优 进行迭代
// 关键 nums[pos + i]+pos+i >= max+nextPos
public class JumpGameIi{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length <= 1 ) return 0;
        int pos =0;
        int count =0;
        for (; ; ) {
            int step = nums[pos];
            if(step>= nums.length-1-pos) {
                if(pos < nums.length-1){
                    count++;
                }
                break;
            }

            int max=0;
            int nextPos=0;
            for (int i = 1; step > 0; step--,i++) {
                if(nums[pos + i]+pos+i >= max+nextPos){
                    nextPos = pos + i;
                    max = nums[pos + i];
                }
            }
            pos = nextPos;
            count ++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().jump(new int[]{10,9,8,7,6,5,4,3,2,1,1,0});
    }
  
}