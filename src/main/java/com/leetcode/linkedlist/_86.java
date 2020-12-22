package com.leetcode.linkedlist;


import com.leetcode.dfs.ListNode;

public class _86 {

	/**
	 * ���ǲ��������ɵ�������ֻ��������2->1  2����ֻ�
	 * 143252 ���ڵ���3���Ǹ������������5.Ȼ���ڲ�������next����Ȼ�����ã��������˻�
	 */
	public ListNode partition(ListNode head, int x) {
		//�Խ�����ͷ�ڵ㡣һ������С�ڵģ���һ��������ڵ��ڡ����ƴ����
		//�����뵽��ʱ�Ѵ��ڵ��ڵ�������next��Ϊnull������������ֻ���TLE
		if(head==null)return head;
		ListNode dummy1 = new ListNode(0);
		ListNode dummy2 = new ListNode(0);
		ListNode cur1 = dummy1;
		ListNode cur2 = dummy2;
		ListNode cur = head;
		//ֱ�Ӳ���ԭ����
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
