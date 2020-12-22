package com.jianzhiOffer;

/**
 * @author Zhancong Huang
 * @date 0:27 2019/4/17
 */
public class p9 {
    public int JumpFloorII(int target) {
        if (target <= 1) return 1;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target];
    }
}
