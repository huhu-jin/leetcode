//  [61]旋转链表

//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 109 
// 
// Related Topics 链表 双指针 
// 👍 489 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.leetcode.editor.cn.common.ListNode;
import org.testng.annotations.Test;


public class RotateList{
  
  
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next ==null || k==0) return head;
        ListNode temp=head;
        int length =1;
        // 变成一个循环 并且计算长度.
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }
        temp.next = head;


        ListNode pre = temp;
        ListNode cur = head;

        int move = length - k%length; // 得到移动的步数(关键是这里.如何得到一定步数!!!)

        while (move > 0) {
            pre =cur;
            cur =cur.next;
            move--;
        }
        pre.next=null;
        return cur;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}