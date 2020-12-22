package com.leetcode.dp;

/**
 * @author Zhancong Huang
 * @date 20:39 2018/11/26
 * @see _221
 */
public class _304 {

    /**
     * dp[i][j]类似221代表从最左上点到i，j的面积.预先算出来，后面每次调用sumRegion都O（1）解决
     * 退化成一维数组的话更好理解
     */
    int[][] dp;

    public _304(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m][n];
        //init
        for (int i = 0; i < m; i++) {
            dp[i][0] = (i == 0 ? 0 : dp[i - 1][0]) + matrix[i][0];
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = (j == 0 ? 0 : dp[0][j - 1]) + matrix[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i][j];
            }
        }
    }


    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (dp == null) {
            return 0;
        }
        row1 = row1 - 1;
        col1 = col1 - 1;
        return dp[row2][col2] - (col1 < 0 ? 0 : dp[row2][col1]) - (row1 < 0 ? 0 : dp[row1][col2])
                + (col1 < 0 || row1 < 0 ? 0 : dp[row1][col1]);
    }

    public static void main(String[] args) {
        int[][] nums = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        System.out.println(new _304(nums).sumRegion(2, 1, 4, 3));
        System.out.println(new _304(nums).sumRegion(1, 1, 2, 2));
        System.out.println(new _304(nums).sumRegion(1, 2, 2, 4));
    }
}
