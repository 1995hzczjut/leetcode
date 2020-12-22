package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class _515 {
    //用BFS层遍历更简单。
    public static List<Integer> largestValues(TreeNode root) {
        //开始想用MAP。没必要，list的下表就是map的key
        List<Integer> list = new ArrayList<Integer>();
        helper1(root, 1, list);
        return list;
    }

    private static void helper1(TreeNode node, int depth, List<Integer> list) { //注意第三个参数后面要带泛型。不然list.get是Object型
        if (node != null) {
            if (list.size() < depth) {
                list.add(node.val);
            } else {
                list.set(depth - 1, Math.max(list.get(depth - 1), node.val));
            }
        } else {
            return;
        }

        helper1(node.left, depth + 1, list);
        helper1(node.right, depth + 1, list);
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
        System.out.println(largestValues(root).toString());

    }
}
