package com.leetcode.dp;

import java.util.Arrays;

/**
 * @author Zhancong Huang
 * @date 21:58 2018/12/10
 */
public class _787 {

    /**
     * 单源最短路径的floyd算法：
     * dp[i][j]代表i次stops内 从src到j点花费的最小值
     * 假设p1,p2,p3...指向j点。那么dp[i][j]依赖dp[i-1][pn]+pn到j的代价 中的最小值。最小值-》初始化为Integer.MAX_VALUE
     * 所以画在图里就是二维矩阵一层依赖它的上一层。
     * 所以要看i=0的dp. i=0代表一次stop也没有，只有src能直接到的点才能到，其他都到不了，代价无穷大。
     * 对应flights的f的起点正好在src，dp才有值
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        long[][] dp = new long[K + 1][n];
        for (long[] d : dp) Arrays.fill(d, Integer.MAX_VALUE);
        for (int i = 0; i < K + 1; i++) {
            //这步漏了很难察觉
            dp[i][src] = 0;
            for (int[] f : flights) {
                dp[i][f[1]] = Math.min(dp[i][f[1]], i != 0 ? (dp[i - 1][f[0]] + f[2]) : (src == f[0] ? f[2] : Integer.MAX_VALUE));
            }
        }
        return dp[K][dst] == Integer.MAX_VALUE ? -1 : (int) dp[K][dst];
    }

}
