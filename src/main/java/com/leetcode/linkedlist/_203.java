package com.leetcode.linkedlist;


import com.leetcode.dfs.ListNode;

public class _203 {

	/**
	 * ��83һ����curÿ�ι̶�����cur�����һ��ֵ������val.���������һ�����ҲҪ����
	 * ���Կ�������dump��㣬��֤�����࣬�������⴦���һ�������
	 */
	public ListNode removeElements(ListNode head, int val) {
		ListNode dump = new ListNode(0);
		dump.next = head;
		ListNode cur = dump;
		while (cur != null){
			ListNode next = cur.next;
			while (next != null && next.val == val){
				next = next.next;
			}
			cur = cur.next = next;
		}
		return dump.next;
	}

}
