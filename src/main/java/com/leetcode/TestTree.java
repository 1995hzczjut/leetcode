package com.leetcode;

import com.leetcode.dfs.TreeNode;

/**
 * 千万不要格式化！！！
 *
 *            10
 *          /  \
 *         5   -3
 *       / \    \
 *     3   2   11
 *   / \   \
 * 3  -2   1
 *
 * https://leetcode.com/problems/path-sum-iii/
 * @author Zhancong Huang
 * @date 19:44 2019/9/29
 */
public class TestTree {


    public static TreeNode getRoot() {
        TreeNode root = new TreeNode(10);
        TreeNode n11 = new TreeNode(5);
        TreeNode n12 = new TreeNode(-3);
        TreeNode n21 = new TreeNode(3);
        TreeNode n22 = new TreeNode(2);
        TreeNode n23 = new TreeNode(11);
        TreeNode n31 = new TreeNode(3);
        TreeNode n32 = new TreeNode(-2);
        TreeNode n33 = new TreeNode(1);

        root.left = n11;
        root.right = n12;
        n11.left = n21;
        n11.right = n22;
        n12.right = n23;
        n21.left = n31;
        n21.right = n32;
        n22.right = n33;
        return root;
    }
}
