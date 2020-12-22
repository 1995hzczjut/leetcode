package com.leetcode.linkedlist;


import com.leetcode.dfs.ListNode;

/**
 * 注意坑，要求删除第一个结点。因为删一个结点要拿到它的prev node.这又不是双链表，所以需要dump结点。
 * 第二种办法比较巧妙
 * todo:改成下面的
 *    ListNode dummy = new ListNode(0);
 dummy.next = head;
 ListNode fast = head, slow = head, prev = dummy;
 */
public class _19 {


    /**
     * 忘记建头结点。什么要有？没有的话，像这种情况，如果head时要删除的点，就要单独拿出来讨论。
     * 有了头节点，可以把head当一样的处理，便于统一处理。  一般都自建一个。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        int i = 0;
        while ((i++) <= n) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }


}
