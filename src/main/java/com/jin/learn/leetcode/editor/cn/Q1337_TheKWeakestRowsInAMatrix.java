//  [1337]矩阵中战斗力最弱的 K 行

//给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。 
//
// 请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。 
//
// 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。 
//
// 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。 
//
// 
//
// 示例 1： 
//
// 
//输入：mat = 
//[[1,1,0,0,0],
// [1,1,1,1,0],
// [1,0,0,0,0],
// [1,1,0,0,0],
// [1,1,1,1,1]], 
//k = 3
//输出：[2,0,3]
//解释：
//每行中的军人数目：
//行 0 -> 2 
//行 1 -> 4 
//行 2 -> 1 
//行 3 -> 2 
//行 4 -> 5 
//从最弱到最强对这些行排序后得到 [2,0,3,1,4]
// 
//
// 示例 2： 
//
// 
//输入：mat = 
//[[1,0,0,0],
// [1,1,1,1],
// [1,0,0,0],
// [1,0,0,0]], 
//k = 2
//输出：[0,2]
//解释： 
//每行中的军人数目：
//行 0 -> 1 
//行 1 -> 4 
//行 2 -> 1 
//行 3 -> 1 
//从最弱到最强对这些行排序后得到 [0,2,3,1]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 2 <= n, m <= 100 
// 1 <= k <= m 
// matrix[i][j] 不是 0 就是 1 
// 
//
// Related Topics 数组 二分查找 矩阵 排序 堆（优先队列） 👍 217 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.PriorityQueue;


public class Q1337_TheKWeakestRowsInAMatrix{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>( (i,j) ->{
            int v = j[1] - i[1];
            if (v == 0) {
                return j[0] - i[0];
            }
            return v;

        });

        // 需要 最小堆 ，那么 queue 反而是最大堆， 因为要从top 把大的删除
        for (int i = 0; i < mat.length; i++) {
            int count = binarySearch(mat[i]);

            queue.add(new int[]{i, count}); // 先 add
            if (queue.size() > k) {
                queue.poll(); // 在poll 删除
            }

        }

        int[] ans = new int[k];
        int i = k-1;
        while (!queue.isEmpty()) {
            ans[i] = queue.poll()[0];
            i--;
        }
        return ans;
    }

        private int binarySearch(int[] arr) {
            int l = -1;
            int r = arr.length;

            while (l + 1 < r) {
                int mid = (l+r)/2;
                if (arr[mid] == 1) {
                    l = mid;
                }else {
                    r = mid;
                }

            }
            return l+1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().kWeakestRows(new int[][]{{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}}, 2);
    }
  
}