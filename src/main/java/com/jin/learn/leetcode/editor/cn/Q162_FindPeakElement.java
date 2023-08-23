//  [162]寻找峰值

//峰值元素是指其值严格大于左右相邻值的元素。 
//
// 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。 
//
// 你可以假设 nums[-1] = nums[n] = -∞ 。 
//
// 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1]
//输出：2
//解释：3 是峰值元素，你的函数应该返回其索引 2。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,1,3,5,6,4]
//输出：1 或 5 
//解释：你的函数可以返回索引 1，其峰值元素为 2；
//     或者返回索引 5， 其峰值元素为 6。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 对于所有有效的 i 都有 nums[i] != nums[i + 1] 
// 
// Related Topics 数组 二分查找 👍 847 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q162_FindPeakElement{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 题设中一定存在 极值. 且 只要找到极值 就可以了
    // 红色 表示 峰顶的左侧
    // 蓝色分表示    峰顶  峰顶的右侧
    // 找蓝起点
    // 最右边 一定 蓝的
    // https://www.bilibili.com/video/BV1QK411d76w/?spm_id_from=333.788&vd_source=cddd85b95457ed135fe2b861b7bf803b
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 2; // 左闭 右闭
        while (l <= r) {
            int mid = l + r >> 1;
            if (nums[mid] > nums[mid + 1]) r = mid-1;
            else l = mid + 1;
        }
        return l;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().findPeakElement(new int[]{1, 2, 3, 1});
        
    }
  
}
