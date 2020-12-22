package com.leetcode.BinaryTree;

import java.util.*;

/**
 * @author Zhancong Huang
 * @date 8:57 2019/7/17
 */
public class _590 {

    /**
     * recursive
     */
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new LinkedList<>();
        for (Node child : root.children) {
            result.addAll(postorder(child));
        }
        result.add(root.val);
        return result;
    }


    /**
     * 迭代
     */
    public List<Integer> postOrder1(Node root){
        if (root == null) return Collections.emptyList();
        List<Integer> result = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        stack.push(cur);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            result.add(0, cur.val);
            for (Node child : cur.children) {
                stack.push(child);
            }
        }
        return result;
    }
}
