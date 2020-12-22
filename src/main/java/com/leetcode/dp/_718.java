package com.leetcode.dp;

/**
 * @author Zhancong Huang
 * @date 20:30 2018/12/8
 */
public class _718 {
    public int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m + 1][n + 1]; //dp[0] 就代表空数组，开区间
        int result = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                //corner case
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0;
                }
                result = Integer.max(result, dp[i][j]);
            }
        }
        return result;
    }
}
