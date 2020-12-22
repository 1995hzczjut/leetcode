package com.leetcode.dp;

/**
 * 数学求解太烦了
 * DP问题。dp[i]代表题目要求的值。以i=14为例，先拆成两个数，以j和i-j表示
 * j可以从1到7，7后面重复了。子问题就找到了，即dp[j],dp[i-j]
 * 具体分析，j=6.dp[14] = Max(old dp[14] ,Max(6, dp[6]) * Max(8 ,dp[8]))
 *
 * @author Zhancong Huang
 * @date 12:46 2019/5/3
 */
public class _343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            //从1开始为不是0.一个数必须要分成两个
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max(j , dp[j]) * Math.max(i - j, dp[i - j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new _343().integerBreak(10));
    }
}
