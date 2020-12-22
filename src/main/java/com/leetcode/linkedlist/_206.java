package com.leetcode.linkedlist;

import com.leetcode.dfs.ListNode;

public class _206 {

	public ListNode reverseList1(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode cur = head, next = cur.next;
		cur.next = null;
		//while条件不需要判断cur,next足够了
		while (next != null){
			ListNode next0 = next.next;
			next.next = cur;
			cur = next;
			next = next0;
		}
		return cur;
	}

	/**
	 * 递归，返回是反转后的头
	 */
	public ListNode reverseList(ListNode head) {
		//递归终止条件
		if (head == null || head.next == null) return head;
		//这句不能放在下面，因为它把head.next.next置为Null.放在下面head.next.next = head无效了
		ListNode head_next = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return head_next;
	}


}
