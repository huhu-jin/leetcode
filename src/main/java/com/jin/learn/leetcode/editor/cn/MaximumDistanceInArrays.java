//  [624]数组列表中的最大距离

//给定 m 个数组，每个数组都已经按照升序排好序了。现在你需要从两个不同的数组中选择两个整数（每个数组选一个）并且计算它们的距离。两个整数 a 和 b 之间的
//距离定义为它们差的绝对值 |a-b| 。你的任务就是去找到最大距离 
//
// 示例 1： 
//
// 输入： 
//[[1,2,3],
// [4,5],
// [1,2,3]]
//输出： 4
//解释：
//一种得到答案 4 的方法是从第一个数组或者第三个数组中选择 1，同时从第二个数组中选择 5 。
// 
//
// 
//
// 注意： 
//
// 
// 每个给定数组至少会有 1 个数字。列表中至少有两个非空数组。 
// 所有 m 个数组中的数字总数目在范围 [2, 10000] 内。 
// m 个数组中所有整数的范围在 [-10000, 10000] 内。 
// 
//
// 
// Related Topics 贪心 数组 
// 👍 53 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.List;


public class MaximumDistanceInArrays{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // 只关注 最大值和 最小值
        //然后 一直记住 所有最大值和最小值
        //然后去  max(所有最大值-当前最小值  , 当前最大值- 所有最小值)
        public int maxDistance(List<List<Integer>> arrays) {
            int res = 0, min_val = arrays.get(0).get(0), max_val = arrays.get(0).get(arrays.get(0).size()- 1);
            for (int i = 1; i < arrays.size(); i++) {
                res = Math.max(res, Math.max(Math.abs(arrays.get(i).get(arrays.get(i).size()- 1) - min_val), Math.abs(max_val - arrays.get(i).get(0))));
                min_val = Math.min(min_val, arrays.get(i).get(0));
                max_val = Math.max(max_val, arrays.get(i).get(arrays.get(i).size()- 1));
            }
            return res;
        }
// 数组的比较看得清楚
//        public int maxDistance(int[][] list) {
//            int res = 0;
//            for (int i = 0; i < list.length - 1; i++) {
//                for (int j = i + 1; j < list.length; j++) {
//                    res = Math.max(res, Math.abs(list[i][0] - list[j][list[j].length - 1]));
//                    res = Math.max(res, Math.abs(list[j][0] - list[i][list[i].length - 1]));
//                }
//            }
//            return res;
//        }


}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}