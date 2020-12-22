package com.leetcode.dfs;

import java.util.Arrays;

/**
 * 分两步：
 * 1）初始化，把周围没有0的1变为无限大
 * 2）从1出发搜索
 * 总体难度较大，思路非常有意义
 *
 * @author Zhancong Huang
 * @date 21:44 2019/7/25
 */
public class _542 {

    int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }
        //把周围没有直接0接触的距离变为NAN，这样得到的matrix里面0，1正好符合题意
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1 && !hasZeroNearby(matrix, i, j)) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        //从1触发，此时1代表距离0最近的距离，然后四个方向深搜。这里遇到0，1应该回溯，为什么？因为从这些点搜索会有更好的结果，
        //遇到非1，0，此时这个值代表之前计算的距离0最近的距离，此时应该判断时候有更近的结果，即维护一个全局最小值
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //为什么搜索的起点不是0？因为0001，01都是一样的结果，没法搜
                //为什么不从非0开始？这样浪费时间
                if (matrix[i][j] == 1) {
                    helper(matrix, i, j, 1);
                }
            }
        }
        return matrix;
    }

    /**
     * @param distant 此点到起点对应的的0的距离
     */
    private void helper(int[][] matrix, int i, int j, int distant) {
        if (!isInBound(matrix, i, j)
                || matrix[i][j] < distant) { //代表从这个点搜索有更好的结果，那为什么不搜呢，因为它的起点搜过了
            return;
        }
        matrix[i][j] = distant;
        //继续搜
        for (int[] dir : dirs) {
            int newI = i + dir[0], newJ = j + dir[1];
            helper(matrix, newI, newJ, distant + 1);
        }
    }

    private boolean hasZeroNearby(int[][] matrix, int i, int j) {
        for (int[] dir : dirs) {
            int newI = i + dir[0], newJ = j + dir[1];
            if (isInBound(matrix, newI, newJ) && matrix[newI][newJ] == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean isInBound(int[][] matrix, int i, int j) {
        //等号漏写了
        return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new _542().updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}})));
    }
}
