package com.leetcode.BinaryTree;

/**
 * 看清题目，度不一定经过root，最简单的例子就是某一边为空，度肯定不会经过root了
 * 所以不能只算经过root的最大深度和，还要算两个子树的，最后取最大的
 *
 * @author Zhancong Huang
 * @date 22:31 2018/12/18
 */
public class _543 {

    /**
     * 关键在于理解diam是root代表的树的所有子树的的经过root的diam的最大值
     * 而经过root的diam很好求，就是左右的最大高度和
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int dia = depth(root.left) + depth(root.right);
        int ldia = diameterOfBinaryTree(root.left);
        int rdia = diameterOfBinaryTree(root.right);
        return Math.max(dia, Math.max(ldia, rdia));

    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
