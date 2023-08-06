//  [252]会议室

//给定一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，请你判
//断一个人是否能够参加这里面的全部会议。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[0,30],[5,10],[15,20]]
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[7,10],[2,4]]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 0 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti < endi <= 106 
// 
// Related Topics 数组 排序 
// 👍 76 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Q252_MeetingRooms{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length==1) return true;

        // 排序
        Arrays.sort(intervals, (i, j) -> i[0] - j[0]);

        // 因为排序了 只要 逐个比较,
        // [a0,b0] [a1,b1]
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0]) {
                return false;
            }
        }
        return true;
    }


    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
