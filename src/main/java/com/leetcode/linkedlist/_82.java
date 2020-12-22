package com.leetcode.linkedlist;


import com.leetcode.dfs.ListNode;

public class _82 {


    /**
     * 要把出现重复的全部删掉，只要由重复，就要全部删掉，因此需要前置结点，也就需要dump结点
     */
    public ListNode deleteDuplicates0(ListNode head) {
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode cur = head, prev = dump;
        //代表cur后面是否有节点与其重复，重复要全部干掉
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
