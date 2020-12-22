package com.leetcode.BinaryTree;

/**
 * 一开始没注意题目说是BST。
 * p < root < q 没得选,root 就是最小祖先
 * root 在p q另一侧。继续找。
 * 唯一疑问：root 4  p 2  q 4 . 有没有可能2 挂在 4 的左下角，这样返回不是root 。当然没可能，没有这样的结构。想清楚代码很简单了
 * 总共就三种情况了
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/discuss/64954/My-Java-Solution
 *
 * @author Zhancong Huang
 * @date 19:06 2018/12/11
 */
public class _235 {

    //递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    //迭代
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        //有点别扭
        while(root != null){
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
       return root;
    }
}
