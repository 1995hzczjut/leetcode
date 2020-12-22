package com.leetcode.BinaryTree;

import com.leetcode.dfs.TreeNode;

/**
 * @author Zhancong Huang
 * @date 18:27 2018/12/11
 */
public class _226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left, right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}
