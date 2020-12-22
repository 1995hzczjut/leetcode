package com.leetcode.dp;

/**
 * 子问题。假设有这样一个数组 111100111001  给出任意额一个数其左边最多有几个1（含自己）
 * 正确做法ON就可以了。从左往右遍历。
 * 现在4个方向，等于4次DP
 * @author Zhancong Huang
 * @date 23:20 2018/12/9
 */
public class _764 {

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        //dp是从自己开始算，自己是0，永远是0.
        int[][] dp = new int[N][N];
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = 1;
            }
        }
        for (int[] mine : mines) {
            dp[mine[0]][mine[1]] = 0;
        }

        //到这一步。dp就是题目图给出的矩阵。Mines是零的坐标
        //left。count注意清0
        int count;
        for (int i = 0; i < N; i++) {
            count=0;
            for (int j = 0; j < N; j++) {
                if (dp[i][j] == 0) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = count;
            }
        }

        //right
        for (int i = 0; i < N; i++) {
            count=0;
            for (int j = N - 1; j >= 0; j--) {
                if (dp[i][j] == 0) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = Integer.min(dp[i][j], count);
            }
        }

        //down
        for (int j = 0; j < N; j++) {
            count = 0;
            for (int i = 0; i < N; i++) {
                if (dp[i][j] == 0) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = Integer.min(dp[i][j], count);
            }
        }

        //up
        for (int j = 0; j < N; j++) {
            count = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (dp[i][j] == 0) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = Integer.min(dp[i][j], count);
                result = Integer.max(result, dp[i][j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new _764().orderOfLargestPlusSign(5, new int[][]{{4,2}}));
    }
}
