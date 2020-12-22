package com.leetcode.dfs;

public class _109 {
    /**
     * 拿到链表中间结点经常遇到，要很熟练。注意不需要dummy,while条件只需要fast
     * 【大坑】断开左边的链表；如果Prev为空，代表左边的空，要特殊处理
     * 思路：
     * 原先链表有序，肯定不用写成AVL树，不然告诉你有序干嘛。
     * 因此可以找链表中点，递归的去构造。
     * 再次强调：链表是一直连着的，递归的时候左边的不断开，会一直重复。
     * 同时注意左边的为空了，不能再拿Head去递归，否则也要爆栈。
     *
     * 递归一定小心有没有出现同样入参的地方，像这里，都是传head进去递归。
     * 明显不对
     */
    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        //拿到中间结点及其两边.特别注意，左边的部分一定要断开，否则递归肯定爆栈，因为slow左边一直没变
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        //一定要断开，否则下一行就是死循环.check输入的这一步也避免了
        if (prev != null) {
            prev.next = null;
            //漏掉的值，prev=null ，代表slow左边是空的，因为不能再sortedListToBST(head)了。
        }else {
            head = null;
        }
        //之前没注意的问题。head到此为止都没变过，现在又去执行递归方法，入参完全一样，肯定爆栈
        //所以之前有问题，head肯定要有变动。
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
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
        sortedListToBST(l1);
    }
}
