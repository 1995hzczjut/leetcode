package com.leetcode.linkedlist;


import com.leetcode.dfs.ListNode;

/**
 * ע��ӣ�Ҫ��ɾ����һ����㡣��Ϊɾһ�����Ҫ�õ�����prev node.���ֲ���˫����������Ҫdump��㡣
 * �ڶ��ְ취�Ƚ�����
 * todo:�ĳ������
 *    ListNode dummy = new ListNode(0);
 dummy.next = head;
 ListNode fast = head, slow = head, prev = dummy;
 */
public class _19 {


    /**
     * ���ǽ�ͷ��㡣ʲôҪ�У�û�еĻ�����������������headʱҪɾ���ĵ㣬��Ҫ�����ó������ۡ�
     * ����ͷ�ڵ㣬���԰�head��һ���Ĵ�������ͳһ����  һ�㶼�Խ�һ����
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
