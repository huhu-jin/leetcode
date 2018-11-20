package jin.learn;

//Reverse Linked List
// 添加一个多的节点 一个一个累积上去
public class Solution_206 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode reverseList(ListNode head) {
    ListNode newHead = null;
    while (head != null) {
        ListNode next = head.next;
        head.next = newHead;
        newHead = head;
        head = next;
    }
    return newHead;
}
}
