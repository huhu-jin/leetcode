//  [1539]第 k 个缺失的正整数

//给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。 
//
// 请你找到这个数组里第 k 个缺失的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [2,3,4,7,11], k = 5
//输出：9
//解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,2,3,4], k = 2
//输出：6
//解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 1000 
// 1 <= arr[i] <= 1000 
// 1 <= k <= 1000 
// 对于所有 1 <= i < j <= arr.length 的 i 和 j 满足 arr[i] < arr[j] 
// 
//
// 
//
// 进阶： 
//
// 你可以设计一个时间复杂度小于 O(n) 的算法解决此问题吗？ 
//
// Related Topics 数组 二分查找 👍 209 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q1539_KthMissingPositiveNumber{
//
//    如果数组中没有小于k的数，那么第k个缺失的数字就是k
//    如果有一个<=K的数字，k++
//    最后返回k

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int findKthPositive(int[] arr, int k) {
            int len=arr.length;
            for(int i=0;i<len;i++){
                if(arr[i]<=k) k++;
            }
            return k;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().findKthPositive(new int[]{1,2,3}, 2);
    }
  
}