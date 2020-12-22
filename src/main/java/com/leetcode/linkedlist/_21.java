package com.leetcode.linkedlist;


import com.leetcode.dfs.ListNode;

/**
 * ��������ĵ�һ�⡣���飺
 * ��1��dummy������Ҫ���ܱ��ִ�������࣬�����Ǳ��롣����dummy.next
 * ��2��ԭ����һ�������ƻ���������Ľṹ��������Ŀ����ȷ��˼�����޸�ԭ���Ľṹ������83
 * ��3��һ��д��X.next ��Ҫ˼��X��û���п�
 * ��3������Ϊ�պ͵��ڵ�һ��Ҫ�������ǣ���ǰ�ǹ��ⲻд���������� 143���ֵ��ڵ���������ѭ��
 */
public class _21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //����merge���������Ž���������Ӧ����ͷ�ڵ㣬��������
        //�±�ָ��������λ�ã������ø�ָ��cur
        ListNode dumumy = new ListNode(-1);
        ListNode cur = dumumy, p = l1, q = l2;
        while (q != null && p != null) {
            if (p.val <= q.val) {
                cur = cur.next = p;
                //���ֵط�һֱ���Ǽӣ�������ѭ��
                p = p.next;
            } else {
                cur = cur.next = q;
                q = q.next;
            }
        }
        if (p == null) cur.next = q;
        else cur.next = p;
        return dumumy.next;
    }

}
