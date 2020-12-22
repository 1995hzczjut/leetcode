package com.leetcode.Stack;

import com.leetcode.dfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 利用list.add(0,e)实现逆序插入。整体reverse list不可取，效率太低了
 *
 * @author Zhancong Huang
 * @date 22:07 2019/3/15
 */
public class _103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            //queue.offer(root)可以插入null
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        //true 代表向右加入
        boolean flag = true;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (flag) {
                    levelList.add(tmp.val);
                } else {
                    levelList.add(0, tmp.val);
                }
                if (tmp.left != null) queue.offer(tmp.left);
                if (tmp.right != null) queue.offer(tmp.right);
            }
            flag = !flag;
            res.add(levelList);
        }
        return res;
    }
}
