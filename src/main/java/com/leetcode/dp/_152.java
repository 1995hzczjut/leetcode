package com.leetcode.dp;

/**
 *
 * 在5的基础上改进。之前是累计和。现在是乘积，那么dp[i] 代表以i结尾最大的积
 * dp[i]还是依赖dp[i-1],但是如果i是负数，那要看以i-1结尾的最小积是不是负数了，是负数找最小的那个。是正数找之前的最大的
 *
 * 前置问题53： dp[i]  depends on dp[i - 1] or nums[i]  两部分 subarray的DP问题都可以这个思路
 * 还有一道题(628)，是找3个数，乘积最大
 * ===========
 * 第一次做到一个点要记录两个DP值.也可以看成二位数组，dp[0][i],dp[1][i]对应dpMin，dpMax
 *
 * @author Zhancong Huang
 * @date 22:14 2018/11/21
 */
public class _152 {
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dpMin = new int[n];
        int[] dpMax = new int[n];
        //dp有初始值，那么全局max也应该有初始值
        int max = nums[0];
        dpMin[0] = dpMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dpMin[i] = Math.min(Math.min(nums[i] * dpMin[i - 1], nums[i] * dpMax[i - 1]), nums[i]);
            dpMax[i] = Math.max(Math.max(nums[i] * dpMin[i - 1], nums[i] * dpMax[i - 1]), nums[i]);
            max = Math.max(max, dpMax[i]);
        }
        return max;
    }

    //优化空间
    public static int maxProduct1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int prevMin = nums[0];
        int prevMax = nums[0];
        int max = nums[0];
        int curMax = 0;
        int curMin = 0;
        for (int i = 1; i < n; i++) {
            curMin = Math.min(Math.min(nums[i] * prevMax, nums[i] * prevMin), nums[i]);
            curMax = Math.max(Math.max(nums[i] * prevMax, nums[i] * prevMin), nums[i]);
            prevMax = curMax;
            prevMin = curMin;
            max = Math.max(max, curMax);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] n = {2, 3, -2, 4};
        //int[] n = {2,2,2};
        System.out.println(maxProduct1(n));
    }
}
