package com.leetcode.BinaryTree;

import com.leetcode.dfs.TreeNode;

/**
 * @author Zhancong Huang
 * @date 23:32 2018/12/18
 */
public class _563 {
    public int findTilt(com.leetcode.dfs.TreeNode root) {
        int[] result = helper(root);
        return result[1];
    }

    /**
     * @return {sum, tilt}
     */
    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] leftResult = helper(root.left);
        int[] rightResult = helper(root.right);
        int sum = leftResult[0] + rightResult[0] + root.val;
        int tilt = leftResult[1] + rightResult[1] + Math.abs(leftResult[0] - rightResult[0]);
        return new int[]{sum, tilt};
    }

}
