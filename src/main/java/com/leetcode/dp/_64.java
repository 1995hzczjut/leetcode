package com.leetcode.dp;

/**
 * DP矩阵的初始值 尽量不要单独出来写.
 *
 * @author Zhancong Huang
 * @date 20:59 2018/11/19
 */
public class _64 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = (j > 0 ? dp[i][j - 1] : 0) + grid[i][j];
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                    continue;
                }
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
