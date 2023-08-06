//  [1198]找出所有行中最小公共元素

//给你一个矩阵 mat，其中每一行的元素都已经按 严格递增 顺序排好了。请你帮忙找出在所有这些行中 最小的公共元素。 
//
// 如果矩阵中没有这样的公共元素，就请返回 -1。 
//
// 
//
// 示例： 
//
// 
//输入：mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= mat.length, mat[i].length <= 500 
// 1 <= mat[i][j] <= 10^4 
// mat[i] 已按严格递增顺序排列。 
// 
// Related Topics 数组 哈希表 二分查找 计数 矩阵 
// 👍 20 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.ArrayList;


public class Q1198_FindSmallestCommonElementInAllRows{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 两种方法:
    // 交集
    // 二分查找
    public int smallestCommonElement(int[][] mat) {
        if(mat == null || mat.length==0) return -1;
        ArrayList<Integer> pre = new ArrayList<>();
        for ( int i : mat[0]) {
            pre.add(i);
        }

        for (int i = 1; i < mat.length; i++) {
            ArrayList<Integer> cur = new ArrayList<>();
            for (int j : mat[i]) {
                cur.add(j);
            }
            pre.retainAll(cur);
        }

        if(pre.size()==0) return -1;
        return pre.get(0);
    }


}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
