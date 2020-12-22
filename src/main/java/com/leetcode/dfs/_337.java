package com.leetcode.dfs;

/**
 * 精妙之处在于一次递归的返回值，返回两个，分别代表[打劫当前结点的最大利益， 不打劫当前结点的最大利益]
 *
 * @author Zhancong Huang
 * @date 22:07 2019/3/15
 */
public class _337 {

    public int rob(TreeNode root) {
        int[] res = doRob(root);
        return Math.max(res[0], res[1]);
    }

    /**
     * top-down
     *
     * @return [打劫当前结点的最大利益， 不打劫当前结点的最大利益]
     */
    private int[] doRob(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = doRob(root.left);
        int[] right = doRob(root.right);
        int[] result = new int[2];
        //当前节点打劫，两个子节点不能打劫，记得加上root自己的值
        result[0] = root.val + left[1] + right[1];
        //当前节点不打劫，孩子节点不一定打劫！！！第一次错在这里
        result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return result;
    }

}
