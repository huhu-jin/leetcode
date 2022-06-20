//  [739]每日温度

//请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 105 
// 30 <= temperatures[i] <= 100 
// 
// Related Topics 栈 数组 单调栈 
// 👍 832 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;


public class DailyTemperatures{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // 单调递减栈 (从栈底到栈顶元素对应的 递减)
        // | 1 |
        // | 2 |
        // | 3 |


        // https://leetcode-cn.com/problems/daily-temperatures/solution/leetcode-tu-jie-739mei-ri-wen-du-by-misterbooo/
        //  v < 栈顶 -> (index 索引)入栈
        //  v >= 栈顶 -> 出栈
        public int[] dailyTemperatures(int[] temperatures) {
            int[] ans = new int[temperatures.length]; // 定长的ans
            Deque<Integer> stack = new LinkedList<>(); //  从栈底到栈顶 对应的温度列表中的温度依次递减
            for (int i = 0; i < temperatures.length; i++) {
                int temperature = temperatures[i];
                // 弹出小于的栈 并计算差值
                while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                    int prevIndex = stack.pop();
                    ans[prevIndex] = i - prevIndex; // 当前位置- 以前的
                }
                stack.push(i); // 入栈是 index
            }
            return ans;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        int[] source = new int[10];
        Deque<Integer> stack = new LinkedList<>();


    }
  
}