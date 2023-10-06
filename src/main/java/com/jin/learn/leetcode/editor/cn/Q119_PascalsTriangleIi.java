//  [119]杨辉三角 II

//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。 
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
//输入: rowIndex = 3
//输出: [1,3,3,1]
// 
//
// 示例 2: 
//
// 
//输入: rowIndex = 0
//输出: [1]
// 
//
// 示例 3: 
//
// 
//输入: rowIndex = 1
//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 
//
// Related Topics 数组 动态规划 👍 511 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class Q119_PascalsTriangleIi{
  
// 逻辑模拟 可以不看
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public List<Integer> getRow(int rowIndex) {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(1);

            while (rowIndex > 0) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int i = 0; i < ans.size(); i++) {
                    if ( i == 0) {
                        temp.add(ans.get(i));
                    } else {
                        temp.add(ans.get(i) + ans.get(i -1));
                    }
                }
                temp.add(1);
                ans = temp;
                rowIndex--;

            }
            return ans;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}