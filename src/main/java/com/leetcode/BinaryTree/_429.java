package com.leetcode.BinaryTree;

import java.util.*;

/**
 * @author Zhancong Huang
 * @date 21:38 2018/12/13
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
public class _429 {

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                tmp.add(node.val);
                for (Node child : node.children) {
                    queue.offer(child);
                }
            }
            result.add(tmp);
        }
        return result;
    }
}
