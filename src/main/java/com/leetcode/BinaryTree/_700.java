package com.leetcode.BinaryTree;

/**
 * @author Zhancong Huang
 * @date 13:07 2019/7/18
 */
public class _700 {

    /**
     * 题目非常简单，体现出了通用方法。已知两个子树上的结果，怎么拼装出最终的结果
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val)return root;
        return val < root.val ? searchBST(root.left,val) : searchBST(root.right,val);
    }
}
