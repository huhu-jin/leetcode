//  [581]最短无序连续子数组

//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
// 
// 
// Related Topics 栈 贪心 数组 双指针 排序 单调栈 
// 👍 678 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;


public class Q581_ShortestUnsortedContinuousSubarray{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/solutions/422614/si-lu-qing-xi-ming-liao-kan-bu-dong-bu-cun-zai-de-/


    // 左边有序 中间无序 右边有序   分为这样三段
    // min max
    public int findUnsortedSubarray(int[] nums) {
        //初始化
        int len = nums.length;
        int min = nums[len-1];
        int max = nums[0];
        int begin = 0, end = -1;

        //遍历
        for(int i = 0; i < len; i++){
            if(nums[i] < max){     // 从左往右
                end = i;
            }else{
                max = nums[i]; // 当前值 > max , 那么 不需要排序 , end 不用往前走
            }

            if(nums[len-i-1] > min){    //从右到左维持最小值，寻找左边界begin
                begin = len-i-1;
            }else{
                min = nums[len-i-1];
            }
        }

        return end-begin+1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().findUnsortedSubarray(new int[]{1, 3, 5, 4, 2});
        new Solution().findUnsortedSubarray(new int[]{2, 3, 3, 2, 4});
        new Solution().findUnsortedSubarray(new int[]{3, 2, 1});
        new Solution().findUnsortedSubarray(new int[]{2, 1});
        new Solution().findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15});
    }
  
}
