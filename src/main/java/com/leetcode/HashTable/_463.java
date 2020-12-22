package com.leetcode.HashTable;

public class _463 {

    /**
     * 思路：
     * 一个岛有4个边，如果左右两边都有1，代表有两个边重复，重复不贡献result。这样遍历明显有重复
     * 所以向一个边看就行。
     * 而且本来做法，在边界不好弄，要单独讨论
     * 遍历矩阵是向右，向下遍历的，所以只向右，向下看
     */
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        int repeat = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    if (j != grid[0].length - 1 && grid[i][j + 1] == 1) {
                        //最右边那个数靠右的边必定不会被重复
                        repeat++;
                    }
                    if (i != (grid.length - 1) && grid[i + 1][j] == 1) {
                        //最右边那个数靠右的边必定不会被重复
                        repeat++;
                    }
                }

            }
        }
        //一条边被重复，比没有重复少了两个值
        return 4 * count - repeat * 2;

    }

    public static void main(String[] args) {

    }

}
