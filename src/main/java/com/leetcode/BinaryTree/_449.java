package com.leetcode.BinaryTree;

import java.util.ArrayDeque;

/**
 * 297,一般树的s
 *
 * @author Zhancong Huang
 * @date 0:36 2018/12/29
 */
public class _449 {

    /**
     * BST具有特殊性：
     * 序列化输出先序结果，反序列化根据之前的顺序插入就行了（可用自己测试）
     * 普通树的（反）序列化比较复杂，要占位符标记Null节点
     */
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        if (root == null) return result.toString();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        stack.push(cur);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            //result.append(cur.val).append(" ");  这里变成Char了
            result.append(String.valueOf(cur.val)).append(" ");
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }
        return result.toString().trim();
    }


    public TreeNode deserialize(String data) {
        if (data == null || data.length() < 1) {
            return null;
        }
        String[] datas = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(datas[0]));
        for (int i = 1; i < datas.length; ++i) {
            insert(root, Integer.parseInt(datas[i]));
        }
        return root;
    }

    private void insert(TreeNode root, int num) {
        TreeNode cur = root;
        while (true) {
            if (num <= cur.val) {
                if (cur.left == null) {
                    cur.left = new TreeNode(num);
                    return;
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = new TreeNode(num);
                    return;
                }
                cur = cur.right;
            }
        }
    }


}
