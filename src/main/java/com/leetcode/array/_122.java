package com.leetcode.array;

/**
 * 股票系列问题(2)
 * hold，sold 理解成今天结束空仓，满仓状态。只是代表仓库状态！！！不代表具体操作。
 * 处于空仓状态不一定指今天空仓，也可能是上一次买空仓，至今未买入。
 * 第i天处于满仓状态，其利益最大值依赖 前一天处于满仓状态的最大值 或者 前一天处于空仓状态（不一定在前一天正好清仓），今天买进的利益最大值
 * 第i天处于空仓状态同理
 * 关键hold[i]，sold[i] 并不意味着第i天发生操作，再309题中至关重要
 * @author Zhancong Huang
 * @date 13:08 2019/1/10
 */
public class _122 {

    /**
     * DP做法，与714 一样的
     * 重点在于重新定义利润： 买入不卖，利润就是负的
     * 注意返回值，没必要遍历取最大
     */
    public int maxProfit_DP(int[] prices) {
        if (prices.length == 0) return 0;
        int[] hold = new int[prices.length];
        int[] sold = new int[prices.length];
        hold[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            hold[i] = Math.max(hold[i - 1], sold[i - 1] - prices[i]);
            sold[i] = Math.max(sold[i - 1], hold[i - 1] + prices[i]);
        }
        return sold[sold.length - 1];
    }

    /**
     * 优化空间
     */
    public int maxProfit_DP1(int[] prices) {
        if (prices.length == 0) return 0;
        int holdPrev = 0, soldPrev = 0, holdNow = 0, soldNow = 0;
        holdPrev = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            holdNow = Math.max(holdPrev, soldPrev - prices[i]);
            soldNow = Math.max(soldPrev, holdPrev + prices[i]);
            holdPrev = holdNow;
            soldPrev = soldNow;
        }
        return soldNow;
    }

}
