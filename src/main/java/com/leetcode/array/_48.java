package com.leetcode.array;

import java.util.Arrays;

/**
 *
 * @author Zhancong Huang
 * @date 18:13 2019/1/16
 */
public class _48 {
    /**
     * clockwise rotate
     * first reverse up to down, then swap the symmetry
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
     */
    public void rotate(int[][] matrix) {
        //reverse
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                swap(matrix, i, j, matrix.length - i - 1, j);
            }
        }

        //flip
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    private void swap(int[][] matrix, int i, int j, int i1, int j1) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[i1][j1];
        matrix[i1][j1] = tmp;
    }


}
