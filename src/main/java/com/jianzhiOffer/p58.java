package com.jianzhiOffer;

import com.leetcode.dfs.TreeNode;

/**
 * 对称数 = 两个子树互为镜像
 *
 * @author Zhancong Huang
 * @date 19:06 2019/4/29
 */
public class p58 {

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        return helper(pRoot.left, pRoot.right);
    }

    /**
     * 判断两棵树是不是互为镜像
     */
    private boolean helper(TreeNode left, TreeNode right){
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left);
    }

}
