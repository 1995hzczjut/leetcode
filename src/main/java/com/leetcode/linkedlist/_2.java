package com.leetcode.linkedlist;


import com.leetcode.dfs.ListNode;

public class _2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), cur = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            ListNode next = new ListNode(sum % 10);
            cur = cur.next = next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        //忘记遍历完后还有一个进位。例如119 119 最后外面还剩一个1
        if (carry == 1) cur = cur.next = new ListNode(1);
        return dummy.next;
    }
}
