package com.leetcode.hzc;

/**
 * subarray的最值基本对应dp[i]代表以i为末尾的情况
 *
 *
 * @author Zhancong Huang
 * @date 15:55 2019/8/11
 */
public class _53 {

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.max(dp[i - 1] + nums[i], nums[i]);
            result = Integer.max(result, dp[i]);
        }
        return result;
    }

}
