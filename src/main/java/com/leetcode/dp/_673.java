package com.leetcode.dp;

import java.util.Arrays;

/**
 * 与LIS差别：要输出最大的DP值的个数
 * 那么需要另外个数组counts计算每个dp[i]取到最大的次数，关键这个要动态更新
 * 最后要特别注意，例如count等于12222
 * 最后要把2222加起来，难点也是要动态更新.回顾怎么找数组的最值。
 *
 * @author Zhancong Huang
 * @date 22:41 2018/12/6
 */
public class _673 {

    public static int findNumberOfLIS0(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int[] counts = new int[nums.length];
        int maxDp = 1;
        int res = 1;
        Arrays.fill(dp, 1);
        Arrays.fill(counts, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    counts[i] = counts[j];
                } else if (nums[j] < nums[i] && dp[j] + 1 == dp[i]) {
                    //core
                    counts[i] += counts[j];
                }
            }
            //查看dp[i]跟全局最大值maxDp关系
            if (dp[i] > maxDp) {
                maxDp = dp[i];
                res = counts[i];
            } else if (dp[i] == maxDp) {
                res += counts[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findNumberOfLIS0(new int[]{1, 2, 3, 1, 2, 3, 1, 2, 3}));
    }
}
