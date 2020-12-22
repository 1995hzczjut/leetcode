package com.leetcode.linkedlist;


import com.leetcode.dfs.ListNode;

public class _203 {

	/**
	 * 跟83一样。cur每次固定，找cur后面第一个值不等于val.由于这里第一个结点也要考虑
	 * 所以可以利用dump结点，保证代码简洁，不用特殊处理第一个结点了
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
