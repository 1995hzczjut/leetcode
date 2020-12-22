package com.leetcode.linkedlist;


import com.leetcode.dfs.ListNode;

/**
 * ���������Bug,
 */
public class _143 {

    /**
     * ��ĿҪ���ƶ�ԭ��������ʾ�����ö���ռ�
     * ����ӡ�������Դ��ϰ�߲��ã�û��check���롣��������������Ǹ������
     * ����ַǳ��������ѭ�������۸���������
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        //�������е�
        ListNode fast = head, slow = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //��֮ǰ����������������һ����ע��Ͽ�prev
        if (prev != null) prev.next = null;
        slow = reverse(slow);
        ListNode dummy = new ListNode(0), cur = dummy;
        while (head != null || slow != null) {
            if (head != null) {
                cur = cur.next = head;
                //.next д�¾�Ҫע��NPE
                head = head.next;
            }
            if (slow != null) {
                cur = cur.next = slow;
                slow = slow.next;
            }
        }
        head = dummy.next;
    }

    /**
     * �ݹ鷴ת���ǲ���Ϥ����ס�ȷ�תHead.next����ת�������ʲô��ԭ��������ʲô�仯�������
     * Ȼ��ı�Head,��head��next
     * ͬ��ע��check���ڵ�����
     * if (node == null || node.next == null) return node; ���ڷ���null.
     */
    public ListNode reverse(ListNode node) {
        if (node == null) return null;
        //���ú��ָ���ϵ�ǳ���Ҫ
        ListNode result = reverse(node.next);
        //Node���ڵ���������NPE
        if (node.next != null) {
            node.next.next = node;
            node.next = null;
            return result;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode cur = l1;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

}
