package com.leetcode.dp;

/**
 * dp[i][j] : (i,j)为右下角的最大正方形边长。跟最大子和那个很像。直觉跟dp[i-1][j-1]
 *
 * @author Zhancong Huang
 * @date 21:37 2018/11/23
 */
public class _221 {
    public static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int result = Integer.MIN_VALUE;
        //init
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
            result = Math.max(result, dp[i][0]);
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j] - '0';
            result = Math.max(result, dp[0][j]);
        }

        //
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] - '0' == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result == Integer.MIN_VALUE ? 0 : result * result;
    }

    public static void main(String[] args) {

    }
}
