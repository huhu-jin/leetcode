//  [25]K 个一组翻转链表

//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 进阶： 
//
// 
// 你可以设计一个只使用常数额外空间的算法来解决此问题吗？ 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2,3,4,5], k = 1
//输出：[1,2,3,4,5]
// 
//
// 示例 4： 
//
// 
//输入：head = [1], k = 1
//输出：[1]
// 
//
// 
// 
//
// 提示： 
//
// 
// 列表中节点的数量在范围 sz 内 
// 1 <= sz <= 5000 
// 0 <= Node.val <= 1000 
// 1 <= k <= sz 
// 
// Related Topics 链表 
// 👍 1090 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.common.ListNode;
import org.testng.annotations.Test;


public class Q25_ReverseNodesInKGroup{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// 本质还是链表的翻转
// 多一步翻转前的分组

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k<=0) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode groupDummy = dummy;
        while (true) {
            for (int i = 0; i < k; i++) {
                if(head == null)
                    return dummy.next;
                head = head.next;
            }
            groupDummy = reverse(groupDummy, k);
        }
    }


    /**
     *
     * @param g g 前面节点
     * @param k
     * @return p 翻转完最后一个节点
     */
    private ListNode reverse(ListNode g, int k) {
        ListNode p = g.next;
        for (int i = 1; i < k; i++) {
           ListNode m = p.next;
           p.next = m.next;
           m.next = g.next;
           g.next = m;
        }
        return p;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2= new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        new Q25_ReverseNodesInKGroup.Solution().reverseKGroup(listNode1, 2);
    }
  
}
