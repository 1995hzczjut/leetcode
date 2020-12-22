package com.leetcode.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Zhancong Huang
 * @date 19:50 2019/7/20
 */
public class _200 {

    public int numIslands(char[][] grid) {
        char[][] newGrid = grid;
        int count = 0;

        for (int i = 0; i < newGrid.length; i++) {
            for (int j = 0; j < newGrid[0].length; j++) {
                if (newGrid[i][j] - '1' == 0) {
                    count++;
                    infant(i,j,newGrid);
                }
            }

        }

        return count;
    }

    private void infant(int i, int j, char[][] newGrid) {
        if(i <0 || i >= newGrid.length || j < 0 || j >= newGrid[0].length || newGrid[i][j] - '1' != 0){
            return;
        }
        newGrid[i][j] = 2;
        infant(i,j+1,newGrid);
        infant(i,j-1,newGrid);
        infant(i-1,j,newGrid);
        infant(i+1,j,newGrid);
    }

    /**
     * 回顾BFS模板，一定是子节点合法才能加进来!!!
     * 就像树的层遍历，NULL节点一定不能加进来
     */
    public void infant1(int i, int j, char[][] newGrid) {
        int n = newGrid.length;
        int m = newGrid[0].length;
        newGrid[i][j] = '0';
        Queue<Integer> queue = new LinkedList<>();
        //构建数组保存坐标也是OK的
        queue.offer(i * m + j);
        while (!queue.isEmpty()) {
            int code = queue.poll();
            int x = code / m;
            int y = code % m;
            //回顾BFS模板，一定是子节点合法才能加进来
            //上
            if (x > 0 && newGrid[x - 1][y] == '1') {
                queue.offer((x - 1) * m + y);
                newGrid[x - 1][y] = '0';
            }
            //下
            if (x < newGrid.length - 1 && newGrid[x + 1][y] == '1') {
                queue.offer((x + 1) * m + y);
                newGrid[x + 1][y] = '0';
            }
            //上
            if (y > 0 && newGrid[x][y - 1] == '1') {
                queue.offer(x * m + y - 1);
                newGrid[x][y - 1] = '0';
            }
            //上
            if (y < newGrid[0].length - 1 && newGrid[x][y + 1] == '1') {
                queue.offer(x * m + y + 1);
                newGrid[x][y + 1] = '0';
            }

        }
    }

    public static void main(String[] args) {
        _200 solution = new _200();
        char[][] a = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(solution.numIslands(a));
    }
}
