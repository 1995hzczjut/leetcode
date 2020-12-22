package com.leetcode.linkedlist;

import com.leetcode.dfs.ListNode;

public class _206 {

	public ListNode reverseList1(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode cur = head, next = cur.next;
		cur.next = null;
		//while��������Ҫ�ж�cur,next�㹻��
		while (next != null){
			ListNode next0 = next.next;
			next.next = cur;
			cur = next;
			next = next0;
		}
		return cur;
	}

	/**
	 * �ݹ飬�����Ƿ�ת���ͷ
	 */
	public ListNode reverseList(ListNode head) {
		//�ݹ���ֹ����
		if (head == null || head.next == null) return head;
		//��䲻�ܷ������棬��Ϊ����head.next.next��ΪNull.��������head.next.next = head��Ч��
		ListNode head_next = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return head_next;
	}


}
