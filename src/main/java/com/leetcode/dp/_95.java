package com.leetcode.dp;

import com.leetcode.BinaryTree._96;
import com.leetcode.dfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回是List<Treenode>
 *
 * @author Zhancong Huang
 * @date 22:34 2018/11/19
 * @see _96
 */
public class _95 {

    /**
     * 递归.开始1-5构造树，随便选一个，左右两边就是子问题。
     */
    public List<TreeNode> generateTrees1(int n) {
        return helper(1, n);
    }


    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            //否则没法遍历helper(2,1)这种
            result.add(null);
            return result;
        }
        for (int k = start; k <= end; k++) {
            List<TreeNode> leftList = helper(start, k - 1);
            List<TreeNode> rightList = helper(k + 1, end);
            //LIST是可以放空值的，add null,size照样加一，就可以迭代
            for (TreeNode leftNode : leftList) {
                for (TreeNode rightNode : rightList) {
                    TreeNode root = new TreeNode(k);
                    root.left = leftNode;
                    root.right = rightNode;
                    result.add(root);
                }
            }
        }
        return result;
    }

    /**
     * 改成DP，难点分析状态转移怎么写，发现跟回文字符串的问题非常相似，因此遍历方法同样为
     * for (int i = n; i >= 0; i--) {
     * for (int j = i; j <= n; j++) {
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<TreeNode>[][] dp = new List[n + 1][n + 1];
        for (int i = n; i >= 0; i--) {
            for (int j = i; j <= n; j++) {
                if (i == j) {
                    dp[i][j] = new ArrayList<>();
                    dp[i][j].add(new TreeNode(i));
                } else {
                    dp[i][j] = new ArrayList<>();
                    for (int k = i; k <= j; k++) {
                        if (k == i) {
                            for (TreeNode right : dp[k + 1][j]) {
                                TreeNode root = new TreeNode(k);
                                root.right = right;
                                dp[i][j].add(root);
                            }
                        } else if (k == j) {
                            for (TreeNode left : dp[i][k - 1]) {
                                TreeNode root = new TreeNode(k);
                                root.left = left;
                                dp[i][j].add(root);
                            }
                        } else {
                            //类似笛卡儿积
                            for (TreeNode left : dp[i][k - 1]) {
                                for (TreeNode right : dp[k + 1][j]) {
                                    TreeNode root = new TreeNode(k);
                                    root.left = left;
                                    root.right = right;
                                    dp[i][j].add(root);
                                }
                            }
                        }
                    }
                }
            }
        }
        return dp[1][n];
    }


    public static void main(String[] args) {
        System.out.println(new _95().generateTrees1(5).size());
    }
}
