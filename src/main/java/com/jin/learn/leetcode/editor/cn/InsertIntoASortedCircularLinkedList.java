//  [708]循环有序列表的插入

//给定循环升序列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal ，使这个列表仍然是循环升序的。 
//
// 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。 
//
// 如果有多个满足条件的插入位置，你可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。 
//
// 如果列表为空（给定的节点是 null），你需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。 
//
// 
//
// 示例 1： 
// 
// 
// 
//输入：head = [3,4,1], insertVal = 2
//输出：[3,4,1,2]
//解释：在上图中，有一个包含三个元素的循环有序列表，你获得值为 3 的节点的指针，我们需要向表中插入元素 2 。新插入的节点应该在 1 和 3 之间，插入之后
//，整个列表如上图所示，最后返回节点 3 。
//
//
// 
//
// 示例 2： 
//
// 
//输入：head = [], insertVal = 1
//输出：[1]
//解释：列表为空（给定的节点是 null），创建一个循环有序列表并返回这个节点。
// 
//
// 示例 3： 
//
// 
//输入：head = [1], insertVal = 0
//输出：[1,0]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= Number of Nodes <= 5 * 10^4 
// -10^6 <= Node.val <= 10^6 
// -10^6 <= insertVal <= 10^6 
// 
// Related Topics 链表 
// 👍 45 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.common.Node;
import org.testng.annotations.Test;


public class InsertIntoASortedCircularLinkedList{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        // 1. 空链表
        if (null == head) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        Node current = head;
        while (current.next != head) {
            // 2. 正常情况：当前节点小于等于插入值，下个节点大于插入值
            if (current.val <= insertVal && insertVal < current.next.val) break; // 主要是不会有 空指针
            // 最小值和最大值之间
            if (current.next.val < current.val) {
                // 3. 大于链表中的最大值
                if (insertVal >= current.val) break;
                // 4. 小于链表中的最小值
                if (insertVal <= current.next.val) break;
            }
            current = current.next;
        }
        // 5. 正常结束链表中的所有的值一样大
        Node newNode = new Node(insertVal);
        newNode.next = current.next;
        current.next = newNode;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}