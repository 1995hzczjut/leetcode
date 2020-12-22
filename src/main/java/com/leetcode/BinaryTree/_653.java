package com.leetcode.BinaryTree;

import com.leetcode.dfs.TreeNode;

import java.util.ArrayDeque;

/**
 * 关键，中序的栈遍历。牢记pop的顺序就是有序数组的顺序，pop前一定有一个循环push。
 * 注意push的是弹出来的右边，不是弹出来的自己
 *
 * @author Zhancong Huang
 * @date 12:13 2018/12/25
 */
public class _653 {

    /**
     * 之前inorder的时候看到，pop的顺序就是整个有序数组的顺序。每次pop前一定经过把左边一路入栈，cur指向null的过程
     * 写法跟之前标准的遍历代码有差距
     * 所以参照2sum sorted的思路,每次比较的时候看peek的值的和与k的关系，决定谁pop
     */
    public boolean findTarget(com.leetcode.dfs.TreeNode root, int k) {
        if (root == null) return false;

        ArrayDeque<com.leetcode.dfs.TreeNode> smallStack = new ArrayDeque<>();
        ArrayDeque<com.leetcode.dfs.TreeNode> bigStack = new ArrayDeque<>();

        //pop、peek前一定左、右边一路已经入栈
        pushLeftPath(root, smallStack);
        pushRightPath(root, bigStack);

        //pop看成指针移动，移动前要用数组下标找数字，对应peek操作
        while (!smallStack.isEmpty() && !bigStack.isEmpty() && smallStack.peek() != bigStack.peek()) {
            int tmpSum = smallStack.peek().val + bigStack.peek().val;
            if (tmpSum == k) {
                return true;
            }
            //下次peek前，一定要把cur左或右边那一路加进去
            if (tmpSum < k) {
                //弹出的是刚刚peek的，要把它的右边的左边加进去
                //pushLeftPath(smallStack.pop(), smallStack);
                pushLeftPath(smallStack.pop().right, smallStack);
            } else {
                pushRightPath(bigStack.pop().left, bigStack);
            }
        }
        return false;
    }


    private void pushLeftPath(com.leetcode.dfs.TreeNode root, ArrayDeque<com.leetcode.dfs.TreeNode> stack) {
        com.leetcode.dfs.TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }

    private void pushRightPath(com.leetcode.dfs.TreeNode root, ArrayDeque<com.leetcode.dfs.TreeNode> stack) {
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.right;
        }
    }
}
