package com.leetcode.dp;


/**
 * 坑在递归终止条件
 * 注意N=0，（i，j）边界情况下DP值。牢记DP代表的是方案，没有步数但是起点在外面 也是一种方案
 *
 * @author Zhancong Huang
 * @date 23:01 2018/12/4
 */
public class _576 {

    private int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private int mod = 1000000000 + 7;

    //memo
    public int findPaths(int m, int n, int N, int i, int j) {
        //Arrays.fill 只能填充一维数组
        long[][][] memo = new long[m][n][N + 1];
        for (int ii = 0; ii < m; ii++) {
            for (int jj = 0; jj < n; jj++) {
                for (int kk = 0; kk < N + 1; kk++) {
                    memo[ii][jj][kk] = -1;
                }
            }
        }
        return (int) (helper(m, n, N, i, j, memo) % mod);
    }

    /**
     * 边界值恶心。
     * 起点在外面，不管N跟0关系，都是1.因为问的是方案数
     * 起点在里面，则N=0的话，方案数为0
     */
    private long helper(int m, int n, int N, int i, int j, long[][][] memo) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 1;
        }
        if (N == 0) {
            return 0;
        }
        if (memo[i][j][N] != -1) {
            return memo[i][j][N];
        }
        memo[i][j][N] = 0;
        for (int[] dir : dirs) {
            //memo[i][j][N] += memo[i + dir[0]][j + dir[1]][N - 1];
            memo[i][j][N] = (memo[i][j][N] + helper(m, n, N - 1, i + dir[0], j + dir[1], memo)) % mod;
        }
        return memo[i][j][N];
    }



    public int findPaths1(int m, int n, int N, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 1;
        }

        long[][][] dp = new long[m][n][N + 1];

        for (int k = 0; k <= N; k++) {
            for (int p = 0; p < m; p++) {
                for (int q = 0; q < n; q++) {
                    if (k == 0) {
                        dp[p][q][k] = 0;
                    } else {
                        for (int[] dir : dirs) {
                            int x = p + dir[0];
                            int y = q + dir[1];
                            dp[p][q][k] = (dp[p][q][k] + ((x < 0 || x >= m || y < 0 || y >= n) ? 1 : dp[x][y][k - 1])) % mod;
                        }
                    }
                }

            }
        }
        return (int) dp[i][j][N];

    }

    public static void main(String[] args) {
        _576 s = new _576();
        System.out.println(s.findPaths1(1, 3, 3, 0, 1));
    }
}
