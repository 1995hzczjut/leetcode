package com.exem.past;

/**
 * @author Zhancong Huang
 * @date 19:21 2019/9/25
 */
public class Kujiale1 {

    static class Node {
        public String value;
        public Node left;
        public Node middle;
        public Node right;
    }

    public void helper(Node root) {
        if (root == null) {
            System.out.println("");
        }
        doHelper(root, root.value);
    }


    public void doHelper(Node root, String prefix) {
        if (root == null) return;
        if (isLeftNode(root)) {
            System.out.println(prefix);
        }
        doHelper(root.left, prefix + root.left.value);
        doHelper(root.right, prefix + root.right.value);
        doHelper(root.middle, prefix + root.middle.value);
    }

    private boolean isLeftNode(Node root) {
        return root != null && root.left == null && root.right == null;
    }


    public static void main(String[] args) {
    }

}
