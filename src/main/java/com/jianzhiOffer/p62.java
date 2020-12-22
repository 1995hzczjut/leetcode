package com.jianzhiOffer;

import com.leetcode.dfs.TreeNode;

import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * @author Zhancong Huang
 * @date 20:12 2019/4/30
 */
public class p62 {

    /**
     * @param k K乱给的，可能大于所有节点的数量
     */
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (k < 0) return null;

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = pRoot;

        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (--k == 0) return cur;
                cur = cur.right;
            }
        }
        return null;
    }
}
