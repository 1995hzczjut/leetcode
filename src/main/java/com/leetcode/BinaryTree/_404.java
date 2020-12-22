package com.leetcode.BinaryTree;

import com.leetcode.dfs.TreeNode;

/**
 * @author Zhancong Huang
 * @date 19:51 2018/12/11
 */
public class _404 {
    /**
     * sumOfLeftLeavesd的作用是累计root代表的树的左叶子节点。
     * 终止情况：root是叶子节点，但这样左肯定不行，因为不知道是左还是右叶子节点。所以终止在它的父节点
     */
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null) return 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            //防止左边是叶子节点的情况，不写这一步会返回0.也是递归终止条件。
            sum += root.left.val;
        }
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }
}
