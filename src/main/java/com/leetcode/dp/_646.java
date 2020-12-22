package com.leetcode.dp;

import java.util.Arrays;
import java.util.Comparator;


public class _646 {

    /**
     * LIS类型
     */
    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[0]));
        int[] dp = new int[pairs.length];
        int res = 1;
        //隐含意思，单个pair也符合要求
        Arrays.fill(dp, 1);
        for (int i = 1; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(findLongestChain(a));
    }

}
