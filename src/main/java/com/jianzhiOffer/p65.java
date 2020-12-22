package com.jianzhiOffer;

import com.leetcode.Backtracking._79;

/**
 *
 * @see _79
 * @author Zhancong Huang
 * @date 18:34 2019/4/30
 */
public class p65 {

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix.length == 0 || str.length == 0) {
            return false;
        }

        char[][] realMatrix = new char[rows][cols];
        int m = 0;
        boolean[][] used = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                realMatrix[i][j] = matrix[m++];
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (realMatrix[i][j] == str[0]) {
                    used[i][j] = true;
                    if (helper(realMatrix, i, j, used, str, 1)) return true;
                    used[i][j] = false;
                }
            }
        }
        return false;
    }


    private boolean helper(char[][] realMatrix, int x, int y, boolean[][] used, char[] str, int matchedLen) {
        if (matchedLen == str.length) return true;
        for (int[] dir : dirs) {
            int xx = x + dir[0], yy = y + dir[1];
            if (xx < 0 || xx >= realMatrix.length || yy < 0 || yy >= realMatrix[0].length || used[xx][yy] || realMatrix[xx][yy] != str[matchedLen])
                continue;
            used[xx][yy] = true;
            if (helper(realMatrix, xx, yy, used, str, matchedLen + 1)) return true;
            used[xx][yy] = false;
        }
        return false;
    }
}
