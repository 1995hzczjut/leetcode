package com.leetcode.dp;

import java.util.Arrays;

/**
 * @author Zhancong Huang
 * @date 10:04 2018/12/6
 */
public class _650 {
    /**
     * 要得到24个A。假设花费x步得到8个A.之后copy-paste-paste ，共3步得到24个A
     */
    public static int minSteps(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        //init
        dp[1] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                }
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(minSteps(8));
    }
}
