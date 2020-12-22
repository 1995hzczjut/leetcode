package com.yuanfudao;

import com.leetcode.dfs.TreeNode;

/**
 * @author Zhancong Huang
 * @date 20:37 2019/11/2
 */
public class 无序数组构建一棵二叉排序树 {


    public TreeNode constructBST(int[] nums) {
        TreeNode root = new TreeNode(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            put(root, nums[i]);
        }
        return root;
    }

    private void put(TreeNode root, int num) {
        TreeNode cur = root;
        while (true) {
            if (cur.val >= num) {
                if (cur.left == null) {
                    cur.left = new TreeNode(num);
                    return;
                }
                cur = cur.left;
            }else {
                if (cur.right == null){
                    cur.right = new TreeNode(num);
                    return;
                }
                cur = cur.right;
            }
        }
    }


}
