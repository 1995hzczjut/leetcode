package com.leetcode.linkedlist;


import com.leetcode.dfs.ListNode;

public class _24 {


	/**
	 * Ҫ���⻷����������cur��ǰ�ý�㣬�����һ�����û��ǰ�ý��ģ���˱��뽨��dump���
	 * ָ�����òο�����ת����������cur,next.����������next0
	 * ѭ����ÿһ�������Ʒ�ת�����Ǵ���Cur�����ָ�롣���ڸ���ָ��仯��NPE����
	 */
	public ListNode swapPairs1(ListNode head) {
		if (head == null) return null;
		ListNode dump = new ListNode(0);
		dump.next = head;
		ListNode prev = dump, cur = head, next = cur.next;
		while (next != null){
			ListNode next0 = next.next;
			next.next = cur;
			cur.next = next0;
			prev.next = next;
			prev = cur;
			cur = next0;
			if (next0 == null) break;
			next = next0.next;
		}
		return dump.next;

	}

	/**
	 * �ݹ�汾����תһ��
	 * @param head
	 * @return
	 */
	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode next = head.next;
		//���������˳��Ҳ���н����ģ���һ�¾���stackoverflow
		head.next = swapPairs(next.next);
		next.next = head;
		return next;
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
		ListNode head = swapPairs(l1),cur = head;
		while(cur!=null){
			System.out.println(cur.val);
			cur=cur.next;
		}
		
	}

}
