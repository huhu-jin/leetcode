//  [1133]最大唯一数

//给你一个整数数组 A，请找出并返回在该数组中仅出现一次的最大整数。 
//
// 如果不存在这个只出现一次的整数，则返回 -1。 
//
// 
//
// 示例 1： 
//
// 输入：[5,7,3,9,4,9,8,3,1]
//输出：8
//解释： 
//数组中最大的整数是 9，但它在数组中重复出现了。而第二大的整数是 8，它只出现了一次，所以答案是 8。
// 
//
// 示例 2： 
//
// 输入：[9,9,8,8]
//输出：-1
//解释： 
//数组中不存在仅出现一次的整数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 2000 
// 0 <= A[i] <= 1000 
// 
// Related Topics 数组 哈希表 排序 
// 👍 12 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Arrays;


public class LargestUniqueNumber{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 不用看
    public int largestUniqueNumber(int[] nums) {
        if(nums == null || nums.length==0) return -1;
        if(nums.length==1) return nums[0];
        Arrays.sort(nums);
        int i = nums.length-1;
        while (i > 0) {
            int j = i-1;
            while ( j>=0 && nums[j] == nums[i]) {
                j--;
            }
            if (j+1 ==i) return nums[i];
            i=j;
        }
        if (nums[0] !=nums[1]) return nums[0];
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().largestUniqueNumber(new int[]{11,12,12});
    }
  
}