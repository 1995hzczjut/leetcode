package com.jianzhiOffer;

import com.leetcode.dfs.ListNode;

/**
 * corner case: k == 0 和 k大于链表长度
 *
 * @author Zhancong Huang
 * @date 0:28 2019/4/20
 */
public class p14 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0) return null;
        ListNode slow = head, fast = head;
        for (int i = 1; i < k ; i++) {
            fast = fast.next;
            //k太大了
            if (fast == null) return null;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
