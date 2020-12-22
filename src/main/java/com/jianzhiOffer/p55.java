package com.jianzhiOffer;

import com.leetcode.dfs.ListNode;

/**
 * @author Zhancong Huang
 * @date 21:05 2019/4/28
 */
public class p55 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;

        ListNode slow = pHead, fast = pHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                //有环
                fast = pHead;
                while (fast != slow) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        //跳出上面循环，代表无环
        return null;
    }
}
