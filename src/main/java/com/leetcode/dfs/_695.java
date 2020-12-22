package com.leetcode.dfs;

/**
 * 严格遵守combination问题格式，dfs第一个变量一定是走到一个点，把这个点考虑进去了。
 * 这里跟word search一样，最外面起点的时候已经有一个点进去了，
 * 这是后别忘记对这个点也要改变used[i]，增删tmp。当然这题里没有。
 *
 * @author Zhancong Huang
 * @date 19:39 2019/8/15
 */
public class _695 {

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 2;
                    int[] maxArea = new int[1];
                    maxArea[0] = 1;
                    dfs(maxArea, grid, i, j);
                    res = Math.max(res, maxArea[0]);
                }
            }
        }
        return res;
    }

    /**
     * 改写ii的地方老是写成i
     */
    private void dfs(int[] maxArea, int[][] grid, int i, int j) {
        int a= 0;
        //不需要对maxArea校验
        for (int[] dir : dirs) {
            int ii = i + dir[0], jj = j + dir[1];
            if (ii < 0 || ii >= grid.length || jj < 0 || jj >= grid[0].length
                    || grid[ii][jj] != 1) {
                continue;
            }
            grid[ii][jj] = 2;
            maxArea[0]++;
            dfs(maxArea, grid, ii, jj);
        }
    }
}
