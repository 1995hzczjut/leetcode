package com.leetcode.linkedlist;

import com.leetcode.dfs.ListNode;

/**
 * @author Zhancong Huang
 * @date 16:58 2019/4/5
 */
public class _234 {
    private ListNode ref;

    /**
     * helper(){
     *     code1;
     *     helper();
     *     code2;
     * }
     * 递归函数如上，code1,code2在栈帧种的顺序是相反的。code2是栈帧中最上面的先执行
     * 因此可以设立全局变量ref，起始指向head，在code2代码中让ref右移。
     * 这样第一次执行的栈帧中，code2代码执行时，ref指向末尾
     * code2细节，等ref起始位置都要仔细考量的。
     */
    public boolean isPalindrome(ListNode head) {
        ref = head;
        return helper(head);
    }

    public boolean helper(ListNode node) {
        //终止条件
        if (node == null) return true;
        boolean ans = helper(node.next);
        //这两句顺序也有讲究。思考最上面那个stackFrame,ref此时是第一个结点
        //如果两句换一下位置。那就乱了
        boolean isEqual = ref.val == node.val;
        ref = ref.next;
        return ans && isEqual;
    }


    public boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) return true;
        //找到中点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = head;
        slow = reverse(slow);

        while (slow != null && fast != null) {
            if (slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode result = reverse(head.next);
        head.next.next = head;
        //这一行忘记写了
        head.next = null;
        return result;
    }

    private ListNode reverse1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head, next = cur.next;
        //下面每次循环让cur后面的节点的next指针指向cur，cur自己的next已经指向正确的地方了
        cur.next = null;
        while (next != null) {
            ListNode next0 = next.next;
            next.next = cur;
            cur = next;
            next = next0;
        }
        return cur;
    }
}
