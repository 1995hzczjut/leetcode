package com.jianzhiOffer;

import com.leetcode.dfs.ListNode;

/**
 * 链表需要prev结点，则一定需要dummy结点
 *
 * @author Zhancong Huang
 * @date 21:50 2019/4/28
 */
public class p56 {

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;

        ListNode dummy = new ListNode(0);
        ListNode cur = pHead, prev = dummy;
        dummy.next = pHead;
        boolean isDuplicated = false;

        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                isDuplicated = true;
                cur = cur.next;
            }
            if (isDuplicated) {
                //中间有重复，此时prev的位置不应该动，仅改变其next
                cur = cur.next;
                prev.next = cur;
            } else {
                //中间无重复，prev cur都往右移动一格
                prev = cur;
                cur = cur.next;
            }
            isDuplicated = false;
        }
        return dummy.next;
    }


}
