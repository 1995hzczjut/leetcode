package com.leetcode.BinaryTree;

/**
 * 基本套路，递归，处理根节点，后面的直接递归调用获取结果。
 *
 * @author Zhancong Huang
 * @date 23:27 2018/12/24
 */
public class _617 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        TreeNode newRoot = new TreeNode(t1.val + t2.val);
        newRoot.left = mergeTrees(t1.left, t2.left);
        newRoot.right = mergeTrees(t1.right, t2.right);

        return newRoot;
    }

}
