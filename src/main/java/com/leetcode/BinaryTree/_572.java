package com.leetcode.BinaryTree;

/**
 * 错误的写法，不应该isSame(s, t)，如果s包含t从跟节点开始，那么这个Case无法通过
 * 看p17 .lc通的过，剑指就通不过
 *
 * @author Zhancong Huang
 * @date 22:36 2018/12/19
 */
public class _572 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }
}
