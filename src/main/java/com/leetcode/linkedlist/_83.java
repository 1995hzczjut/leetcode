package com.leetcode.linkedlist;


import com.leetcode.dfs.ListNode;

public class _83 {

    /**
     * 修改原来的结构。注意判空。
     * 考虑case:11111112
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null ) {
            //固定cur，找cur后面第一个不等于cur值的结点
            next = cur.next;
            while (next != null && next.val == cur.val) {
                next = next.next;
            }
            cur = cur.next = next;
        }
        return head;
    }

    public static void main(String[] args) {

    }

}
