package com.leetcode.dp;

/**
 * 思路都是来自上一个回文字符串的问题。看两边新加入的，注意subsquence
 *
 * @author Zhancong Huang
 * @date 21:39 2018/12/4
 */
public class _516 {

    /**
     * 对比Longest Palindromic Substring
     * 同时类比LCS的两个问题
     */
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if (s.charAt(i) == s.charAt(j)) {
                    //正好不用考aa的特殊情况
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    //与LCSubsequence一样
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        //结果没必要用result保存全局最大，因为dp[i][j]本来就代表[i,j]之间的最大回文序列
        return dp[0][s.length() - 1];
    }

}
