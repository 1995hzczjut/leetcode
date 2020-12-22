package com.leetcode.dp;

/**
 * Longest Common Subsquence/SubString 两个问题
 * https://segmentfault.com/a/1190000002641054
 * int[][] dp = new int[m+1][n+1]更合适;
 * dp[i]  表示[0,i) 这样dp[0]代表空串，否则要用dp[-1]了
 *
 * @author Zhancong Huang
 * @date 0:18 2018/12/8
 */
public class LCS {

    /**
     * dp[i][j]代表两个字符串前i个字母和前j个字母的LCSq值。注意不是以XX为底的了，这是subSequence DP题目的常用套路
     * 依赖最后两个字母是否相等。相等直接+1。
     * 不想等的话，这两个字母绝对不会同时出现在LCSq，同时DP要往<=i,<=j的状态值中找，所以dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]
     */
    public int lengthofLCSubsquence(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    //TODO： 改为new int[m+1][n+1];
    //这里DP表示以XX结尾的
    public int lengthofLCSubstring(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m][n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = (i == 0 || j == 0 ? 0 : dp[i - 1][j - 1]) + 1;
                } else {
                    dp[i][j] = 0;
                }
                result = Integer.max(result, dp[i][j]);
            }
        }
        return result;

    }


    public static void main(String[] args) {
        LCS s = new LCS();
        System.out.println(s.lengthofLCSubstring("abc", "ca "));
        System.out.println(s.lengthofLCSubstring("abc", "adcd"));
        System.out.println(s.lengthofLCSubstring("abc", "abc"));
    }
}
