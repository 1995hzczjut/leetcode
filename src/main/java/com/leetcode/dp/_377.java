package com.leetcode.dp;

import java.util.Arrays;

/**
 * 背包问题最简单版本，包可以无限使用。
 * 注意dp[0]，根据dp代表什么而变。
 *
 * @author Zhancong Huang
 * @date 22:17 2018/11/29
 */
public class _377 {

    static int count = 0;

    /**
     * （1,1,2) (1,2,1)现在看作同一种，怎么改？
     */
    public static int combinationSum4_1(int[] nums, int target) {
        Arrays.sort(nums);
        helper(target, nums, target);
        return count;

    }

    public static void helper(int target, int[] nums, int remain) {
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            count++;
        }
        for (int i = 0; i < nums.length; i++) {
            helper(target, nums, remain - nums[i]);
        }
    }

    /**
     * 注意题目，问的是解决方案，而不是包的数量。dp[0]意义是空的扔的方法，是一种。
     * 如果问包数量，dp[0]=0.
     */
    public static int combinationSum4_2(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num] ;
                }
            }
        }
        return dp[target];
    }


    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        int t = 4;
        System.out.println(combinationSum4_2(nums, t));
    }
}
