package com.leetcode.dp;

/**
 * 198升级
 *
 * @author Zhancong Huang
 * @date 23:16 2018/11/21
 */
public class _213 {
    /**
     * 跟之前的差距就是现在房子是环形的，即首尾连在一起，即首，尾不能同时打劫。
     * 即两者至少有一间没有被打劫。
     * 所以最后的最优打劫方案，是不打头或不打位的利益最大值
     */
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int start, int end) {
        if (start > end) {
            return -1;
        }
        if (start == end) {
            return nums[start];
        }
        int[] dp = new int[end - start + 1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i - start] = Math.max(dp[i - start - 2] + nums[i], dp[i - start - 1]);
        }
        return dp[dp.length - 1];
    }

}
