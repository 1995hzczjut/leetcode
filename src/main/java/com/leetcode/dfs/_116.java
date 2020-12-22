package com.leetcode.dfs;

class TreeLinkNode{
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

/**
 * 7/19 题目更新了。递归的做法算然不和要求，还是学到东西的。迭代的方法一定要会。
 *
 * @author Zhancong Huang
 * @date 9:42 2019/7/19
 */
public class _116 {

    /**
     * 递归，效率比较低，题目规定不能使用
     */
    public void connect(TreeLinkNode root) {
        if(root == null)return;
        if(root.left != null) {
            root.left.next = root.right;
            if(root.next != null) {
                //类似先序，所以root自己的next已经调整过了
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    public Node connect1(Node root) {
        if (root == null) return null;
        Node start = root;
        while (start.left != null) {
            //处理的是start的下一行
            Node cur = start;
            while (cur != null) {
                cur.left.next = cur.right;
                //cur.next不判断会出现NPE问题
                cur.right.next = cur.next == null ? null : cur.next.left;
                cur = cur.next;
            }
            start = start.left;
        }
        return root;
    }
    public static void main(String[] args) {

    }
}
