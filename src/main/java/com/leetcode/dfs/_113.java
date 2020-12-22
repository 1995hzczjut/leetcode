package com.leetcode.dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Zhancong Huang
 * @date 14:11 2019/7/16
 */
public class _113 {
    /**
     * 可用一个tmpList记录临时状态(注意清除)，走先序遍历，在叶子节点汇总（最容易漏的是对叶子节点的tmpList的消除）
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        helper(result, new LinkedList<>(), root, sum, sum);
        return result;
    }


    private void helper(List<List<Integer>> result, List<Integer> tmpList, TreeNode root, int remain, int target) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            //处理叶节点.这里漏了很多逻辑。tmpList只要add，在return前一定要撤销所加，最下面的节点也一样
            if (remain == root.val) {
                tmpList.add(root.val);
                result.add(new LinkedList<>(tmpList));
                tmpList.remove(tmpList.size() - 1);
            }
            return;
        }
        tmpList.add(root.val);
        helper(result, tmpList, root.left, remain - root.val, target);
        helper(result, tmpList, root.right, remain - root.val, target);
        tmpList.remove(tmpList.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode raw2_1 = new TreeNode(2);
        TreeNode raw2_2 = new TreeNode(3);
        TreeNode raw3_1 = new TreeNode(4);
        TreeNode raw3_3 = new TreeNode(5);
        TreeNode raw3_4 = new TreeNode(6);
        TreeNode raw4_5 = new TreeNode(7);
        root.left = raw2_1;
        root.right = raw2_2;
        raw2_1.left = raw3_1;
        raw2_2.left = raw3_3;
        raw2_2.right = raw3_4;
        raw3_3.left = raw4_5;
        for (int i = 0; i < 50; i++) {
            System.out.println("i:" + i + "  " + new _113().pathSum(root, i));
        }

    }
}
