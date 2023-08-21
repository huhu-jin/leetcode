//  [2130]链表最大孪生和

//在一个大小为 n 且 n 为 偶数 的链表中，对于 0 <= i <= (n / 2) - 1 的 i ，第 i 个节点（下标从 0 开始）的孪生节点为第 
//(n-1-i) 个节点 。 
//
// 
// 比方说，n = 4 那么节点 0 是节点 3 的孪生节点，节点 1 是节点 2 的孪生节点。这是长度为 n = 4 的链表中所有的孪生节点。 
// 
//
// 孪生和 定义为一个节点和它孪生节点两者值之和。 
//
// 给你一个长度为偶数的链表的头节点 head ，请你返回链表的 最大孪生和 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [5,4,2,1]
//输出：6
//解释：
//节点 0 和节点 1 分别是节点 3 和 2 的孪生节点。孪生和都为 6 。
//链表中没有其他孪生节点。
//所以，链表的最大孪生和是 6 。
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [4,2,2,3]
//输出：7
//解释：
//链表中的孪生节点为：
//- 节点 0 是节点 3 的孪生节点，孪生和为 4 + 3 = 7 。
//- 节点 1 是节点 2 的孪生节点，孪生和为 2 + 2 = 4 。
//所以，最大孪生和为 max(7, 4) = 7 。
// 
//
// 示例 3： 
//
// 
//
// 输入：head = [1,100000]
//输出：100001
//解释：
//链表中只有一对孪生节点，孪生和为 1 + 100000 = 100001 。
// 
//
// 
//
// 提示： 
//
// 
// 链表的节点数目是 [2, 10⁵] 中的 偶数 。 
// 1 <= Node.val <= 10⁵ 
// 
//
// Related Topics 栈 链表 双指针 👍 41 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.common.ListNode;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;


public class Q2130_MaximumTwinSumOfALinkedList{
  
  
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
    // 快慢双指针, 反转后半链
    // 然后相加
    public int pairSum(ListNode head) {
        int ans =0;
        ListNode pre = new ListNode();
        pre.next  = head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            pre = slow; // 记录前置节点
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = reverse(pre.next);

        ListNode m = head;
        ListNode n = pre.next;

        while (n != null) {
            ans = Math.max(m.val + n.val, ans);
            m = m.next;
            n = n.next;
        }



        return ans;
    }

    public ListNode reverse(ListNode root) {
        ListNode dummy = new ListNode();
        dummy.next  = root;
        ListNode p  = root;

        while (true) {
            ListNode m = p.next;
            if (m == null) break;
            p.next = m.next;
            m.next = dummy.next;
            dummy.next = m;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        new Solution().pairSum(node1);

    }
  
}