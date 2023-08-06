//  [面试题 08.04]幂集

//幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
//  输入： nums = [1,2,3]
// 输出：
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 59 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class QMST0804_PowerSetLcci{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 假设是 [1,2,3]那么0,1,2,3,4,5,6,7 正好是位上数字就是 集合内容
    public List<List<Integer>> subsets(int[] nums) {
        int size = 1 << nums.length;
        List<List<Integer>> res = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j=0; j < nums.length; j++) {
                if (((i >> j) & 1) == 1) {
                    temp.add(nums[j]);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new QMST0804_PowerSetLcci.Solution().subsets(new int[]{1, 2, 3});
    }
  
}
