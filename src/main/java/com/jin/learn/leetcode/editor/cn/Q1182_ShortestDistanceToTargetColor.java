//  [1182]与目标颜色间的最短距离

//给你一个数组 colors，里面有 1、2、 3 三种颜色。 
//
// 我们需要在 colors 上进行一些查询操作 queries，其中每个待查项都由两个整数 i 和 c 组成。 
//
// 现在请你帮忙设计一个算法，查找从索引 i 到具有目标颜色 c 的元素之间的最短距离。 
//
// 如果不存在解决方案，请返回 -1。 
//
// 
//
// 示例 1： 
//
// 输入：colors = [1,1,2,1,3,2,2,3,3], queries = [[1,3],[2,2],[6,1]]
//输出：[3,0,3]
//解释： 
//距离索引 1 最近的颜色 3 位于索引 4（距离为 3）。
//距离索引 2 最近的颜色 2 就是它自己（距离为 0）。
//距离索引 6 最近的颜色 1 位于索引 3（距离为 3）。
// 
//
// 示例 2： 
//
// 输入：colors = [1,2], queries = [[0,3]]
//输出：[-1]
//解释：colors 中没有颜色 3。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= colors.length <= 5*10^4 
// 1 <= colors[i] <= 3 
// 1 <= queries.length <= 5*10^4 
// queries[i].length == 2 
// 0 <= queries[i][0] < colors.length 
// 1 <= queries[i][1] <= 3 
// 
// Related Topics 数组 二分查找 动态规划 
// 👍 26 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.sql.Array;
import java.util.*;


public class Q1182_ShortestDistanceToTargetColor{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 对 三种颜色 分类
    // 然后  通过 indexList 二分查找
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {

        // 分类
        List<Integer> ans=new ArrayList<>();
        if(queries.length==0){
            return ans;
        }
        Map<Integer,List<Integer>> memo=new HashMap<>();

        for(int i=0;i<colors.length;i++){
            memo.computeIfAbsent(colors[i], item -> new ArrayList<>()).add(i);
        }

        // 二分查找
        for (int[] query : queries) {
            List<Integer> posList = memo.get(query[1]);
            if(posList == null){
                ans.add(-1);
                continue;
            }


            int pos = binarySearch(posList, query[0]);
            if (pos >= 0) {
                ans.add(0);
            //比数组内要小
            } else if (pos == -1) {
                ans.add(posList.get(0)-query[0]);
                //比数组内的要大
            } else if (pos == -(posList.size() + 1)) {
                ans.add(query[0]-posList.get(posList.size()-1));
            }else {
                int location=-pos-1;
                ans.add(Math.min(query[0]-posList.get(location-1),posList.get(location)-query[0]));

            }

        }
        return ans;
    }


    public int binarySearch(List<Integer> posList, int target) {
        int left =0;
        int right = posList.size()-1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (posList.get(mid) < target)
                left = mid+1;
             else if (posList.get(mid) >target)
                right = mid-1;
            else
                return mid;
        }
        return -(left+1);
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
    }
  
}
