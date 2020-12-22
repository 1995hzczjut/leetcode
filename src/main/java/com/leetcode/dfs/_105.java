package com.leetcode.dfs;

/**
 * 数组递归的基本模板： helper(int[]. start, end)
 * 然后方法第一行就要写 if(start > end ) return null;
 *
 * @author Zhancong Huang
 * @date 10:54 2019/8/12
 */
public class _105 {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, 0, preorder.length - 1, 0, preorder.length - 1);
    }

    public static TreeNode dfs(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight ) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int index = 0;
        //这里最好建立数组的 索引-值的 map
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == root.val) index = i;
        }
        root.left = dfs(preorder, inorder, preLeft + 1, preLeft + index - inLeft, inLeft, index - 1);
        root.right = dfs(preorder, inorder, preRight + index - inRight + 1, preRight, index + 1, inRight);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {};
        int[] inorder = {};
        buildTree(preorder, inorder);
    }
}
