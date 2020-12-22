package com.leetcode.array;

/**
 * 股票系列问题(1)
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75924/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
 * https://www.jianshu.com/p/9fa0faff99da
 *
 * @author Zhancong Huang
 */
public class _121 {

    /**
     * 前置问题：2sum
     * 一个数据结构，数组也好，树也好，找两个值怎么怎么样，如果可以顺序遍历，都可以用这种思路
     * 即顺序遍历，动态维护当前点前的情况
     */
    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] <= min) {
                min = prices[i];
            }
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }

}
