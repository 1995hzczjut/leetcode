package com.leetcode.BinarySearch;

/**
 * @author Zhancong Huang
 * @date 12:13 2018/10/31
 */
public class _74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 ) {
            return false;
        }
        int x = 0;
        int y = matrix[0].length - 1;
        while (0 <= x && x < matrix.length && y >= 0 && y < matrix[0].length) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] < target) {
                x++;
                continue;
            }
            if (matrix[x][y] > target) {
                y--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] m = {{1}};
        int t = 2;
        System.out.println(searchMatrix(m, t));
    }
}
