package com.jianzhiOffer;

import com.leetcode.dfs.TreeNode;

/**
 * 前序结果子数是根据长度确定的.出现类似之前mergesort的错误，每次递归时候数组起始写成0，其实是preleft
 * 递归终止条件,就是传单个值的时候。
 *
 * @author Zhancong Huang
 * @date 20:23 2019/4/16
 */
public class p4 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return helper(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public TreeNode helper(int[] pre, int preLeft, int preRight, int[] in, int inLeft, int inRight) {
        if (preLeft > preRight) return null;
        TreeNode root = new TreeNode(pre[preLeft]);
        int rootIdx = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (in[i] == pre[preLeft]) {
                rootIdx = i;
                break;
            }
        }
        root.left = helper(pre, preLeft + 1, preLeft + rootIdx - inLeft, in, inLeft, rootIdx - 1);
        root.right = helper(pre, preLeft + rootIdx - inLeft + 1, preRight, in, rootIdx + 1, inRight);
        return root;
    }
}
