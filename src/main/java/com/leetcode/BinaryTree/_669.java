package com.leetcode.BinaryTree;


/**
 * @author Zhancong Huang
 * @date 15:08 2018/12/25
 */
public class _669 {

    /**
     * 明显递归，思考trimBST root的左右子树都OK，并拿到返回值，现在怎么办？
     * 有三个备选新root。
     * 选择方法：root跟L,R比。例如小于L，左边的都要被trim，所以返回trimBST（right）
     * 终止条件就是Null.
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null)
            return null;
        if (root.val < L)
            return trimBST(root.right, L, R);
        if (root.val > R)
            return trimBST(root.left, L, R);
        //子树根节点会变
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        return root;
    }


    /**
     * 很难想到
     * iterative。awesome！！！ 思路是一步一步让树合法化
     * 把while也看成递归；{2 1 3 0 1.6 2。5 4} [1.5,3.5]  2的左边1不满足。怎么处理？；充分利用BST大小关系，非常巧妙
     */
    public TreeNode trimBST1(TreeNode root, int L, int R) {
        if (root == null) return null;
        //把root trim到范围内
        while (root.val < L || root.val > R) {
            if (root.val < L) {
                root = root.right;
            } else if (root.val > R) {
                root = root.left;
            }
        }
        TreeNode cur = root;
        //trim left subtree.
        while (cur != null) {
            while (cur.left != null && cur.left.val < L) {
                //左边直接丢弃.很像AVL
                cur.left = cur.left.right;
            }
            //看成递归处理
            cur = cur.left;
        }
        //
        cur = root;
        while (cur != null) {
            while (cur.right != null && cur.right.val > R) {
                //左边直接丢弃
                cur.right = cur.right.left;
            }
            //看成递归处理
            cur = cur.right;
        }
        return root;
    }
}
