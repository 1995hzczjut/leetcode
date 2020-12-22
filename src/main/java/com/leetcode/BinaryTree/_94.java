package com.leetcode.BinaryTree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

/**
 * 思考下面怎么改成迭代器模式？
 *
 * @author Zhancong Huang
 * @date 12:29 2019/6/4
 */
public class _94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        List<Integer> res = new LinkedList<>();

        while (!stack.isEmpty() || cur != null){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
