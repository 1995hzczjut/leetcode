package com.leetcode.linkedlist;


import com.leetcode.dfs.ListNode;

public class _82 {


    /**
     * Ҫ�ѳ����ظ���ȫ��ɾ����ֻҪ���ظ�����Ҫȫ��ɾ���������Ҫǰ�ý�㣬Ҳ����Ҫdump���
     */
    public ListNode deleteDuplicates0(ListNode head) {
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode cur = head, prev = dump;
        //����cur�����Ƿ��нڵ������ظ����ظ�Ҫȫ���ɵ�
        boolean isDuplicated = false;
        while (cur != null) {
            ListNode next = cur.next;
            while (next != null && next.val == cur.val) {
                next = next.next;
                isDuplicated = true;
            }
            if (isDuplicated) {
                isDuplicated = false;
                prev.next = cur = next;
            } else {
                prev = cur;
                cur = next;
            }
        }
        return dump.next;
    }


}
