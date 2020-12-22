package com.leetcode.BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 利用BST的中序遍历是有序数组的特点
 *
 * @author Zhancong Huang
 * @date 15:49 2019/7/16
 */
public class _530 {

    public int getMinimumDifference(TreeNode root) {
        if (root == null){
            return 0;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        Integer prev = null;
        int result = Integer.MAX_VALUE;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                //process
                if (prev != null){
                    result = Math.min(result, cur.val - prev);
                }
                prev = cur.val;
                cur = cur.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
