package com.leetcode.linkedlist;


import com.leetcode.dfs.ListNode;

public class _86 {

	/**
	 * 考虑不到最后组成的链表出现环的情况。2->1  2会出现环
	 * 143252 大于等于3的那个队列最后结点是5.然后不在操作。其next域依然有引用，最后产生了环
	 */
	public ListNode partition(ListNode head, int x) {
		//自建两个头节点。一个代表小于的，另一个代表大于等于。最后拼起来
		//最难想到的时把大于等于的最后个的next变为null，避免链表出现环，TLE
		if(head==null)return head;
		ListNode dummy1 = new ListNode(0);
		ListNode dummy2 = new ListNode(0);
		ListNode cur1 = dummy1;
		ListNode cur2 = dummy2;
		ListNode cur = head;
		//直接操作原链表
		while(cur!=null){
			if(cur.val<x){
				cur1 = cur1.next = cur;
			}else{
				cur2 = cur2.next = cur;
			}
			
			cur = cur.next;
		}
		cur1.next = dummy2.next;
		cur2.next = null;
		return dummy1.next;
	}
	
	public static void main(String[] args) {

	}

}
