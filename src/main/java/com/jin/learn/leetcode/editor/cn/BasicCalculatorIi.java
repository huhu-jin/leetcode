
//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
// 
// 
// Related Topics 栈 字符串 
// 👍 330 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.Assert;
import org.testng.annotations.Test;


public class BasicCalculatorIi{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        public class Node {

            private int priority;

            private Node pre;

            private Node next;

            private char operate;

            private int value;

            public Node(char op, int value, int priority) {
                this.operate = op;
                this.value = value;
                this.priority = priority;

            }

        }

        public int calculate(String s) {
            int ret = 0;
            if (s == null || "".equals(s)) {
                return ret;
            }
            Node header = parseExpress(s.replaceAll(" ", ""));
            Node n = header;
            while (n != null) {
                if (n.priority == 1) {
                    Node left = n.pre;
                    Node right = n.next;
                    int temp;
                    if (left == null) {
                        temp = doNode(n, 0);
                        if (right == null) {
                            return temp;
                        } else {
                            Node newOne = new Node('+', temp, 0);
                            header = newOne;
                            newOne.next = right;
                            right.pre = newOne;

                        }
                    } else {
                        temp = doNode(n, left.value);
                        Node newOne = new Node(left.operate, temp, 0);
                        if (right != null) {
                            newOne.next = right;
                            right.pre = newOne;
                        }
                        if (left.pre == null) {
                            header = newOne;
                        }else{
                            left.pre.next = newOne;
                            newOne.pre = left.pre;
                        }
                    }

                }
                 n = n.next;
            }
            Node m = header;
            while (m != null) {
                ret = doNode(m, ret);
                m = m.next;
            }
            return ret;
        }

        private int doNode(Node n, int ret) {
            if (n == null) return 0;
            switch (n.operate) {
                case '+':
                    ret += n.value;
                    break;
                case '-':
                    ret -= n.value;
                    break;
                case '*':
                    ret *= n.value;
                    break;
                case '/':
                    ret /= n.value;
                    break;
            }
            return ret;
        }

        private Node parseExpress(String s) {
            Node h = null;
            Node tempNode = null;
            String temp = "";
            char op = '+';
            int priority = 0;
            for (int i = 0; i < s.length(); i++) {
                Node newNode = null;
                if ('+' == s.charAt(i) || '-' == s.charAt(i)) {
                    int value = temp == "" ? 0 : Integer.valueOf(temp);
                    newNode = new Node(op, value, priority);
                    priority = 0;
                    op = s.charAt(i);
                    temp = "";
                } else if ('*' == s.charAt(i) || '/' == s.charAt(i)) {
                    int value = temp == "" ? 0 : Integer.valueOf(temp);
                    newNode = new Node(op, value, priority);
                    priority = 1;
                    op = s.charAt(i);
                    temp = "";
                } else {
                    temp = temp + s.charAt(i);
                }
                if (newNode != null) {
                    if (h == null) {
                        h = newNode;
                        tempNode = h;
                    } else {
                        tempNode.next = newNode;
                        newNode.pre = tempNode;
                        tempNode = tempNode.next;
                    }
                }
            }

            if (temp.length() > 0) {
                int value = Integer.valueOf(temp);
                Node newNode = new Node(op, value, priority);
                if (h == null) {
                    return newNode;
                } else {
                    tempNode.next = newNode;
                    newNode.pre = tempNode;

                }
            }
            return h;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        Assert.assertEquals(new Solution().calculate("3+5 / 2"), 5);
        Assert.assertEquals(new Solution().calculate("3/2 "), 1);
        Assert.assertEquals(new Solution().calculate("13+12*2"), 37);
    }
  
}