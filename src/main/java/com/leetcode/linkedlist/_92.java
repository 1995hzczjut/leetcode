package com.leetcode.linkedlist;


import com.leetcode.dfs.ListNode;

public class _92 {

    public static ListNode reverseBetween0(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode tail = head;
        ListNode next = head.next;

        for (int i = 1; i < m; i++) {
            pre = tail;
            tail = next;
            next = next.next;
        }

        for (; m < n; m++) {
            tail.next = next.next;
            next.next = pre.next;
            pre.next = next;
            next = tail.next;
        }

        return dummy.next;
    }


}
