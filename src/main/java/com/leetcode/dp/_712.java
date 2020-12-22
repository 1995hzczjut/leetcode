package com.leetcode.dp;

public class _712 {

    /**
     * find the lowest ASCII sum of deleted characters to make two strings equal. ==> LCSubstring
     */
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + calculate(s2, j);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + calculate(s1, i);
                } else if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + calculate(s1, i), dp[i][j - 1] + calculate(s2, j));
                }
            }
        }
        return dp[m][n];
    }

    private int calculate(String s1, int i) {
        if (i == 0) {
            return 0;
        }
        return s1.charAt(i - 1) - 'a' + 97;
    }

    public static void main(String[] args) {
        System.out.println(new _712().minimumDeleteSum("sea", "eat"));
    }

}
