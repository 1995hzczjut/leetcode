package com.leetcode.dp;

/**
 * 跟647差不多
 *
 * @author Zhancong Huang
 * @date 19:45 2018/11/19
 */
public class _5 {


    public String longestPalindrome(String s) {
        if (s.length() == 0) return s;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] res = new int[2];

        for (int i = n; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i < 3) || (dp[i + 1][j - 1]))) {
                    if (res[1] - res[0] < j - i) {
                        res[0] = i;
                        res[1] = j;
                    }
                }
            }
        }
        return s.substring(res[0], res[1] + 1);
    }
}
