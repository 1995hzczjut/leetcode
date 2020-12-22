package com.leetcode.dp;

/**
 * dp[i] 就代表前i+1的情况，为什么可以这么做？
 * 以i 打不打劫分类
 *
 * @author Zhancong Huang
 * @date 22:58 2018/11/21
 */
public class _198 {
    /**
     * 类似subquence的问题，所以dp选择到x为止
     * 这个做法和 下面的优化一定要会.
     * dp[i]表示打劫到第i天的最优情况。第i天要么打劫要么不被打劫。
     * 被打劫的情况 依赖dp[i - 2] + nums[i]
     * 不被打劫的情况依赖,最优的情况跟dp[i-1]是一致的，具体怎么打劫不管，但结果保证一样（这一点被用在follow-up）
     */
    public static int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max((i == 1 ? 0 : dp[i - 2]) + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public static int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int prev1 = 0; //i-2
        int prev2 = nums[0]; //i-1
        int cur = prev2; //i
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max((i == 1 ? 0 : prev1) + nums[i], prev2);
            prev1 = prev2;
            prev2 = cur;
        }
        return cur;
    }

    public static int rob3(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int prev1 = 0; //i-2
        int prev2 = nums[start]; //i-1
        int cur = prev2; //i
        for (int i = start + 1; i <= end; i++) {
            cur = Math.max((i == start + 1 ? 0 : prev1) + nums[i], prev2);
            prev1 = prev2;
            prev2 = cur;
        }
        return cur;
    }

    public static void main(String[] args) {

    }
}
