package com.leetcode.BinaryTree;

import com.leetcode.dfs.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 注意先push root,while条件跟94不一样。
 *
 * @author Zhancong Huang
 * @date 12:56 2019/6/4
 */
public class _144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null){
            //stack 不能放空值
            return new ArrayList<>();
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        List<Integer> res = new LinkedList<>();

        stack.push(cur);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }
        return res;
    }

}
