package com.leetcode.math;

import java.util.Arrays;

/**
 * 变成一个绝对值表达式的最值问题，答案是选数组中间的值。
 * 我也不知道为什么
 *
 * @author Zhancong Huang
 * @date 14:54 2019/5/3
 */
public class _462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int t = nums[nums.length / 2];
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            r += Math.abs(t - nums[i]);
        }
        return r;
    }
}
