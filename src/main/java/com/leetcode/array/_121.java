package com.leetcode.array;

/**
 * ��Ʊϵ������(1)
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75924/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
 * https://www.jianshu.com/p/9fa0faff99da
 *
 * @author Zhancong Huang
 */
public class _121 {

    /**
     * ǰ�����⣺2sum
     * һ�����ݽṹ������Ҳ�ã���Ҳ�ã�������ֵ��ô��ô�����������˳�������������������˼·
     * ��˳���������̬ά����ǰ��ǰ�����
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
