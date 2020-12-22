package com.leetcode.dp;

/**
 * @author Zhancong Huang
 * @date 16:00 2019/1/29
 */
public class _714 {

    /**
     * 分析有误，看122 todo
     * 经典题目，需要记忆
     * 状态分析：
     * 今天手里有股票 依赖 昨天手里也有 或者 昨天没有今天才买
     * 最重要的是，hold[0] = -prices[0];
     *
     * 没有费率的情况下：
     * 重新定义利润很【关键】，买进还没有卖出，此时利润是负的
     * hold[i] = max(hold[i-1], sold[i-1] - price[i])//代表今天结束手里有股票情况下的最大利润
     * sold[i] = max(sold[i-1], hold[i-1] + price[i])//代表今天结束手里没有股票的最大利润
     * init:
     * hold[0]=-price[0] sold[0]=0
     */
    public int maxProfit(int[] prices, int fee) {
        int[] hold = new int[prices.length];
        int[] sold = new int[prices.length];
        hold[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            hold[i] = Math.max(hold[i - 1], sold[i - 1] - prices[i]);
            sold[i] = Math.max(sold[i - 1], hold[i - 1] + prices[i] - fee);
        }
        //想要利润最大，最后一天手里一定没有股票了
        return sold[sold.length -1];
    }


}
