package com.jianzhiOffer;

/**
 * @author Zhancong Huang
 * @date 21:48 2019/4/21
 */
public class p30 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int res = dp[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(array[i], dp[i - 1] + array[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
