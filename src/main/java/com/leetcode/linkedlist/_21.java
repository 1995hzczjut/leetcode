package com.leetcode.linkedlist;


import com.leetcode.dfs.ListNode;

/**
 * 链表问题的第一题。经验：
 * （1）dummy结点很重要，能保持代码的整洁，但不是必须。返回dummy.next
 * （2）原则上一定不能破坏输入链表的结构。除非题目有明确意思让你修改原来的结构。例如83
 * （3）一旦写出X.next 就要思考X有没有判空
 * （3）输入为空和单节点一定要单独考虑（以前是故意不写），！！！ 143出现单节点引发的死循环
 */
public class _21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //类似merge建新数组存放结果，这里对应建立头节点，数组里用
        //下标指定带插入位置，这里用个指针cur
        ListNode dumumy = new ListNode(-1);
        ListNode cur = dumumy, p = l1, q = l2;
        while (q != null && p != null) {
            if (p.val <= q.val) {
                cur = cur.next = p;
                //这种地方一直忘记加，导致死循环
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
