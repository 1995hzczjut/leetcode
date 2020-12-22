package com.leetcode.dfs;

public class _100 {


    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q!= null || p != null && q == null)return false;
        if(p == null && q == null)return true;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right,q.right);
    }

    public static void main(String[] args) {

    }
}
