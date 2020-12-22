package com.jianzhiOffer;

import com.leetcode.dfs.TreeNode;

import java.util.*;

/**
 * 先序遍历序列化，反序列化的时候消费队列，也是先序遍历的构造
 *
 * @author Zhancong Huang
 * @date 20:48 2019/4/29
 */
public class p61 {

    public String Serialize(TreeNode root) {
        if (root == null) return "#";
        return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }

    public TreeNode Deserialize(String str) {
        if (str == null || str.length() < 1) return null;
        return helper(new LinkedList<>(Arrays.asList(str.split(" "))));
    }

    private TreeNode helper(Queue<String> queue) {
        String nodeVal = queue.poll();
        if ("#".equals(nodeVal)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(nodeVal));
        root.left = helper(queue);
        root.right = helper(queue);
        return root;
    }

}
