//  [面试题 02.01]移除重复节点

//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。 
//
// 示例1: 
//
// 
// 输入：[1, 2, 3, 3, 2, 1]
// 输出：[1, 2, 3]
// 
//
// 示例2: 
//
// 
// 输入：[1, 1, 1, 1, 2]
// 输出：[1, 2]
// 
//
// 提示： 
//
// 
// 链表长度在[0, 20000]范围内。 
// 链表元素在[0, 20000]范围内。 
// 
//
// 进阶： 
//
// 如果不得使用临时缓冲区，该怎么解决？ 
// Related Topics 链表 
// 👍 103 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.leetcode.editor.cn.common.ListNode;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;


public class RemoveDuplicateNodeLcci{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    private Set<Integer> memo = new HashSet<>();

    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode temp = head;
        if (temp == null) return null;
        memo.add(temp.val);
        while (temp.next != null) {
            if (memo.contains(temp.next.val)) {
                temp.next = temp.next.next;
            }else {
                memo.add(temp.next.val);
                temp = temp.next;
            }
        }

        return head;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}