package com.leetcode.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhancong Huang
 * @date 23:13 2018/12/19
 */
public class _589 {
    public List<Integer> preorder1(Node root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    public void helper(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        for (Node node : root.children) {
            helper(node, result);
        }
    }

    //iterative
    public List<Integer> preorder(Node root) {
        ArrayDeque<Node> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                //其他地方记得判空，集合添加null很坑，会把Null重新包装。这里不用了
                stack.push(node.children.get(i));
            }
        }
        return result;
    }
}
