package com.leetcode.linkedlist;

import com.leetcode.dfs.ListNode;

import java.util.ArrayDeque;


public class _445 {


    /**
     * Ҫ��������reverse���뵽ջ���䵯����˳��
     * ����a=�޸�a�Ĳ��������滹Ҫʹ��a��ʱ��Ҫ����ʶ�Ƿ�Ҫ���µ�a�����ϵ�a������Ҫ��
     * ���һ�ʲ�ͬ������carry��������ǰ���ˡ���һ��ʼ�벻����д����������ʶ�ˣ�
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayDeque<Integer> stack1 = new ArrayDeque<>();
        ArrayDeque<Integer> stack2 = new ArrayDeque<>();
        ListNode cur = l1;
        while (cur != null) {
            stack1.push(cur.val);
            cur = cur.next;
        }
        cur = l2;
        while (cur != null) {
            stack2.push(cur.val);
            cur = cur.next;
        }
        //stack==null ��Ҫ�ٳ����ˣ�����ide����ʾ����֪����
        ListNode dummy = new ListNode(0);
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry == 1) {
            int num1 = stack1.isEmpty() ? 0 : stack1.pop();
            int num2 = stack2.isEmpty() ? 0 : stack2.pop();
            //���ڵ�һ���޸���ԭcarry���ڶ���ȴ��ʹ���ϵ�carry
//            carry = (num1 + num2 + carry) / 10;
//            ListNode sum = new ListNode((num1 + num2 + carry) % 10);
            int n = (num1 + num2 + carry) % 10;
            carry = (num1 + num2 + carry) / 10;
            ListNode sum = new ListNode(n);
            sum.next = dummy.next;
            dummy.next = sum;
        }
        return dummy.next;
    }

}
