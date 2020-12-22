package com.leetcode.BinaryTree;

import com.leetcode.dfs.TreeNode;

/**
 * @author Zhancong Huang
 * @date 10:50 2019/7/15
 */
public class _112 {
    /**
     * 背包问题的回溯做法的简单版本.递归的终止应该是叶子节点，是Null的引发混乱，比如sum=0
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        //叶子节点代表递归的终点
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                return true;
            } else {
                return false;
            }
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
