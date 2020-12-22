package com.leetcode.linkedlist;


import com.leetcode.dfs.ListNode;

public class _328 {
	/**
	 * 错在第一个while循环时把原来的结构打破了。类似于并发问题。
	 * 这种两个串行操作都依赖原来的结构一定要小心
	 */
	public static ListNode oddEvenList_false(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode even_head = head.next;
		ListNode odd_cur = head;
		ListNode even_cur = even_head;
		while (odd_cur != null && odd_cur.next != null) {
			odd_cur = odd_cur.next = odd_cur.next.next;
		}
		while (even_cur != null && even_cur.next != null) {
			even_cur = even_cur.next = even_cur.next.next;
		}
		if (odd_cur == null) {
			odd_cur = even_head;
		} else {
			odd_cur.next = even_head;
		}
		return head;
	}

	/**
	 * 正确，要同时修改
	 */
	public static ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode evenHead = head.next, curOdd = head, curEven = evenHead;
		//判断条件由NPE得到
		while (curEven != null && curEven.next != null){
			curOdd = curOdd.next = curOdd.next.next;
			curEven = curEven.next = curEven.next.next;
		}
		curOdd.next = evenHead;
		return head;
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
		oddEvenList(l1);

	}

}
