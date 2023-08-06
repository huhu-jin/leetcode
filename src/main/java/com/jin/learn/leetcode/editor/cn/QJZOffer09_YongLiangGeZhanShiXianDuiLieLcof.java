//  [剑指 Offer 09]用两个栈实现队列

//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
//功能。(若队列中没有元素，deleteHead 操作返回 -1 ) 
//
// 
//
// 示例 1： 
//
// 输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]
// 
//
// 示例 2： 
//
// 输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
// 
//
// 提示： 
//
// 
// 1 <= values <= 10000 
// 最多会对 appendTail、deleteHead 进行 10000 次调用 
// 
// Related Topics 栈 设计 
// 👍 241 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Stack;


public class QJZOffer09_YongLiangGeZhanShiXianDuiLieLcof{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class CQueue {

        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();

    public CQueue() {

    }
    
    public void appendTail(int value) {
        stack1.add(value);
    }
    
    public int deleteHead() {
        if (stack2.empty() && stack1.empty()) {
            return -1;
        }
        if(stack2.empty() && !stack1.empty()){
            dump(stack1, stack2);
        }
       return stack2.pop();
    }

    private void dump(Stack<Integer> stack1, Stack<Integer> stack2) {
            for (; !stack1.empty(); ) {
                stack2.add(stack1.pop());
            }
        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        CQueue cQueue = new CQueue();
        cQueue.appendTail(2);
        int i = cQueue.deleteHead();
        System.out.println(i);
    }
  
}
