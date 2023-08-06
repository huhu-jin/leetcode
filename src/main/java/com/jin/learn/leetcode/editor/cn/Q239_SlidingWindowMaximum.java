//  [239]滑动窗口最大值

//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 
// 👍 1089 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


public class Q239_SlidingWindowMaximum{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 难点在于如何在 O(1)时间算出每个「窗口」中的最大值
        //在一堆数字中，已知最值，如果给这堆数添加一个数，那么比较一下就可以很快算出最值；
    // 但如果减少一个数，就不一定能很快得到最值了，而要遍历所有数重新找最值。
    // 回到这道题的场景，每个窗口前进的时候，要添加一个数同时减少一个数，所以想在 O(1) 的时间得出新的最值，就需要「单调队列」这种特殊的数据结构来辅助了。
    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue myQueue = new MyQueue();
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            myQueue.add(nums[i]);
            if (i >=k-1) {
                ans[i - k + 1] = myQueue.getMax();
                myQueue.pop(nums[i-k+1]);
            }
        }
        return ans;
    }

    // 递减的队列
    public class MyQueue{

        private Deque<Integer> queue = new LinkedList<>();

        public void add(Integer i){
            while (!queue.isEmpty() && queue.peekLast() < i) {
                queue.pollLast();
            }
            queue.add(i);
        }

        public int getMax() {
            return queue.peekFirst();
        }

        public void pop(int i){
            if (!queue.isEmpty() && queue.peekFirst() == i) {
                queue.pollFirst();
            }
        }


    }


}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
    }
  
}
