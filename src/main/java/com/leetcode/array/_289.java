package com.leetcode.array;

/**
 * solve it in-place.题目要求找next state,意思就是假设原来的数组冻结，再去算下一个状态，那么先算的肯定会对后算的有影响
 * 又不能用额外的地方存。
 * 就用借助bitmap的思路，Int有32位。用编码解码的方式，
 * https://segmentfault.com/a/1190000003819277
 * 重点就是变啊没的思路，如果遍历前后值不变那没有影响
 * 如果1->0 如果不做改变，后边的值计算就有影响，用新的值3标识
 * 0->1 用4表示。
 * 最后再解码。总之思路最重要。
 * follow up:
 *
 * @author Zhancong Huang
 * @date 12:35 2019/1/22
 */
public class _289 {

    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = 0;
                if (i > 0) {
                    lives += board[i - 1][j] == 1 || board[i - 1][j] == 2 ? 1 : 0;
                }
                // 判断左边
                if (j > 0) {
                    lives += board[i][j - 1] == 1 || board[i][j - 1] == 2 ? 1 : 0;
                }
                // 判断下边
                if (i < m - 1) {
                    lives += board[i + 1][j] == 1 || board[i + 1][j] == 2 ? 1 : 0;
                }
                // 判断右边
                if (j < n - 1) {
                    lives += board[i][j + 1] == 1 || board[i][j + 1] == 2 ? 1 : 0;
                }
                // 判断左上角
                if (i > 0 && j > 0) {
                    lives += board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == 2 ? 1 : 0;
                }
                //判断右下角
                if (i < m - 1 && j < n - 1) {
                    lives += board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == 2 ? 1 : 0;
                }
                // 判断右上角
                if (i > 0 && j < n - 1) {
                    lives += board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == 2 ? 1 : 0;
                }
                // 判断左下角
                if (i < m - 1 && j > 0) {
                    lives += board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == 2 ? 1 : 0;
                }
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 3;
                } else if (board[i][j] == 1) {
                    if (lives < 2 || lives > 3) board[i][j] = 2;
                }
            }
        }
        // 解码
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] % 2;
            }
        }
    }
}
