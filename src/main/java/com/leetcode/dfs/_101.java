package com.leetcode.dfs;

/**
 * @author Zhancong Huang
 * @date 22:25 2019/7/4
 */
public class _101 {


    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && helper(p.left, q.right) && helper(p.right, q.left);
    }
}
