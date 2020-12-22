package com.leetcode.array;

/**
 * 空间要求In-place，把第一行第一列作为记录的地方。拿第一行第一列自己本身的信息丢失了，又需要额外的变量记录
 * 分析最重要
 *
 * @author Zhancong Huang
 * @date 22:09 2019/1/16
 */
public class _73 {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        boolean flag_row = false;
        boolean flag_col = false;
        //遍历整个数组，设置第一行第一列，和两个标志位
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) flag_row = true;
                    if (j == 0) flag_col = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        //再次遍历把，非第一行第一列的设置了
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        //设置第一行第一列
        if (flag_row) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if (flag_col) {
            for (int i = 1; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        new _73().setZeroes(new int[][]{{1, 0, 3}});
    }
}
