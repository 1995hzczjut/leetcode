package com.leetcode.dp;

import java.util.Arrays;

/**
 * 小心溢出错误
 * if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
 *
 * @author Zhancong Huang
 * @date 21:37 2018/11/26
 * @see _279
 */
public class _322 {

    /**
     * dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]); 发生溢出
     * 假设输入[2] 3. dp[1]没有包可以放，所以是Int.MAX_Value.
     * 279没有这个问题，因为dp[i]永远存在一个解，就是11111111111111111
     * 这题不保证，所以要提前筛选
     */
    public int coinChange1Error(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : (int) dp[amount];
    }
}
