package com.jianzhiOffer;

import com.leetcode.dfs.TreeNode;

import java.util.ArrayList;

/**
 * 严格combination的做法。属于起点特殊的那一种.注意tmp.used(本题没有)都要预先加入
 *
 * @author Zhancong Huang
 * @date 12:42 2019/4/21
 */
public class p24 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        //起点自己要先加进去，参考
        ArrayList<Integer> tmpList = new ArrayList<>();
        tmpList.add(root.val);
        helper(result, tmpList, root, target - root.val);
        return result;
    }

    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> tmpList, TreeNode root, int remain) {
        if (remain < 0) {
            return;
        }
        if (remain == 0 && isLeaveNode(root)) {
            result.add(new ArrayList<>(tmpList));
            return;
        }
        //同样这里的逻辑是判断能不能走到。
        //树根图的差别在于这一步非常简单，不为空就能走到。
        if (root.left != null) {
            tmpList.add(root.left.val);
            helper(result, tmpList, root.left, remain - root.left.val);
            tmpList.remove(tmpList.size() - 1);
        }
        if (root.right != null) {
            tmpList.add(root.right.val);
            helper(result, tmpList, root.right, remain - root.right.val);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    private boolean isLeaveNode(TreeNode root) {
        return root != null && root.left == null && root.right == null;
    }


}
