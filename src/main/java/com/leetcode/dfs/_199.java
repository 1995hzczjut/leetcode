package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层遍历最好
 *
 * @author Zhancong Huang
 * @date 13:28 2019/7/19
 */
public class _199 {


    /**
     * 反先序+层标记，之前做过类似，每一层深度>当前List的size代表第一次来到当前节点，把他加入结果
     */
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list, 1);
        return list;
    }

    public void dfs(TreeNode root, List<Integer> list, int depth) {
        if (root == null) return;
        if (list.size() < depth) {
            list.add(root.val);
        }
        dfs(root.right, list, depth + 1);
        dfs(root.left, list, depth + 1);
    }


    /**
     * 层遍历。推荐
     */
    public static List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode tmpNode = queue.poll();
                if (i == 0) res.add(tmpNode.val);
                if (tmpNode.right != null) queue.add(tmpNode.right);
                if (tmpNode.left != null) queue.add(tmpNode.left);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode raw2_1 = new TreeNode(2);
        TreeNode raw2_2 = new TreeNode(3);
        TreeNode raw3_1 = new TreeNode(4);
        TreeNode raw3_2 = new TreeNode(5);
        TreeNode raw3_3 = new TreeNode(6);
        TreeNode raw4_1 = new TreeNode(7);
        root.left = raw2_1;
        root.right = raw2_2;
        raw2_1.left = raw3_1;
        raw2_2.left = raw3_2;
        raw2_2.right = raw3_3;
        raw3_2.left = raw4_1;
        System.out.println(rightSideView2(root));
    }

}
