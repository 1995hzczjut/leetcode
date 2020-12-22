package com.leetcode.BinaryTree;

/**
 *
 * @author Zhancong Huang
 * @date 15:10 2018/12/29
 */
public class _450 {


    public TreeNode deleteNode(TreeNode root, int key){
        if (root == null) return null;
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }else if (root.val > key){
            root.left = deleteNode(root.left, key);
        }else {
            if (root.left == null && root.right == null){
                return null;
            }
            if (root.left == null || root.right == null){
                return root.left == null ? root.right : root.left;
            }
            //
            TreeNode cur = root.right;
            while (cur.left != null){
                cur = cur.left;
            }
            root.val = cur.val;
            root.right = deleteNode(root.right, cur.val);
        }
        return root;
    }
}
