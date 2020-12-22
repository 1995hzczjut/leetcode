package com.leetcode.array;

import com.leetcode.dp._300;

import java.util.Arrays;

/**
 * 就是 Longest  Increasing Subarray问题。跟300不一样的
 *
 * @author Zhancong Huang
 * @date 15:20 2019/1/13
 * @see _300
 */
public class _674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i - 1] < nums[i] ? dp[i - 1] + 1 : 1;
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
