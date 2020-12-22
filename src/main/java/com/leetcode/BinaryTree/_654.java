package com.leetcode.BinaryTree;

/**
 * @author Zhancong Huang
 * @date 15:11 2019/7/20
 */
public class _654 {
    /**
     * 类似根据数组构建BST，递归的过程很像.
     * for (int i = start; i <= end; i++) 还是会写错
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) return null;
        int maxIdx = -1, maxValue = Integer.MIN_VALUE;
        //for (int i = 0; i < nums.length; i++) {
        for (int i = start; i <= end; i++) {
            if (nums[i] > maxValue) {
                maxIdx = i;
                maxValue = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxValue);
        root.left = helper(nums, maxIdx + 1, end);
        root.left = helper(nums, start, maxIdx - 1);
        return root;
    }

}
