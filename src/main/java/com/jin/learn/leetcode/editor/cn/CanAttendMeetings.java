package com.jin.learn.leetcode.editor.cn;

import java.util.Arrays;

public class CanAttendMeetings {

    class Solution {
        public boolean canAttendMeetings(int[][] intervals) {
            if(intervals == null || intervals.length == 0) return false;
            Arrays.sort(intervals, (a, b)->{
                 return a[0] - b[0];
            });
            for(int i = 1; i < intervals.length; i++){
                if(intervals[i][0] < intervals[i - 1][1]) return false;
            }
            return true;
        }
    }
}
