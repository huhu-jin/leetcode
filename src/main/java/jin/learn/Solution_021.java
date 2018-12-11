package jin.learn;

// 没通过
public class Solution_021 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ret = null;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while (temp1 != null || temp2 != null) {
            if (temp1 == null && temp2 != null) {
                if (ret == null) {
                    ret = temp2;
                } else {
                    ret.next = temp2;
                }
                temp2 = temp2.next;
            } else if (temp1 != null && temp2 == null) {
                if (ret == null) {
                    ret = temp1;
                } else {
                    ret.next = temp1;
                }
                temp1 = temp1.next;
            } else {
                if (temp1.val <= temp2.val) {
                    if (ret == null) {
                        ret = temp1;
                    } else {
                        ret.next = temp1;
                    }
                }else{
                    if (ret == null) {
                        ret = temp2;
                    } else {
                        ret.next = temp2;
                    }
                }
            }
        }
        return ret;
    }
}