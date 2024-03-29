//  [155]最小栈

//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["Q155_MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//Q155_MinStack minStack = new Q155_MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 
// 👍 962 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.LinkedList;



  
  
    //leetcode submit region begin(Prohibit modification and deletion)
public class Q155_MinStack {
        // 同   BaoHanMinhanShuDeZhanLcof

        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<Integer> minQueue = new LinkedList<>();


        /**
         * initialize your data structure here.
         */
        public Q155_MinStack() {

        }

        public void push(int val) {
            queue.push(val);
            if (minQueue.isEmpty() || getMin() >= val) {
                minQueue.push(val);
            }
        }

        public void pop() {
            if (queue.pop().equals(minQueue.peekFirst())) {
                minQueue.pop();
            }
        }

        public int top() {
            return queue.peekFirst();
        }

        public int getMin() {
            return minQueue.peekFirst();

        }

    }
/**
 * Your Q155_MinStack object will be instantiated and called as such:
 * Q155_MinStack obj = new Q155_MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

