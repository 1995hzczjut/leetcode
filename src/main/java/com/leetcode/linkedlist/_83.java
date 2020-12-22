package com.leetcode.linkedlist;


import com.leetcode.dfs.ListNode;

public class _83 {

    /**
     * �޸�ԭ���Ľṹ��ע���пա�
     * ����case:11111112
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null ) {
            //�̶�cur����cur�����һ��������curֵ�Ľ��
            next = cur.next;
            while (next != null && next.val == cur.val) {
                next = next.next;
            }
            cur = cur.next = next;
        }
        return head;
    }

    public static void main(String[] args) {

    }

}
