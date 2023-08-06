//  [1215]步进数

//如果一个整数上的每一位数字与其相邻位上的数字的绝对差都是 1，那么这个数就是一个「步进数」。 
//
// 例如，321 是一个步进数，而 421 不是。 
//
// 给你两个整数，low 和 high，请你找出在 [low, high] 范围内的所有步进数，并返回 排序后 的结果。 
//
// 
//
// 示例： 
//
// 输入：low = 0, high = 21
//输出：[0,1,2,3,4,5,6,7,8,9,10,12,21]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= low <= high <= 2 * 10^9 
// 
// Related Topics 广度优先搜索 回溯 
// 👍 25 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Q1215_SteppingNumbers{


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 利用dfs  从 1,2,3,4,5,6,7,8,9 推出 所有的步进数 12 10
        // 然后判断 是否符合 low high范围
        public List<Integer> countQ1215_SteppingNumbers(int low, int high) {
            List<Integer>  ans =  new LinkedList<>();
            Queue<Integer> temp =  new LinkedList<>();

            if(low<=0) ans.add(0);

            for (int i = 1; i <= 9; i++) {
                 temp.add(i);
            }

            while (!temp.isEmpty()) {
                Integer t = temp.poll();
                if(t >=low && t<=high) ans.add(t);
                if(t > high || t >=  Integer.MAX_VALUE/10) continue; // 越界
                int last = t % 10;
                if(last!=0)temp.add(t * 10 +last - 1); // 0 -1
                if(last!=9)temp.add(t * 10 +last + 1); // 9+1
            }


            return ans;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
