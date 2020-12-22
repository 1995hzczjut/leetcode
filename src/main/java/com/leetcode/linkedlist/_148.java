package com.leetcode.linkedlist;


import com.leetcode.dfs.ListNode;

/**
 * �����mergeһ��Ҫ����
 *
 * @author Zhancong Huang
 * @date 12:25 2019/6/18
 */
public class _148 {

    /**
     * �鲢�����������е���ô�ң��ҵ���Ҫ�Ͽ����ֳ����룬��ͬ�����飿������ômerge?
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // �г����롣˫ָ�뷨���е�
        ListNode slow = head;
        ListNode fast = head;
		/*
		//�������������顣�ҵ��������鿪ͷ���ǲ����ġ��м仹���������ġ�Ҫ�Ͽ���
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
        //core:һ��Ҫ�Լ��Ͽ��������������⡣slow���ұ�һ�����ʼ
        prev.next = null;
        fast = head;

        //�ݹ鴦����������
        slow = sortList(slow);
        fast = sortList(fast);
        return merge(slow, fast);
    }

    private static ListNode merge(ListNode p1, ListNode p2) {
        //�̶���·���Խ�ͷ�ڵ㣬������ѭ��ָ��cur.ÿ���µĽڵ����cur֮��
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
