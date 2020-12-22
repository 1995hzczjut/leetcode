package com.leetcode.dp;

/**
 *  新题
 * 1.上下左右走的，DFS
 * 2.DFS+概率。 一定要直接返回概率。改写DP也一样。
 *
 * @author Zhancong Huang
 * @date 21:34 2018/12/7
 */
public class _688 {

    int total = 0;
    int inside = 0;
    int[][] moves = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};

    public double knightProbability(int N, int K, int r, int c) {
        return helper1(N, K, r, c);
    }


    /**
     * 递归函数返回，从当前点，8个方向走，结束时还在盘内的概率。
     * 不能算总路径，再算概率
     * 跟helper1 最后total，inside是一样的。
     */
    private double helper1(int N, int K, int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= N) {
            return 0;
        }
        if (K == 0) {
            return 1;
        }
        //继续搜，8个方向
        double result = 0;
        for (int[] move : moves) {
            //加权概率
            result += (1d / 8) * helper1(N, K - 1, r + move[0], c + move[1]);
        }
        return result;
    }


    public double knightProbabilityDP(int N, int K, int r, int c) {
        //依赖降层DP状态。DP状态也应该直接表示概率.再算加权概率
        if (r < 0 || r >= N || c < 0 || c >= N) {
            return 0;
        }

        double dp[][][] = new double[N][N][K + 1];
        for (int k = 0; k <= K; k++) {
            for (int rr = 0; rr < N; rr++) {
                for (int cc = 0; cc < N; cc++) {
                    if (k == 0) {
                        dp[rr][cc][k] = 1;
                    }else {
                        for (int[] move : moves) {
                            int x = rr + move[0];
                            int y = cc + move[1];
                            //原来的为止1/8概率往任意方向走，如果下一次起始点在外面，那么从这个起始点的概率为0
                            dp[rr][cc][k] += (1d / 8) * ((x < 0 || x >= N || y < 0 || y >= N) ? 0 : dp[x][y][k-1]);
                        }
                    }
                }
            }
        }
        return dp[r][c][K];
    }

    public static void main(String[] args) {
        _688 s = new _688();
        System.out.println(s.knightProbabilityDP(3, 2, 0, 0));
        System.out.println(s.knightProbability(3, 2, 0, 0));
    }
}
