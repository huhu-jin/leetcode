package jin.learn;


// 添加一个假的头 然后循环
public class Solution_024 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode swapPairs(ListNode head) {
        ListNode dumy = new ListNode(1);
        dumy.next = head;
        ListNode current = dumy;
        while (current.next != null && current.next.next != null) {
            ListNode firstNode = current.next;
            ListNode secondNode = current.next.next;
            firstNode.next = secondNode.next;
            current.next = secondNode;
            secondNode.next = firstNode;
            current = firstNode;
        }
        return dumy.next;
    }
}
