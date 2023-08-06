//  [716]最大栈

//设计一个最大栈数据结构，既支持栈操作，又支持查找栈中最大元素。 
//
// 实现 Q716_MaxStack 类： 
//
// 
// Q716_MaxStack() 初始化栈对象 
// void push(int x) 将元素 x 压入栈中。 
// int pop() 移除栈顶元素并返回这个元素。 
// int top() 返回栈顶元素，无需移除。 
// int peekMax() 检索并返回栈中最大元素，无需移除。 
// int popMax() 检索并返回栈中最大元素，并将其移除。如果有多个最大元素，只要移除 最靠近栈顶 的那个。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["Q716_MaxStack", "push", "push", "push", "top", "popMax", "top", "peekMax", "pop",
// "top"]
//[[], [5], [1], [5], [], [], [], [], [], []]
//输出
//[null, null, null, null, 5, 5, 1, 5, 1, 5]
//
//解释
//Q716_MaxStack stk = new Q716_MaxStack();
//stk.push(5);   // [5] - 5 既是栈顶元素，也是最大元素
//stk.push(1);   // [5, 1] - 栈顶元素是 1，最大元素是 5
//stk.push(5);   // [5, 1, 5] - 5 既是栈顶元素，也是最大元素
//stk.top();     // 返回 5，[5, 1, 5] - 栈没有改变
//stk.popMax();  // 返回 5，[5, 1] - 栈发生改变，栈顶元素不再是最大元素
//stk.top();     // 返回 1，[5, 1] - 栈没有改变
//stk.peekMax(); // 返回 5，[5, 1] - 栈没有改变
//stk.pop();     // 返回 1，[5] - 此操作后，5 既是栈顶元素，也是最大元素
//stk.top();     // 返回 5，[5] - 栈没有改变
// 
//
// 
//
// 提示： 
//
// 
// -107 <= x <= 107 
// 最多调用 104 次 push、pop、top、peekMax 和 popMax 
// 调用 pop、top、peekMax 或 popMax 时，栈中 至少存在一个元素 
// 
//
// 
//
// 进阶： 
//
// 
// 试着设计解决方案：调用 top 方法的时间复杂度为 O(1) ，调用其他方法的时间复杂度为 O(logn) 。 
// 
// Related Topics 栈 设计 链表 双向链表 有序集合 
// 👍 79 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;


public class Q716_MaxStack{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Q716_MaxStack1 {

        Stack<Integer> stack;
        PriorityQueue<Integer> queue;

        /** initialize your data structure here. */
    public Q716_MaxStack1() {
        stack = new Stack<>();
        queue = new PriorityQueue<>( (a,b)->b-a);

    }
    
    public void push(int x) {
        stack.push(x);
        queue.add(x);
    }
    
    public int pop() {
        Integer pop = stack.pop();
        queue.remove(pop);
        return pop;
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return queue.peek();
    }
    
    public int popMax() {
        Integer peek = queue.poll();
        stack.remove(stack.lastIndexOf(peek));
        return peek;
    }
}

/**
 * Your Q716_MaxStack object will be instantiated and called as such:
 * Q716_MaxStack obj = new Q716_MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){


    }
  
}
