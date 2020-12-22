package com.leetcode.BinaryTree;

import java.util.*;

/**
 * @author Zhancong Huang
 * @date 13:35 2018/12/14
 */
public class _538 {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        return helper(root);
    }

    /**
     * 递归反而男鞋，helper功能 调整root树，并把全局变量变为root树的总和
     */
    public TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        helper(root.right);
        sum += root.val;
        root.val = sum;
        helper(root.left);
        return root;
    }

    public TreeNode convertBST1(TreeNode root) {
        int sum = 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.right;
            } else {
                cur = stack.pop();
                sum += cur.val;
                cur.val = sum;
                cur = cur.left;
            }
        }
        return root;
    }
}
