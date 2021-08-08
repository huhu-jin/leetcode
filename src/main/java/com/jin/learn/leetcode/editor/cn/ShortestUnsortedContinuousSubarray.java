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


public class ShortestUnsortedContinuousSubarray{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 1 利用 treemap
    // 2treemap找一个比i大key (需要翻转) end = i;
    // 2start 历史最小
    // 3 ans = end -start
    public int findUnsortedSubarray1(int[] nums) {
        if(nums == null || nums.length ==1) return 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Integer start = null;
        Integer end=0;
        map.put(nums[0],0);
        for (int i = 1; i < nums.length; i++) {
            Map.Entry<Integer, Integer> entry = map.higherEntry(nums[i]); // 得到一个比原先key大的
            if (entry != null) {
                if (start == null) {
                    start = entry.getValue();
                }else {
                    start = Math.min(start, entry.getValue());
                }
                end = i;
            }
            map.putIfAbsent(nums[i], i);
        }
        if(start == null) return 0;
        return end - start + 1;
    }


    // 比较取巧的方法
    // 排序后nums 和原来的 比较
    // 找到不同的开始和结束
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int i = 0, j = n - 1;
        while (i <= j && nums[i] == arr[i]) i++;
        while (i <= j && nums[j] == arr[j]) j--;
        return j - i + 1;
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