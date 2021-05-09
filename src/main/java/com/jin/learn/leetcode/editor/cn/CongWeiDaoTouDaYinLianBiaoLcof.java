//  [剑指 Offer 06]从尾到头打印链表

//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 142 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.leetcode.editor.cn.common.ListNode;
import org.testng.annotations.Test;

import java.util.LinkedList;


public class CongWeiDaoTouDaYinLianBiaoLcof {


    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int[] reversePrint(ListNode head) {
            LinkedList<Integer> integers = new LinkedList<>();
            while (head != null) {
                integers.addFirst(head.val);
                head = head.next;

            }
            int[] ret = new int[integers.size()];
            int count = 0;
            for (Integer i : integers) {
                ret[count++] = i;
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void testCase() {

    }

}