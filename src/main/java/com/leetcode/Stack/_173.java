package com.leetcode.Stack;

import com.leetcode.dfs.TreeNode;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @author Zhancong Huang
 * @date 22:07 2019/3/15
 */
public class _173 {

    static class BSTIterator {

        TreeNode cur;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();

        public BSTIterator(TreeNode root) {
            cur = root;
        }

        /**
         * 每次调用next前，cur代表新的一棵树，返回当前cur代表树的最左边的节点。然后cur回到下一此调用时代表的树的根节点
         * 7/19: pop出来的就是要的返回，再次之前必须while加入左边的节点
         *
         * @return the next smallest number
         */
        public int next() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode res = stack.pop();
            cur = res.right;
            return res.val;
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.isEmpty() || cur != null;
        }
    }

}
