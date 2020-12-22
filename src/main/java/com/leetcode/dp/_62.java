package com.leetcode.dp;

/**
 * @author Zhancong Huang
 * @date 22:09 2019/5/11
 */
public class _62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (i == 0 ? 0 : dp[i - 1][j]) + (j == 0 ? 0 : dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new _62().uniquePaths(3, 2));
    }
}
