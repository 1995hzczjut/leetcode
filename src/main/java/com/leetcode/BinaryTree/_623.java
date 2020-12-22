package com.leetcode.BinaryTree;

/**
 *  BFS思路，一层一层倒出来，算次数。到d了，再处理。BFS一定注意poll前要判空。
 *  DFS也一样的，用先序遍历+depth，水平顺序上是从左到右的，到了对应的层，处理其孩子节点
 *
 * @author Zhancong Huang
 * @date 21:46 2019/1/2
 */
public class _623 {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newroot = new TreeNode(v);
            newroot.left = root;
            return newroot;
        }
        helper(root, v, d, 1);
        return root;
    }

    private void helper(TreeNode root, int v, int d, int curDepth) {
        if (root == null || d < curDepth + 1) {
            return;
        }
        if (d == curDepth + 1) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            TreeNode newLeft = new TreeNode(v);
            TreeNode newLRight = new TreeNode(v);
            root.left = newLeft;
            root.right = newLRight;
            newLeft.left = left;
            newLRight.right = right;
        } else {
            helper(root.left, v, d, curDepth + 1);
            helper(root.right, v, d, curDepth + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode _4 = new TreeNode(4);
        TreeNode _2 = new TreeNode(2);
        TreeNode _6 = new TreeNode(6);
        TreeNode _3 = new TreeNode(3);
        TreeNode _1 = new TreeNode(1);
        TreeNode _5 = new TreeNode(5);
        _4.left = _2;
        _4.right = _6;
        _2.left = _3;
        _2.right = _1;
        _6.left = _5;
        _623 s = new _623();
        s.addOneRow(_4, 1, 2);
    }
}
