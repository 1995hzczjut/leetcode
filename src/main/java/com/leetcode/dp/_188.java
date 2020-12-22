package com.leetcode.dp;

import java.util.Arrays;

/**
 * @author Zhancong Huang
 * @date 18:47 2019/5/12
 * @see _123
 */
public class _188 {

    /**
     * 空间没优化 todo
     */
    public static int maxProfit(int k, int[] prices) {
        int[] min = new int[k + 1];
        int[] profit = new int[k + 1];
        Arrays.fill(min, Integer.MAX_VALUE);
        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                min[j] = Math.min(min[j], prices[i] - profit[j - 1]);
                profit[j] = Math.max(profit[j], prices[i] - min[j]);
            }
        }
        return profit[k];
    }




    public static void main(String[] args) {
        System.out.println( maxProfit(2, new int[]{3,3,5,0,0,3,1,4}));

    }
}
