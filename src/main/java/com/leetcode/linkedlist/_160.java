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
     * 上面的代码很长，但是给出了基本做法。两个指针分别跑，最后一轮两个指针到末尾的距离一样
     * 但是直观来看就明显有冗余
     * 类似mergerSort的改进办法。while&&-if-if 变为while||-三元运算符
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
