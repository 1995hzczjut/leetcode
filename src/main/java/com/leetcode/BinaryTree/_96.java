package com.leetcode.BinaryTree;

import com.leetcode.dfs.TreeNode;
import com.leetcode.dp._95;

import java.util.ArrayList;
import java.util.List;

/**
 * 难点在于DP空间的优化又技巧
 *
 * @author Zhancong Huang
 * @date 20:36 2019/7/18
 * @see _95
 */
public class _96 {
    /**
     * 递归超时，只能DP。
     */
    public int numTrees(int n) {
        return helper(1, n);
    }

    private int helper(int start, int end) {
        if (start > end){
            //即root = NULL
            return 1;
        }
        int result = 0;
        for (int i = start; i <= end; i++) {
            result += helper(start, i - 1) * helper(i + 1, end);
        }
        return result;
    }

    /**
     * 例如n=7,12 3 4567
     * 已经知道算7的时候有个乘法的过程，关键在于4567这个能组成多少想不出来
     * 这也是关键：任意一组有序数组，只要个数一样结果就是一样
     * 所以4567 跟1234结果一样的，这才可以用DP，否则绝对不可优化到O（N）的空间复杂度
     * G【i】代表i个递增数字能组成几个树
     *
     * @param n n>0
     * @return
     */
    public int numTreesDP(int n){
        int [] G = new int[n+1];
        G[0] = G[1] = 1;

        for(int i=2; i<=n; ++i) {
            for(int j=1; j<=i; ++j) {
                G[i] += G[j-1] * G[i-j];
            }
        }

        return G[n];
    }

    public static void main(String[] args) {
        System.out.println(new _96().numTrees(3));

        //list可用放空值
        List<TreeNode> result = new ArrayList<>();
        result.add(null);
        for (TreeNode node : result) {
            System.out.println(node);
        }
    }
}
