package com.jianzhiOffer;

import com.leetcode.dfs.TreeNode;

/**
 * BFS:层遍历
 *
 * @author Zhancong Huang
 * @date 15:44 2019/4/22
 */
public class p38 {
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }
}
