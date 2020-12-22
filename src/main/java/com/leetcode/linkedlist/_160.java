package com.leetcode.linkedlist;


public class _160 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    /**
     * ����Ĵ���ܳ������Ǹ����˻�������������ָ��ֱ��ܣ����һ������ָ�뵽ĩβ�ľ���һ��
     * ����ֱ������������������
     * ����mergerSort�ĸĽ��취��while&&-if-if ��Ϊwhile||-��Ԫ�����
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode curA = headA , curB = headB;

        while (curA != null || curB != null) {
            if (curA == curB) return curA;
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return null;
    }


}
