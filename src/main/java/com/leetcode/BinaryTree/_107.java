package com.leetcode.BinaryTree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * bFS简单，用list.insert(0.XX)
 *DFS比较巧妙/
 *
 * @author Zhancong Huang
 * @date 16:44 2018/12/11
 */
public class _107 {

    /**
     * BFS
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmpList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tmpList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(0, tmpList);
        }
        return result;
    }


    /**
     * DFS,递归遍历标记层数，常用技巧，但这么做一定可用BFS简化，知道就行
     */
    public List<List<Integer>> levelOrderBottom(com.leetcode.dfs.TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        helper(result, root, 0);
        return result;
    }

    public void helper(List<List<Integer>> result, com.leetcode.dfs.TreeNode root, int level) {
        if (root == null) return;
        if (level >= result.size()) {
            result.add(0, new LinkedList<>());
        }
        //这样写非常巧，不管result有没有初始化OK都满足提议。且水平方向也是从左到右
        result.get(result.size() - level - 1).add(root.val);
        helper(result, root.left, level + 1);
        helper(result, root.right, level + 1);
    }

}
