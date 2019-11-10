package jin.learn;

/**
 * 普通逻辑,细节上处理
 */
public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode ret = new ListNode(0);
        ListNode temp = ret;

        while (true) {
            if (l1 != null) {
                sum +=l1.val;
                l1 = l1.next;
            }
            if (l2 != null ){
                sum += l2.val ;
                l2 = l2.next;
            }

            temp.val = sum % 10;
            sum = sum / 10;
            if (l1 == null && l2 == null) {
                if (sum != 0) {
                    temp.next = new ListNode(sum);
                }
                break;
            }
           temp.next = new ListNode(sum);
           temp = temp.next;
        }

        return ret;
    }
}
