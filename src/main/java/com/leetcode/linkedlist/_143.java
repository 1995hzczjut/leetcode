package com.leetcode.linkedlist;


import com.leetcode.dfs.ListNode;

/**
 * 遇到神奇的Bug,
 */
public class _143 {

    /**
     * 题目要求移动原链表，即暗示不能用额外空间
     * 【大坑】问题来源于习惯不好，没有check输入。此题中如果输入是个单结点
     * 会出现非常诡异的死循环，肉眼根本看不出
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        //找链表中点
        ListNode fast = head, slow = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //跟之前回文链表，链表排序一样。注意断开prev
        if (prev != null) prev.next = null;
        slow = reverse(slow);
        ListNode dummy = new ListNode(0), cur = dummy;
        while (head != null || slow != null) {
            if (head != null) {
                cur = cur.next = head;
                //.next 写下就要注意NPE
                head = head.next;
            }
            if (slow != null) {
                cur = cur.next = slow;
                slow = slow.next;
            }
        }
        head = dummy.next;
    }

    /**
     * 递归反转还是不熟悉，记住先反转Head.next，反转后输出是什么，原来的输入什么变化必须清楚
     * 然后改变Head,和head。next
     * 同样注意check单节点输入
     * if (node == null || node.next == null) return node; 错在返回null.
     */
    public ListNode reverse(ListNode node) {
        if (node == null) return null;
        //调用后的指针关系非常重要
        ListNode result = reverse(node.next);
        //Node单节点这里会出现NPE
        if (node.next != null) {
            node.next.next = node;
            node.next = null;
            return result;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode cur = l1;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

}
