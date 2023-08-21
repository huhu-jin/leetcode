//  [1004]最大连续1的个数 III

//给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//输出：6
//解释：[1,1,1,0,0,1,1,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 6。 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//输出：10
//解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 10。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 不是 0 就是 1 
// 0 <= k <= nums.length 
// 
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 616 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


// 窗口滑动 用 temp 去计数

public class Q1004_MaxConsecutiveOnesIii{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestOnes(int[] nums, int k) {

        int i = 0;
        int j = 0;
        int ans = 0;
        int temp =0;
        while (j < nums.length) {

            if (nums[j] == 1) {
                temp ++ ;
                j++;
            } else if (nums[j] == 0 & k > 0) {
                j++;
                k--;
                temp++;
            }else {
               if (i < j && nums[i] == 0) {
                    k++;
                }

                if (i == j) {
                    j++;
                }else{
                    temp--;
                }

                i++;
            }


            ans = Math.max(ans, temp);
        }




        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().longestOnes(new int[]{0,0,1,1,1,0,0}, 0);
        new Solution().longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3);

    }
  
}