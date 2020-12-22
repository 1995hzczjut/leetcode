package com.leetcode.dp;

/**
 * 回文问题的入门，DP转移比较好想，但写的跟下面间接很难，另外具体转移也不要写成竖线了。
 * 这种依赖关系以后都可以写成这样的遍历方式。
 *
 * @author Zhancong Huang
 * @see _516
 * @see _5 进阶题目,核心dp转移dp[i][j] = (j - i < 3 || dp[i + 1][j - 1]) && (arr[i] == arr[j]);一样的
 */
public class _647 {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int result = 0;

        for (int i = n - 1; i >= 0 ; i--) {
            for (int j = i; j < n; j++) {
                if (dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1])){
                    result++;
                }
            }
        }

        return result;
    }


}
