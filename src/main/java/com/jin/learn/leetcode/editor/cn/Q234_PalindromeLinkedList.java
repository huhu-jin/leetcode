//  [234]回文链表

//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 970 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.common.ListNode;
import org.testng.annotations.Test;


public class Q234_PalindromeLinkedList {


    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    // 快指针走到末尾，慢指针刚好到中间。其中慢指针将前半部分反转。然后比较。
    class Solution {


//        public boolean isPalindrome(ListNode head) {
//           if(head == null) return false;
//           if(head.next == null) return true;
//           if(head.next.next == null) return head.val == head.next.val;
//
//           ListNode middle = findMiddle(head);
//           middle = reverse(middle);
//
//            while (middle != null) {
//                if (middle.val != head.val) {
//                    return false;
//                }
//                middle = middle.next;
//                head = head.next;
//            }
//            return true;
//        }

        private ListNode reverse(ListNode middle) {
            ListNode dummy = new ListNode(0);
            dummy.next = middle;
            ListNode p = middle;
            ListNode m;
            while (true) {
                m = p.next;
                if(m == null) break;
                p.next = m.next;
                m.next = dummy.next;
                dummy.next = m;
            }
            return dummy.next;
        }

        private ListNode findMiddle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (true) {
                if (fast.next == null || fast.next.next == null) {
                    break;
                }
                fast = fast.next.next;
                slow = slow.next;
            }

            return fast.next == null ? slow : slow.next;
        }

 ///////////////////


    private ListNode frontPointer;

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            // 递
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }

            // 归
            // 比较头和尾
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            //头替换
            frontPointer = frontPointer.next;
            //
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }



    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void testCase() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        new Q234_PalindromeLinkedList.Solution().isPalindrome(listNode1);
    }

}
