
//实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
// s 表示一个有效的表达式 
// 
// Related Topics 栈 数学 
// 👍 457 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.Assert;
import org.testng.annotations.Test;


public class BasicCalculator{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public class Node{
        String val;
        int p;

        public Node(String val){
            this.val = val;
        }

    }

    public int calculate(String s) {
        if (s == null || s.equals("") || "".equals(s.replaceAll(" ", ""))) {
            return 0;
        }
        s = s.replaceAll(" ", "");
        return calculate(new Node(s));


    }

        public int calculate(Node node) {
            int current = 0;
            String temp = "";
            boolean lastOperatorIsAdd = true;
            for (; node.p < node.val.length(); ) {
                if ('(' == node.val.charAt(node.p)) {
                    node.p++;
                    temp = String.valueOf(calculate(node));
                } else if (')' == node.val.charAt(node.p)) {
                    node.p++;
                    if (lastOperatorIsAdd) {
                        current += Integer.parseInt(temp);
                    } else {
                        current -= Integer.parseInt(temp);
                    }
                    return current;
                } else if ('+' == (node.val.charAt(node.p))) {
                    if (lastOperatorIsAdd) {
                        current += temp.equals("")?0:Integer.parseInt(temp);
                    } else {
                        current -= temp.equals("")?0:Integer.parseInt(temp);
                    }
                    temp = "";
                    lastOperatorIsAdd = true;
                    node.p++;
                } else if ('-' == node.val.charAt(node.p)) {
                    if (lastOperatorIsAdd) {
                        current += temp.equals("")?0:Integer.parseInt(temp);
                    } else {
                        current -= temp.equals("")?0:Integer.parseInt(temp);
                    }
                    lastOperatorIsAdd = false;
                    temp = "";
                    node.p++;
                } else {
                    temp = temp + node.val.charAt(node.p);
                    node.p++;
                }
            }
            if (temp.length() > 0) {
                if (lastOperatorIsAdd) {
                    current += Integer.parseInt(temp);
                } else {
                    current -= Integer.parseInt(temp);
                }
            }
            return current;
        }



    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){

        Assert.assertEquals(new Solution().calculate("1+2"),3);
        Assert.assertEquals(new Solution().calculate("(1+(4+5+2)-3)+(6+8)"),23);
        Assert.assertEquals(new Solution().calculate("11+2"),13);
        Assert.assertEquals(new Solution().calculate("11+12"),23);

    }
  
}