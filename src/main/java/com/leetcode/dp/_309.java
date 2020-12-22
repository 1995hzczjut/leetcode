package com.leetcode.dp;

import com.leetcode.array._122;

/**
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * 与122本质区别是，122dp数组表示满仓，空仓状态hold[i] = Math.max(hold[i - 1], sold[i - 1] - prices[i]);
 * 里sold[i - 1] - prices[i] 代表今天买入操作的【可能】不符合上面的要求。
 *
 * @author Zhancong Huang
 * @date 15:53 2019/5/12
 * @see _122
 */
public class _309 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[] hold = new int[prices.length];
        int[] sold = new int[prices.length];
        int[] coolDown = new int[prices.length];

        hold[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //122直接用sold[i-1],这个可能就在当天卖掉，那么今天就不能买
            hold[i] = Math.max(hold[i - 1], coolDown[i - 1] - prices[i]);
            sold[i] = Math.max(sold[i - 1], hold[i - 1] + prices[i]);
            //coolDown 代表今天结束是空仓，但是不是在今天卖掉的，依赖昨天的
            //sold[i-1]其实包含coolDown[i-1],两个状态在i-1都是空仓状态，但是第一个可能发出卖出行为，第二个不会发生卖出行为
            coolDown[i] = Math.max(sold[i - 1], coolDown[i - 1]);
        }
        return Math.max(sold[sold.length - 1], coolDown[prices.length - 1]);
    }
}
