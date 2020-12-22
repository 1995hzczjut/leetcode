package com.leetcode.dp;

/**
 * @author Zhancong Huang
 * @date 12:40 2019/9/30
 */
public class _338 {

    /**
     * 思路：
     * 15 - 8（最靠近的2的N次方） = 7
     * 1111 - 1000 = 0111
     * dp[15] = d[7] + 1
     *
     */
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        int nearest = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0){
                nearest = i;
            }
            dp[i] = dp[i - nearest] + 1;
        }
        return dp;
    }


}
