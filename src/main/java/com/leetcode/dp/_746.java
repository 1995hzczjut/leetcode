package com.leetcode.dp;

/**
 * @author Zhancong Huang
 * @date 12:29 2019/8/16
 */
public class _746 {

    /**
     * 题目： reach the top of the floor 翻译成floor之上。即10, 15, 20光到20是不够的，要到20之后。否则10的代价就够了
     * dp数组多一位就可以了
     */
    public static int func1(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);

        }
        return dp[cost.length];
    }


    public static void main(String[] args) {
        int cost[] = {10, 15, 20};
        System.out.println(func1(cost));

    }

}
