//  [253]会议室 II

//给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，为避免
//会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[0,30],[5,10],[15,20]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[7,10],[2,4]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// 0 <= starti < endi <= 106 
// 
// Related Topics 贪心 数组 双指针 排序 堆（优先队列） 
// 👍 302 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.PriorityQueue;


public class MeetingRoomsIi{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 按开始时间排序
    // 结束时间 逐个放入最小堆中
    // 在放入前判断 如果新的开始时间＞ 最小堆最小结束时间 (说明可以接上) 移除最小时间
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (i,j)->i[0]-j[0]);

        // 结束时间 最小堆
        PriorityQueue<Integer> allocator = new PriorityQueue<>(intervals.length, (i,j)-> i-j);
        allocator.add(intervals[0][1]);// 第一结束时间入堆

        // 迭代
        for (int i = 1; i < intervals.length; i++) {

            // 新的开始时间 > 最小结束时间
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }
            allocator.add(intervals[i][1]); // 最小结束时间 出堆
        }
        return allocator.size();

    }

    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().minMeetingRooms(new int[][]{{1, 10}, {2, 7}, {3, 19}, {8, 12}, {10, 20}, {11, 30}});
    }
  
}