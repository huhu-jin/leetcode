//  [1151]最少交换次数来组合所有的 1

//给出一个二进制数组 data，你需要通过交换位置，将数组中 任何位置 上的 1 组合到一起，并返回所有可能中所需 最少的交换次数。 
//
// 
//
// 示例 1： 
//
// 输入：[1,0,1,0,1]
//输出：1
//解释： 
//有三种可能的方法可以把所有的 1 组合在一起：
//[1,1,1,0,0]，交换 1 次；
//[0,1,1,1,0]，交换 2 次；
//[0,0,1,1,1]，交换 1 次。
//所以最少的交换次数为 1。
// 
//
// 示例 2： 
//
// 输入：[0,0,0,1,0]
//输出：0
//解释： 
//由于数组中只有一个 1，所以不需要交换。
// 
//
// 示例 3： 
//
// 输入：[1,0,1,0,1,0,0,1,1,0,1]
//输出：3
//解释：
//交换 3 次，一种可行的只用 3 次交换的解决方案是 [0,0,0,0,0,1,1,1,1,1,1]。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= data.length <= 10^5 
// 0 <= data[i] <= 1 
// 
// Related Topics 数组 滑动窗口 
// 👍 42 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q1151_MinimumSwapsToGroupAll1sTogether{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 交换的次数 可以等价为
    // 窗口滑动, 找到特定长度(countOne)窗口中, 0最少的窗口
    // 10101001101
    // countOne =6 窗口长度
    // countZero 窗口0的个数

    public int minSwaps(int[] data) {
        int countOne = 0;
        int n = data.length;
        for (int i = 0; i < n; i++) {
            if(data[i] == 1) countOne++;
        }

        int ans = Integer.MAX_VALUE;
        int countZero=0;
        int left=0, right =0;

        while (right < n) {
            if (data[right] == 0) countZero++;

            right++;
            if (right - left > countOne) {
                if (data[left]  == 0) countZero--;
                left++;
            }

            if (right-left == countOne) ans = Math.min(ans, countZero);

        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().minSwaps(new int[]{1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1});
    }
  
}
