package com.leetcode.BinaryTree;

import java.util.*;

/**
 * 跟508很像。先序的基本代码，在最后加处理MAP。
 * 效果是从下往上加入MAP。
 *
 * @author Zhancong Huang
 * @date 22:39 2019/1/2
 */
public class _652 {
    /**
     * 要找一个树里的重复结构的子树，思考一堆数字里找出有重复的是怎么左的？
     * 用一个MAP保存出现的次数就好了，树也是一样
     * 一开始的做法，遍历全部，每个节点看成一棵树，序列化成一个字符串作为Key,这样虽然可行，但是重复遍历次数太多了
     * 只遍历一次就可以完成MAP的初始化如何做到？序列化完一个节点，立马存入Key.这样遍历全部节点一次就可以了。
     * 问题：开始想着key为序列化结果，value为出现次数。最后反序列化出来，这样太慢了(或者mutilvaluemap，可惜没有)。
     * map改为key不变，value第一次存为NULL，后来存为根节点。因为题目只要求返回一个。
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, TreeNode> map = new HashMap<>(256);
        helper(root, map);
        List<TreeNode> result = new LinkedList<>();
        for (Map.Entry<String, TreeNode> entry : map.entrySet()) {
            if (entry.getValue() != null) {
                result.add(entry.getValue());
            }
        }
        return result;
    }

    private String helper(TreeNode root, Map<String, TreeNode> map) {
        if (root == null) {
            return "#";
        }
        StringBuilder treeString = new StringBuilder();
        treeString.append(String.valueOf(root.val)).append(" ")
                .append(helper(root.left, map)).append(" ")
                .append(helper(root.right, map));
        map.put(treeString.toString(), map.containsKey(treeString.toString()) ? root : null);
        return treeString.toString();
    }
}
