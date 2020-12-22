package com.leetcode.dfs;

import java.util.Stack;

/**
 * 栈的写法太难了，学习递归的
 *
 * @author Zhancong Huang
 * @date 9:33 2019/7/19
 */
public class _114 {
    public static void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        flatten(left);
        flatten(right);

        root.left = null;
        root.right = left;

        //cur不要从right开始找，如果right=null,就出现空指针了
        TreeNode cur = root;
        while (cur.right != null) cur = cur.right;
        cur.right = right;

    }

    //iterative。很难想到
    public static void flatten1(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
            //cur原来的结构的孩子结点已经被保存了，因此这里可以断开原来的关系了
            //cur.right = stack.peek();    peek点进去看下，空了也会抛异常
            if (!stack.isEmpty()) cur.right = stack.peek();
            cur.left = null;
        }


    }

    public static void main(String[] args) {

    }
}
