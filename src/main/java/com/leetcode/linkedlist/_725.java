package com.leetcode.linkedlist;


import com.leetcode.dfs.ListNode;

public class _725 {


	// 判断两个结点的标准是val的话，用这种方法
	public ListNode[] splitListToParts(ListNode root, int k) {
		// 算长度
		int N = 0;
		ListNode cur = root;
		while (cur != null) {
			N++;
			cur = cur.next;
		}
		int n = N / k;
		int rem = N % k;
		// List<List<ListNode>[]> list = new ArrayList<>();
		// 返回头节点数组就可以了.对象数组不要忘了
		ListNode[] ans = new ListNode[k];

		// 101分3堆.每堆33个 还多2个。把这两个分在前堆就行了
		cur = root;
		for (int i = 0; i < k; ++i) {
			// 自建头结点的好处，就是统一循环。
			ListNode head = new ListNode(0), write = head;
			for (int j = 0; j < n + (i < rem ? 1 : 0); ++j) {
				// 创建
				// write.next = cur; 要自己新建
				write.next = new ListNode(cur.val);
				write = write.next;
				cur = cur.next;
			}
			ans[i] = head.next;
		}
		return ans;
	}

	// 操作原链表。还是判空问题，想不到异常case
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
			// 缺少cur判空。cur.next 出现这个就要思考，cur会是null吗？
			// 有一种情况1，2，3，4 分6组。ans[5],ans[6]要求是null,所以cur会空

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
