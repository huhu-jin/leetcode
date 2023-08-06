//  [118]杨辉三角

//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics 数组 动态规划 👍 782 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;


public class Q118_PascalsTriangle{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
    // 不用看
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new LinkedList<>();

        List<Integer> root = new LinkedList<>();
        root.add(1);
        ans.add(root);

        for (int count = 2; count <= numRows; count++) {
            List<Integer> pre = ans.get(count - 2);
            List <Integer> temp = new LinkedList<>();
            int i =1;
            temp.add(1);
            while (i < count-1) {
                temp.add(pre.get(i - 1) + pre.get(i));
                i++;
            }
            temp.add(1);
            ans.add(temp);
        }


        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().generate(5);
        
    }
  
}
