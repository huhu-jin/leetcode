//  [402]移掉 K 位数字

//给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。 
// 
//
// 示例 1 ： 
//
// 
//输入：num = "1432219", k = 3
//输出："1219"
//解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
// 
//
// 示例 2 ： 
//
// 
//输入：num = "10200", k = 1
//输出："200"
//解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
// 
//
// 示例 3 ： 
//
// 
//输入：num = "10", k = 2
//输出："0"
//解释：从原数字移除所有的数字，剩余为空就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= num.length <= 10⁵ 
// num 仅由若干位数字（0 - 9）组成 
// 除了 0 本身之外，num 不含任何前导零 
// 
// Related Topics 栈 贪心 字符串 单调栈 👍 830 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Q402_RemoveKDigits{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 单调递增栈
    // 1 2 3 4 这样是ok的  1 2 3 2 那么3 就要remove
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int remain = num.length() - k;
        for (char digit : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > digit) {
                stack.pop();
                k--; // 标记移除多少
            }
            stack.push(digit);
        }

        // 合并答案
        StringBuilder result = new StringBuilder();
        for (Character digit : stack.subList(0, remain)) {
            result.append(digit);
        }

        String finalResult = result.toString().replaceAll("^0+", ""); // 去除先导的 "0000"
        return finalResult.isEmpty() ? "0" : finalResult;
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().removeKdigits("00001432219", 3);
        new Solution().removeKdigits("9", 1);
        new Solution().removeKdigits("10200", 1);
        new Solution().removeKdigits("10", 1);
    }
  
}
