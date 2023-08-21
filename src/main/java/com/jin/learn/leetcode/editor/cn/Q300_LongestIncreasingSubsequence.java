//  [300]最长递增子序列

//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计时间复杂度为 O(n2) 的解决方案吗？ 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 数组 二分查找 动态规划 
// 👍 1762 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Arrays;


public class Q300_LongestIncreasingSubsequence{


/*
dp[i] 表示：以 nums[i] 结尾 的「上升子序列」的长度。注意：这个定义中 nums[i] 必须被选取，且必须是这个子序列的最后一个元素；
状态转移方程 : 如果一个较大的数接在较小的数后面，就会形成一个更长的子序列。只要 nums[i] 严格大于在它位置之前的某个数，那么 nums[i] 就可以接在这个数后面形成一个更长的上升子序列。
             dp[i] = Math.max(dp[i], dp[j] + 1);

*/
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int lengthOfLIS1(int[] nums) {
        if(nums == null) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int ans =1;


        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {  // i 大于 在它前面的某个数(nums[j]),  dp[i] 可能就是 dp[j] + 1
                    dp[i] = Math.max(dp[i], dp[j] + 1); // dp[i] 存最大值
                }
            }
            ans = Math.max(dp[i], ans); //最大
        }
        return ans;
    }

    // 优化 https://leetcode.cn/problems/longest-increasing-subsequence/solutions/24173/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
    // tail 单调栈  到某个位置时候的 最小 子序列
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, ans = 1;
        int[] f = new int[n + 1]; // +1 防止越界
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            int l = 1, r = i + 1;
            // 二分查找
            while (l < r) {
                int mid = l + r >> 1;
                if (f[mid] >= nums[i]) r = mid;
                else l = mid + 1;
            }
            f[r] = nums[i];
            ans = Math.max(ans, r);
        }
        return ans ;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6});
    }
  
}
