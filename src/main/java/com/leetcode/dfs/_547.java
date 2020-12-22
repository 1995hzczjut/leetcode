package com.leetcode.dfs;

/**
 * @author Zhancong Huang
 * @date 22:32 2019/7/25
 */
public class _547 {
    /**
     * 经典题目：
     * 跟200不一样，这题通过找一个人的所有直接/间接朋友，并标记防止重复找。
     * 一个人只能有一个朋友圈，间接朋友的寻找就是递归的过程。
     *
     * 问题初看跟岛问题重复，其实不一样，这是一个邻接矩阵，是关于对角线堆成的，一定有什么优化点。
     * 就是visited数组。
     * 或者说，换个角度看,从一个人出发，查看他所在的朋友圈的所有人，然后标记下，不在搜索他的朋友，因为它的朋友必然属于之前那个朋友。
     * 特别注意的是一个人也是一个朋友圈，类似于LC200一个1也是岛.一个人只有一个朋友圈
     */
    public int findCircleNum(int[][] M) {
        if (M.length == 0 || M[0].length == 0) {
            return 0;
        }

        int result = 0;
        boolean[] visited = new boolean[M.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                result++;
                //搜索，把属于i的朋友对应的visited去标记下
                helper(M, visited, i);
            }
        }
        return result;
    }

    /**
     * 跟岛问题的Infant思路也不一样，直接查邻接矩阵
     * 牢记visited值true代表已经确认这过个人在的朋友圈了，一个人只有一个朋友圈。
     */
    private void helper(int[][] M, boolean[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (!visited[j] && M[i][j] == 1) {
                //j是i的直接朋友
                visited[j] = true;
                //把j的直接朋友也标记下
                helper(M, visited, j);
            }
        }
    }
}
