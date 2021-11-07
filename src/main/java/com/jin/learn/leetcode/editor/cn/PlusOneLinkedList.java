//  [369]给单链表加一

//用一个 非空 单链表来表示一个非负整数，然后将这个整数加一。 
//
// 你可以假设这个整数除了 0 本身，没有任何前导的 0。 
//
// 这个整数的各个数位按照 高位在链表头部、低位在链表尾部 的顺序排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
// 
// Related Topics 链表 数学 
// 👍 74 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.common.ListNode;
import org.testng.annotations.Test;


public class PlusOneLinkedList{
  
  
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
    public ListNode plusOne(ListNode head) {
        int carry = dfs(head);
        if (carry == 1) {
            ListNode temp = new ListNode(1);
            temp.next = head;
            head = temp;
        }
        return head;
    }

    private int dfs(ListNode head) {
        if(head == null) return 1;
        int carry = dfs(head.next);
        int sum = carry + head.val;
        head.val = sum % 10;
        return sum / 10;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        Solution solution = new Solution();
    }
  
}