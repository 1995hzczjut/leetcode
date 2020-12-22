package com.leetcode.dfs;

/**
 * @author Zhancong Huang
 * @date 23:45 2019/7/4
 */
public class _108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return doSortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode doSortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = doSortedArrayToBST(nums, start, mid - 1);
        root.right = doSortedArrayToBST(nums, mid + 1, end);
        return root;
    }
}
