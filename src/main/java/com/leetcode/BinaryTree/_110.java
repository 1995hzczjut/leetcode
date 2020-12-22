package com.leetcode.BinaryTree;

import com.leetcode.dfs.TreeNode;

/**
 * 后面子树也是要平衡的条件容易漏掉
 *
 * @author Zhancong Huang
 * @date 23:59 2019/7/4
 */
public class _110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        //树是平衡的 <==> 左右子树平衡，且两个子树高度差小于等于1.后面子树也是要平衡的条件容易漏掉
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }


    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
