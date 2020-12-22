package com.jianzhiOffer;

/**
 * https://www.nowcoder.com/questionTerminal/72a5a919508a4251859fb2cfb987a0e6
 * 应该从左往右第一块分析。因为无论怎么放，第一块要么竖着，要么横着。因此导出DP。
 * 不要用斐波那契那个递归了。
 * @author Zhancong Huang
 * @date 0:29 2019/4/17
 */
public class p10 {
    public int RectCover(int target) {
        if (target == 0 ) return 0;
        if (target == 1) return 1;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }
}
