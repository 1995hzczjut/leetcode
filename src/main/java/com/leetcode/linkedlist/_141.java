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
            //写下.next 就要判空了.slow不必判空，因为它跑的慢，fast没有NPE，slow肯定不会NPE
            fast = fast.next.next;
            slow = slow.next;
        } while (slow != fast);
        return true;
    }


    public static void main(String[] args) {

    }

}
