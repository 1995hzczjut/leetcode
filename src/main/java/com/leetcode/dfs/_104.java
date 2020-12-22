package com.leetcode.dfs;



public class _104 {



    public static int maxDepth(TreeNode root) {
        if(root == null)return  0;
        //return Math.max(maxDepth(root.left), maxDepth(root.right));
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }




    public static void main(String[] args) {

    }
}
