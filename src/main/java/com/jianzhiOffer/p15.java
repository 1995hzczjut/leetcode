package com.jianzhiOffer;

import com.leetcode.dfs.ListNode;

/**
 * 链表问题，空节点跟单节点单独处理
 *
 * @author Zhancong Huang
 * @date 0:35 2019/4/20
 */
public class p15 {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode ReverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head, next = cur.next;
        cur.next = null;
        while (next != null){
            //牢记每次循环体的作用是把next的next指针指向cur,cur自己的Next已经指向正确的未知。所以while之前的初始化状态第一个节点的next必须为空
            ListNode next0 = next.next;
            next.next = cur;
            cur = next;
            next = next0;
        }
        return cur;
    }
}
