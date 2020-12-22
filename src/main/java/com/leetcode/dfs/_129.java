package com.leetcode.dfs;

import java.util.Stack;

/**
 * 掌握递归做法
 *
 * @author Zhancong Huang
 * @date 12:12 2019/7/19
 */
public class _129 {

    /**
     * 类似path-sum 2
     */
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int sum) {
        if (root == null) return 0;
        if (root.left == null || root.right == null) return sum + root.val;
        return helper(root.left, sum * 10 + root.val) + helper(root.right, sum * 10 + root.val);
    }


    /**
     * 比较有技巧性的非递归，利用先序栈遍历的特点，直接改节点数据，在叶节点累加
     */
    public int sumNumbers2(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        stack.push(cur);
        int sum = 0;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            //放入栈的时候做下处理
            if (cur.right != null) {
                cur.right.val = cur.val * 10 + cur.right.val;
                stack.push(cur.right);
            }
            if (cur.left != null) {
                cur.left.val = cur.val * 10 + cur.left.val;
                stack.push(cur.left);
            }
            //检查是否到了叶节点。这里不用判空，cur必定不为空
            if (cur.left == null && cur.right == null) {
                sum += cur.val;
            }
        }
        return sum;
    }

}
