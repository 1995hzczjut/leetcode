package com.jianzhiOffer;

import com.leetcode.dfs.TreeNode;

/**
 * 有问题，看572。
 * 判断树的包含关系，这种包含不一定从根节点开始包含。递归的思路跟以前一样，先看根节点开始能否包含，再看左右子树
 *
 * @author Zhancong Huang
 * @date 12:43 2019/4/20
 */
public class p17 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        //这么写错的，case是1从根节点包含2
        //return isSame(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        return isSubtree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    /**
     * 2是不是 1从根节点开始匹配的子树。第一次root2必定不为空。后续为空说明root2走到底，有部分匹配上了
     */
    private boolean isSubtree(TreeNode root1, TreeNode root2) {
        //2空了，1空不空无所谓
        if (root2 == null) return true;
        //走到这里，说明2不空，1空，1就无法包含2
        if (root1 == null) return false;
        return root1.val == root2.val && isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);
    }


    /**
     * 这是要求两个树完全一致，其实不需要，只要1从头包含2就行
     */
    @Deprecated
    private boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return root1.val == root2.val && isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }
}
