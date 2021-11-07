package com.jin.learn.template;

import com.jin.learn.common.ListNode;

public class NodeReverse {

    public ListNode reverse(ListNode node) {
        ListNode g = new ListNode(-1);
        g.next = node;
        ListNode p = node;
        while (true) {
            ListNode m = p.next;
            if(m == null) break;
            p.next = m.next;
            m.next = g.next;
            g.next = m;
        }
        return g.next;
    }
}
