//  [2540]最小公共值

//给你两个整数数组 nums1 和 nums2 ，它们已经按非降序排序，请你返回两个数组的 最小公共整数 。如果两个数组 nums1 和 nums2 没有公共
//整数，请你返回 -1 。 
//
// 如果一个整数在两个数组中都 至少出现一次 ，那么这个整数是数组 nums1 和 nums2 公共 的。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,3], nums2 = [2,4]
//输出：2
//解释：两个数组的最小公共元素是 2 ，所以我们返回 2 。
// 
//
// 示例 2： 
//
// 输入：nums1 = [1,2,3,6], nums2 = [2,3,4,5]
//输出：2
//解释：两个数组中的公共元素是 2 和 3 ，2 是较小值，所以返回 2 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 10⁵ 
// 1 <= nums1[i], nums2[j] <= 10⁹ 
// nums1 和 nums2 都是 非降序 的。 
// 
//
// Related Topics 数组 哈希表 双指针 二分查找 👍 16 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.HashSet;

//  不用看
public class Q2540_MinimumCommonValue{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {

        int ans = -1;

        HashSet<Integer> memo = new HashSet<>();
        for (int n : nums1) {
            memo.add(n);
        }


        for (int m : nums2) {
            if (memo.contains(m)) {
                if (ans == -1 || ans > m) {
                    ans = m;
                }
            }


        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}