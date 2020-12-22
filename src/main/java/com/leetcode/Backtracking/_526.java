package com.leetcode.Backtracking;

/**
 * 数组下标从1开始
 * 就是一个全排列问题
 * @author Zhancong Huang
 * @date 10:47 2018/10/31
 */
public class _526 {

    private static int count;

    public static int countArrangement(int N) {
        boolean[] visited = new boolean[N];
        dfs(N, visited, 1);
        return count;
    }


    private static void dfs(int N, boolean[] visited, int start) {
        if (start > N) {
            count++;
            return;
        }
        //one-indexed
        for (int i = 1; i <= N; i++) {
            if (!visited[i - 1] && (i % start == 0 || start % i == 0)) {
                visited[i - 1] = true;
                dfs(N, visited, start + 1);
                visited[i - 1] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(countArrangement(3));
    }
}
