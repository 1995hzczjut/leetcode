package com.leetcode.dfs;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * 判断一棵树是不是BST，还是用中徐验证是否递增靠谱
 *
 * @author Zhancong Huang
 * @date 21:06 2019/7/18
 */
public class _98 {

    /**
     * 这种思路很难想到，最开始的做法仅仅看左中右节点的大小，这么做的错误case，左子树的右边大于总的root
     * 正确的做法是根据先序遍历校验每个节点的大小，套路还是每次递归看root。
     */
    public static boolean isValidBST1(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean dfs(TreeNode root, long minValue, long maxValue) {
        if (root == null) return true;
        if (minValue >= root.val || maxValue <= root.val) return false;
        return dfs(root.left, minValue, root.val) && dfs(root.right, root.val, maxValue);
    }

    /**
     * 递归判断最佳方法应该是中虚遍历+全局变量prev
     */
    public static boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        Integer prev = null;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (prev != null && cur.val < prev) return false;
                prev = cur.val;
                cur = cur.right;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
