package com.jianzhiOffer;

import com.leetcode.dfs.ListNode;

/**
 * 记住思路：两个指针先同时指向头部，然后一起走，空的转到另一个头。
 * 如果不存在公共起点，最后会同时为空，存在的话会指向同一点，此时可以跳出。
 * 再次强调：链表的题目写下cur.next就要想到NPE
 *
 * @author Zhancong Huang
 * @date 15:08 2019/4/22
 */
public class p36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode cur1 = pHead1, cur2 = pHead2;
        while (cur1 != null || cur2 != null) {
            //这个判断只能加在这里，加在最后，对于一开始两个节点就像等的情况会多走很多次
            if (cur1 == cur2) return cur1;
            cur1 = cur1 == null ? pHead2 : cur1.next;
            cur2 = cur2 == null ? pHead1 : cur2.next;
        }
        return null;
    }
}
