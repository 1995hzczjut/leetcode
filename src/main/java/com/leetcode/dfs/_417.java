package com.leetcode.dfs;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 开始的做法是联想岛问题，从每一个点向四个方向搜索，但实现很复杂，效率也不高
 * 正确做法，从四个边上的点搜索，此时水往高处流。这样如果流经的途中的每个点，
 * 水往低处流时都能流到边上。复杂的大大降低。
 * 跟岛问题很相似，但又不一样
 *
 * @author Zhancong Huang
 * @date 12:52 2019/7/21
 */
public class _417 {

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return Collections.emptyList();
        }

        int m = matrix.length, n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        //从左上角出发
        for (int i = 0; i < m; i++) {
            helper(matrix, i, 0, Integer.MIN_VALUE, pacific);
            helper(matrix, i, n - 1, Integer.MIN_VALUE, atlantic);
        }
        //从右下角出发
        for (int i = 0; i < n; i++) {
            helper(matrix, 0, i, Integer.MIN_VALUE, pacific);
            helper(matrix, m - 1, i, Integer.MIN_VALUE, atlantic);
        }
        //整理返回
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> tmp =new LinkedList<>();
                    tmp.add(i);
                    tmp.add(j);
                    result.add(tmp);
                }
            }
        }
        return result;
    }


    /**
     * 从一个点触发，把它能到达的点全部标记。
     * 注意这里到达一个点时，它的合法性还没确认
     */
    private void helper(int[][] matrix, int x, int y, int preHeight, boolean[][] reachable) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length
                || reachable[x][y] //已经看过了
                || matrix[x][y] < preHeight) {
            return;
        }
        reachable[x][y] = true;
        for (int[] dir : dirs) {
            helper(matrix, x + dir[0], y + dir[1], matrix[x][y], reachable);
        }
    }
}
