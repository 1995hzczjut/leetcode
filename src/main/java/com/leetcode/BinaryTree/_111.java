package com.leetcode.BinaryTree;


import com.leetcode.dfs.TreeNode;

/**
 * 有一个子树是空的，返回不空的+1
 *
 * @author Zhancong Huang
 * @date 10:08 2019/7/15
 */
public class _111 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null && root.right != null) return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        else return 1 + Math.max(minDepth(root.left), minDepth(root.right));
    }
}
