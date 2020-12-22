package com.jianzhiOffer;

import com.leetcode.dfs.TreeNode;

import java.util.*;

/**
 * 无论如何都不能用reverse collection. 用addFirst
 *
 * @author Zhancong Huang
 * @date 20:10 2019/4/29
 */
public class p59 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        boolean left2right = true;

        while (!queue.isEmpty()) {
            List<Integer> tmp = new LinkedList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (left2right) tmp.add(node.val);
                else tmp.add(0, node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

            }
            left2right = !left2right;
            res.add(new ArrayList<>(tmp));
        }
        return res;
    }
}
