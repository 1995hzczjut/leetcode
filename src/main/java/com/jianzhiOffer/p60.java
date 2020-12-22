package com.jianzhiOffer;

import com.leetcode.dfs.TreeNode;

import java.util.*;

/**
 * @author Zhancong Huang
 * @date 20:45 2019/4/29
 */
public class p60 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            ArrayList<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(new ArrayList<>(tmp));
        }
        return res;
    }
}
