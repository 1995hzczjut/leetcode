package com.leetcode.BinaryTree;

import java.util.LinkedList;
import java.util.List;

/**
 * 先序+depth,堆
 *
 * @author Zhancong Huang
 * @date 12:48 2019/1/3
 */
public class _662 {
    /**
     * 思路：
     * 把root代表的树嵌到一个堆里面，堆每个元素从1开始分配坐标，这个规律之前堆排学到过，节点i的两个子节点为 2i 2i+1
     * 然后考虑遍历，遍历到的时候用当前点的坐标减去这一行的起点坐标，维护这个全局最大值
     * 每一行的起点求法也是常用的，用depth+先序+list,用list.size和depth的大小关系知道是不是第一次遍历到此层
     * 其实end list不需要
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int[] result = new int[1];
        result[0] = 1;
        helper(root, 1, 0, result, new LinkedList<>());
        return result[0];
    }

    /**
     * @param root
     * @param index  从1开始
     * @param depth  从0开始
     * @param result 就一个值，初始为1.想象站在树的左边，存的是每一层第一个看到的节点的坐标
     * @param start  每一行的起点坐标
     */
    private void helper(TreeNode root, int index, int depth, int[] result, List<Integer> start) {
        if (root == null) {
            return;
        }

        if (depth == start.size()) {
            //第一次来到该层
            start.add(index);
        }
        result[0] = Math.max(result[0], index - start.get(depth) + 1);
        helper(root.left, 2 * index, depth + 1, result, start);
        helper(root.right, 2 * index + 1, depth + 1, result, start);
    }
}
