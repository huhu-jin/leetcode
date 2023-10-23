//  [414]第三大的数

//给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3, 2, 1]
//输出：1
//解释：第三大的数是 1 。 
//
// 示例 2： 
//
// 
//输入：[1, 2]
//输出：2
//解释：第三大的数不存在, 所以返回最大的数 2 。
// 
//
// 示例 3： 
//
// 
//输入：[2, 2, 3, 1]
//输出：1
//解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
//此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？ 
//
// Related Topics 数组 排序 👍 443 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.PriorityQueue;


public class Q414_ThirdMaximumNumber{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // priority 默认从小到大， poll 出来 最小 ，是最小堆
    public int thirdMax(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i : set) {
            if (queue.size() == 3 && queue.peek() < i) {
                queue.poll();
            }
            if (queue.size() < 3) {
                queue.add(i);

            }
        }


        if (queue.size() == 3) return queue.poll();

        int i=0;
        while (!queue.isEmpty()) {
            i = queue.poll();
        }
        return i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){

        new Solution().thirdMax(new int[]{-4,-5,-3,-2,-1});
        
    }
  
}