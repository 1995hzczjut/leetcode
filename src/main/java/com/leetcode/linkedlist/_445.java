package com.leetcode.linkedlist;

import com.leetcode.dfs.ListNode;

import java.util.ArrayDeque;


public class _445 {


    /**
     * 要求不能输入reverse，想到栈，其弹出的顺序
     * 例如a=修改a的操作，后面还要使用a的时候要有意识是否要用新的a还是老的a。【重要】
     * 与第一问不同，最后的carry条件合在前面了。（一开始想不到，写出来就有意识了）
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
        //stack==null 不要再出现了！！！ide不提示都不知道错
        ListNode dummy = new ListNode(0);
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry == 1) {
            int num1 = stack1.isEmpty() ? 0 : stack1.pop();
            int num2 = stack2.isEmpty() ? 0 : stack2.pop();
            //错在第一行修改了原carry，第二行却想使用老的carry
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
