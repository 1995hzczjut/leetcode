package com.jianzhiOffer;

import com.leetcode.dfs.TreeNode;

/**
 * 镜像旋转树
 *
 * @author Zhancong Huang
 * @date 14:37 2019/4/20
 */
public class p18 {
    public void Mirror(TreeNode root) {
        helper(root);
    }

    public TreeNode helper(TreeNode root){
        if (root == null) return null;
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
