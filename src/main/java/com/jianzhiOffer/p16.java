package com.jianzhiOffer;

import com.leetcode.dfs.ListNode;

/**
 * @author Zhancong Huang
 * @date 0:39 2019/4/20
 */
public class p16 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy, p = list1, q = list2;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                //可以cur = cur.next = p 看题意能不能改原链表
                cur = cur.next = new ListNode(p.val);
                p = p.next;
            } else {
                cur = cur.next = new ListNode(q.val);
                q = q.next;
            }

        }
        if (p == null) {
            cur.next = new ListNode(q.val);
        } else {
            cur.next = new ListNode(p.val);
        }
        return dummy.next;
    }
}
