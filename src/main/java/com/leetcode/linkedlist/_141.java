package com.leetcode.linkedlist;


import com.leetcode.dfs.ListNode;

public class _141 {


    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        do {
            if (fast == null || fast.next == null) {
                return false;
            }
            //д��.next ��Ҫ�п���.slow�����пգ���Ϊ���ܵ�����fastû��NPE��slow�϶�����NPE
            fast = fast.next.next;
            slow = slow.next;
        } while (slow != fast);
        return true;
    }


    public static void main(String[] args) {

    }

}
