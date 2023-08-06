//  [86]分隔链表

//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
// Related Topics 链表 双指针 
// 👍 395 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.common.ListNode;
import org.testng.annotations.Test;


public class Q86_PartitionList{
  
  
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
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;

        ListNode dummy = new ListNode(-1);
        ListNode newLine = new ListNode(-1);
        ListNode newLineCur = newLine;
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;
        for (; cur != null; ) {
            if (cur.val >= x) {
                pre.next = cur.next;
                newLineCur.next = cur;
                cur.next = null;
                cur = pre.next;
                newLineCur = newLineCur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        pre.next = newLine.next;
        return dummy.next;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
                ListNode dummy1 = new ListNode(1);
        ListNode dummy4 = new ListNode(4);

                ListNode dummy3 = new ListNode(3);
        ListNode dummy2 = new ListNode(2);
        ListNode dummy5 = new ListNode(5);
        ListNode dummy22 = new ListNode(2);
        dummy1.next = dummy4;
        dummy4.next = dummy3;
        dummy3.next = dummy2;
        dummy2.next = dummy5;
        dummy5.next = dummy22;
        new Q86_PartitionList.Solution().partition(dummy1, 3);
    }
  
}
