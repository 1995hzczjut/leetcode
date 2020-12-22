package com.leetcode.dp;

import com.leetcode.array._674;

import java.util.Arrays;

/**
 * 674简单一点，这里的dp含义比较少见，subsquence问题一般代表前i个
 *
 * @author Zhancong Huang
 * @date 16:00 2019/9/30
 * @see _674
 */
public class _300 {

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            result = Math.max(result, dp[i]);
        }
        //最长的LIS不一定以最后个数字为结尾
        return result;
    }
}
