package com.leetcode.dp;

import java.util.List;

/**
 * 背景问题：60?矩阵的path sum
 * 有两种DP做法
 * https://blog.csdn.net/derrantcm/article/details/47651229
 * 自底向上
 *
 * 注意每一行都是从0开始的，不是放在一个矩阵里面
 * @author Zhancong Huang
 * @date 20:27 2018/11/20
 */
public class _120 {
    /**
     * dp[i][j] 代表从这一点（含这一点的值）走到底的最小值
     * 从下导上的DP。从上到下也可以。不过要单独处理两条边
     *
     */
    public static int minimumTotal1(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (i == n - 1) {
                    dp[i][j] = triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
                }
            }
        }
        return dp[0][0];
    }

    /**
     * 空间优化，只用到一层
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int n = triangle.size();
        Integer[] result = triangle.get(n - 1).toArray(new Integer[n]);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                result[j] = Math.min(result[j], result[j + 1]) + triangle.get(i).get(j);
            }
        }
        return result[0];
    }

    public static void main(String[] args) {

    }
}
