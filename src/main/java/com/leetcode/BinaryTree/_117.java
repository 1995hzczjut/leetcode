package com.leetcode.BinaryTree;

/**
 * @author Zhancong Huang
 * @date 10:37 2019/7/19
 */
public class _117 {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * 难再不是满二叉树，每一层又很多空洞。基本思路一样，考虑怎么切换层，需要记录每一行第一个非空的值。
     * 处理层的一个节点怎么找他的下一个节点，不可能一直遍历上一层的，那样效率太低，所以需要用prev变量记录下来。
     */
    public Node connect(Node root) {
        if (root == null) return null;
        Node start = root;
        while (start != null){
            //同样处理的是cur的下一层
            Node cur = start;
            Node prev = null;
            //防止start在最后一层变成死循环
            start = null;
            while (cur != null){
                //由于此时cur不知道有没有子节点，需要判断
                if (cur.left != null){
                    //按照设定需要修改prev指针：prev.next = cur.left
                    //这里遇到NPE，prev=null又特殊含义的,代表这是当前层的第一个节点，保存下来，下次遍历用
                    if (prev == null){
                        start = cur.left;
                    }else {
                        prev.next = cur.left;
                    }
                    prev = cur.left;
                }
                if (cur.right != null){
                    if (prev == null){
                        start = cur.right;
                    }else {
                        prev.next = cur.right;
                    }
                    prev = cur.right;
                }
                cur = cur.next;
            }
        }
        return root;
    }
}
