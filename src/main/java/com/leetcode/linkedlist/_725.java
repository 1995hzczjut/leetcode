package com.leetcode.linkedlist;


import com.leetcode.dfs.ListNode;

public class _725 {


	// �ж��������ı�׼��val�Ļ��������ַ���
	public ListNode[] splitListToParts(ListNode root, int k) {
		// �㳤��
		int N = 0;
		ListNode cur = root;
		while (cur != null) {
			N++;
			cur = cur.next;
		}
		int n = N / k;
		int rem = N % k;
		// List<List<ListNode>[]> list = new ArrayList<>();
		// ����ͷ�ڵ�����Ϳ�����.�������鲻Ҫ����
		ListNode[] ans = new ListNode[k];

		// 101��3��.ÿ��33�� ����2����������������ǰ�Ѿ�����
		cur = root;
		for (int i = 0; i < k; ++i) {
			// �Խ�ͷ���ĺô�������ͳһѭ����
			ListNode head = new ListNode(0), write = head;
			for (int j = 0; j < n + (i < rem ? 1 : 0); ++j) {
				// ����
				// write.next = cur; Ҫ�Լ��½�
				write.next = new ListNode(cur.val);
				write = write.next;
				cur = cur.next;
			}
			ans[i] = head.next;
		}
		return ans;
	}

	// ����ԭ���������п����⣬�벻���쳣case
	public ListNode[] splitListToParts1(ListNode root, int k) {
		int N = 0;
		ListNode cur = root;
		while (cur != null) {
			N++;
			cur = cur.next;
		}
		int n = N / k;
		int rem = N % k;
		ListNode[] ans = new ListNode[k];
		cur = root;
		for (int i = 0; i < k; ++i) {
			ans[i] = cur;
			for (int j = 0; j < n + (i < rem ? 1 : 0) - 1; ++j) {
				cur = cur.next;
			}
			// ȱ��cur�пա�cur.next ���������Ҫ˼����cur����null��
			// ��һ�����1��2��3��4 ��6�顣ans[5],ans[6]Ҫ����null,����cur���

			if (cur != null) {
				ListNode next = cur.next;
				cur.next = null;
				cur = next;
			}
		}
		return ans;

	}

	public static void main(String[] args) {
		ListNode cur = new ListNode(10);
		ListNode next = cur.next;
		cur.next = null;
		cur = next;
	}

}
