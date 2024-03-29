//  [448]找到所有数组中消失的数字

//给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数
//字，并以数组的形式返回结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,3,2,7,8,2,3,1]
//输出：[5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1]
//输出：[2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 105 
// 1 <= nums[i] <= n 
// 
//
// 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。 
// Related Topics 数组 哈希表 
// 👍 787 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Q448_FindAllNumbersDisappearedInAnArray{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 排序
    // temp 和 nums 第i位置比较  小于就一直加到相等,   相等 一直 temp++
    //
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        Arrays.sort(nums);
        int temp =1;
        for (int i = 0; i < nums.length; i++) {
            while (temp < nums[i]) ans.add(temp++);
            if (temp == nums[i])  temp++;
        }
        while (temp <= nums.length) ans.add(temp++);

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().findDisappearedNumbers(new int[]{1,1,1});
    }
  
}
