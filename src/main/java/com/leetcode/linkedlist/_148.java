package com.leetcode.linkedlist;


import com.leetcode.dfs.ListNode;

/**
 * 链表的merge一定要熟练
 *
 * @author Zhancong Huang
 * @date 12:25 2019/6/18
 */
public class _148 {

    /**
     * 归并排序。链表找中点怎么找？找到后要断开，分成两半，不同与数组？链表怎么merge?
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // 切成两半。双指针法找中点
        ListNode slow = head;
        ListNode fast = head;
		/*
		//错在链表不是数组。找到两个数组开头，是不够的。中间还是连起来的。要断开。
		while (fast!= null && fast.next  != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		fast = head;
		*/
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //core:一定要自己断开，不是数组问题。slow是右边一般的起始
        prev.next = null;
        fast = head;

        //递归处理两个链表
        slow = sortList(slow);
        fast = sortList(fast);
        return merge(slow, fast);
    }

    private static ListNode merge(ListNode p1, ListNode p2) {
        //固定套路，自建头节点，在设立循环指针cur.每次新的节点插在cur之后
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        if (p1 != null) {
            cur.next = p1;
        }
        if (p2 != null) {
            cur.next = p2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(6);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(10);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode head = sortList(l1), cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

}
