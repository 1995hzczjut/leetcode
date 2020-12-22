package com.leetcode.BinaryTree;

import com.leetcode.dfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhancong Huang
 * @date 16:41 2019/7/15
 */
public class _257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        helper(list, "", root);
        return list;
    }

    /**
     * 类似combination, 不过这里遍历到一个点时，自己还没加进去。
     * 之前有类似的，临时变量不断记录，最后在叶子节点收工，临时变量很多时候要清空，这里可共用。
     */
    private void helper(List<String> result, String tmpStr, TreeNode root) {
        //这里递归以叶子节点为终止，所以null直接返回
        if (root == null) return;
        if (root.left == null && root.right == null) {
            result.add(tmpStr + root.val);
        }
        helper(result, tmpStr + root.val + "->", root.left);
        helper(result, tmpStr + root.val + "->", root.right);
    }
}
