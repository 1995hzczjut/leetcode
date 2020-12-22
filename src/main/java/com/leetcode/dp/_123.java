package com.leetcode.dp;

/**
 * 这种做法可以推广到k次交易。LC121是
 * 122 是任意次。
 *
 * @author Zhancong Huang
 * @date 16:21 2019/5/12
 */
public class _123 {
    public static int maxProfit(int[] prices) {
        int min1 = Integer.MAX_VALUE;
        int profit1 = 0;
        int min2 = Integer.MAX_VALUE;
        int profit2 = 0;
        for (int i = 0; i < prices.length; i++) {
            //下面两行是121单次交易的解法。
            min1 = Math.min(min1, prices[i]);
            profit1 = Math.max(profit1, prices[i] - min1);
            //处理第二次交易，同理，第一次交易能拿到的最大利益固定了，第二次交易的时候同样尽力在最低点买进
            //不过有了profit1的缓冲
            min2 = Math.min(min2, prices[i] - profit1);
            profit2 = Math.max(profit2, prices[i] - min2);
            System.out.println(min1 + " " + profit1 + " " + min2 + " " + profit2);
        }
        return profit2;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }
}
