//  [56]合并区间

//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 数组 排序 
// 👍 1014 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Arrays;


public class MergeIntervals{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
      if (intervals == null || intervals.length == 1) return intervals;
      Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]); // 关键是先排序

        int[][] res = new int[intervals.length][2];
        // 初始化
        int count = 1;
        int [] temp = intervals[0];
        res[0] = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= temp[1]) {
                temp[1] = Math.max(intervals[i][1], temp[1]); // 合并
            }else {
                res[count++] = intervals[i]; // 加入结果
                temp = intervals[i];
            }
        }

        return Arrays.copyOf(res, count);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        Solution solution = new Solution();
    }
  
}