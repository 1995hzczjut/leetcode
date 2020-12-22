package com.leetcode.linkedlist;

import com.leetcode.dfs.ListNode;
import com.leetcode.sort.SortUtil;

/**
 * 一般的数组插入排序 从后往前插，但是这里不是双链表，没法这么做。
 * 只能从前往后找。注意的是例如 123 0，0会插在1前面，所以需要dummy节点。
 * 每次插入的时候 从p=dummy找，且只能比较p.next 和 待插入的值
 * 还是因为不是双链表。
 *
 * @see SortUtil
 * @author Zhancong Huang
 * @date 9:54 2019/4/10
 */
public class _147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        //代表新的结点
        ListNode dummy = new ListNode(0);
        //总的指针
        ListNode cur = head;
        while (cur != null) {
            //cur插在p和p.next中间
            ListNode p = dummy, next = cur.next;
            //找p
            while (p.next != null && p.next.val < cur.val) {
                //p肯定不为空，不需要判断
                p = p.next;
            }
            //插入
            cur.next = p.next;
            p.next = cur;
            cur = next;
        }
        return dummy.next;
    }
}
