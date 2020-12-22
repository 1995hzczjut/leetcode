package com.leetcode.linkedlist;


import com.leetcode.dfs.ListNode;

public class _24 {


	/**
	 * 要避免环，必须引入cur的前置结点，链表第一个结点没有前置结点的，因此必须建立dump结点
	 * 指针设置参考链表反转，外面设置cur,next.里面在设置next0
	 * 循环的每一步，类似反转，都是处理Cur后面的指针。难在各个指针变化和NPE处理
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
	 * 递归版本跟反转一样
	 * @param head
	 * @return
	 */
	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode next = head.next;
		//下面两句的顺序也是有讲究的，换一下就是stackoverflow
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
