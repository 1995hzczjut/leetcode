package com.leetcode.dp;

/**
 * @author Zhancong Huang
 * @date 23:43 2019/5/11
 */
public class _63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (i == 0 || obstacleGrid[i][j] == 1? 0 : dp[i - 1][j]) + (j == 0 || obstacleGrid[i][j] == 1? 0 : dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
