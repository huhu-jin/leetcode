//  [82]删除排序链表中的重复元素 II

//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序排列 
// 
// Related Topics 链表 
// 👍 540 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.common.ListNode;
import org.testng.annotations.Test;


public class Q82_RemoveDuplicatesFromSortedListIi{
  
  
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre =dummyNode;
        ListNode cur = pre.next;
        ListNode next = cur.next;
        boolean isSame=false;
        while (next != null) {
            if (cur.val == next.val) {
                isSame =true;
                next = next.next;
            } else {
                if (isSame) {
                    pre.next =next;
                    cur = next;
                    next = cur.next;
                    isSame =false;
                }else{
                    ListNode temp = next.next;
                    pre =cur;
                    cur =next;
                    next = temp;
                }
            }
        }
        if (isSame) {
            pre.next = next;
        }

        return dummyNode.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
