package com.leetcode.dp;

/**
 * @author Zhancong Huang
 * @date 21:53 2019/5/7
 */
public class _583 {
    public  int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        _583 s = new _583();
        System.out.println(s.minDistance("sea", "eat"));
        System.out.println(s.minDistance("abc", "adcd"));
        System.out.println(s.minDistance("abc", "abc"));
    }
}
