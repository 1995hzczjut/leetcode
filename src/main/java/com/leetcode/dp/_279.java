package com.leetcode.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 背包问题：包无限使用，问最少需要多少包能正好装下物资。
 * 先考虑递归做法，递归方法的返回值这里是包的最少数量。然后，循环选取一个包，物资减少了，然后递归调用。
 * 要是问多少种方案，则改掉返回值。
 *
 * 改DP依靠上面的改。
 *
 * @author Zhancong Huang
 * @date 22:10 2018/11/23
 * @see _322
 */
public class _279 {

    /**
     * 用背包问题的角度的递归解法。
     * 每次拿一个包看看，之后调用递归。注意拿的时候，要看物资是否大于等于包的容量。
     * 类似包容量5，物资3就装不进去
     */
    public int numSquaresByPackage(int n) {
        return helper(n, findSquareList(n));
    }

    /**
     * 这个做法TLE，因为同一个weight计算了很多次
     */
    private int helper(int weight, final int[] nums) {
        if (weight <= 0) return 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (weight >= nums[i]){
                result = Math.min(result, 1 + helper(weight - nums[i], nums));
            }
        }
        return result;
    }

    private int[] findSquareList(int n) {
        if (n == 0) return new int[1];
        List<Integer> result = new LinkedList<>();

        int num = 1;
        while (num * num <= n) {
            result.add(num * num);
            num++;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }



    /**
     * DP。照着上面的改
     */
    public int numSquaresDP(int n) {
        int[] packages = findSquareList(n);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int pkgIdx = 0; pkgIdx < packages.length; pkgIdx++) {
                if (i >= packages[pkgIdx]){
                    dp[i] = Math.min(dp[i] , 1 + dp[i - packages[pkgIdx]]);
                }
            }
        }
        return dp[n];
    }

}
