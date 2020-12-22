package com.leetcode.BinaryTree;

import java.util.Iterator;
import java.util.Stack;

/**
 * 重要
 *
 * @author Zhancong Huang
 * @date 11:52 2018/11/8
 */
public class _230 {

    static class MyIterator implements Iterator<TreeNode> {
        private Stack<TreeNode> stack;
        private TreeNode cur;

        public MyIterator(TreeNode root) {
            this.stack = new Stack<>();
            this.cur = root;
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty() || cur != null;
        }

        @Override
        public TreeNode next() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //代表前一个cur的左子树不存在。把根节点即由栈保存的前一个cur弹出
            TreeNode result = stack.pop();
            //cur指向前一个cur的右子树，开始新的遍历
            cur = result.right;
            return result;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        Iterator<TreeNode> itr = new MyIterator(root);
        while (itr.hasNext() && --k > 0) {
            itr.next();
        }
        return itr.next().val;
    }

    public static void main(String[] args) {

    }
}
