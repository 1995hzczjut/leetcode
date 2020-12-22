package com.leetcode.Graph;

import java.util.*;

/**
 * 在K点找到其他店的最大代价,图的最短路径问题
 * 节点注意从1开始的
 * https://leetcode.com/problems/network-delay-time/discuss/183873/Java-solutions-using-Dijkstra-FloydWarshall-and-Bellman-Ford-algorithm
 *
 * @author Zhancong Huang
 * @date 13:12 2019/6/11
 */
public class _743 {
    /**
     * Floyd–Warshall，多源最短路径
     * NULL表示无限大，更新时有点绕。
     * https://www.cnblogs.com/skywang12345/p/3711532.html
     */
    public int networkDelayTime1(int[][] times, int N, int K) {
        Integer[][] dp = new Integer[N][N];
        //初始话对角线和那些可以直接走到的
        for (int i = 0; i < N; i++) {
            dp[i][i] = 0;
        }
        for (int[] time : times) {
            dp[time[0] - 1][time[1] - 1] = time[2];
        }
        //N轮更新，每一轮从左到由，从上到下
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    Integer tmp = dp[i][k] == null || dp[k][j] == null ? null : dp[i][k] + dp[k][j];
                    if (dp[i][j] == null || tmp != null && tmp < dp[i][j]) {
                        dp[i][j] = tmp;
                    }
                }
            }
        }
        //组织结果
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            //有一个节点走不到，总耗时无限长
            if (dp[K - 1][i] == null) return -1;
            res = Math.max(res, dp[K - 1][i]);
        }
        return res;
    }

    /**
     * Bellman-Ford algorithm 单源的，787就是这么做的
     * 对每个{u,v,w},disTo[v] = Math.min(disTo[v], disTo[u] + w); 也是跟上面一样 更新N次
     * 两个FXX算法核心都是DP，要更新N次
     */
    public int networkDelayTime2(int[][] times, int N, int K) {
        Integer dp[] = new Integer[N];
        //init
        dp[K - 1] = 0;
        for (int i = 0; i < N; i++) {
            for (int[] edge : times) {
                int u = edge[0] - 1, v = edge[1] - 1, w = edge[2];
                Integer tmp = dp[u] == null ? null : dp[u] + w;
                if (dp[v] == null || tmp != null && tmp < dp[v]) {
                    dp[v] = tmp;
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (dp[i] == null) return -1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * Dijkstra
     * https://www.cnblogs.com/skywang12345/p/3711516.html
     */
    public int networkDelayTime3(int[][] times, int N, int K) {
        //就这个BFS要特殊处理
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        boolean[] visited = new boolean[N + 1];
        int[] minDis = new int[N + 1];
        Arrays.fill(minDis, Integer.MAX_VALUE);
        minDis[K] = 0;
        pq.offer(new int[]{0, K});
        int max = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currNode = curr[1];
            if (visited[currNode]) continue;
            visited[currNode] = true;
            int currDis = curr[0];
            max = currDis;
            N--;
            if (!graph.containsKey(currNode)) continue;
            for (int[] next : graph.get(currNode)) {
                if (!visited[next[0]] && currDis + next[1] < minDis[next[0]])
                    pq.offer(new int[]{currDis + next[1], next[0]});
            }
        }
        return N == 0 ? max : -1;
    }
}
