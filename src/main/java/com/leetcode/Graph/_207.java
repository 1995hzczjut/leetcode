package com.leetcode.Graph;

import java.util.*;

/**
 * 这个问题就是有向图的环检测问题，有向图没有环可以走到任何节点（起点不做规定）
 * todo：改成79的格式
 *
 * @author Zhancong Huang
 * @date 20:38 2019/7/26
 */
public class _207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //常规套路，key是起点，value是可到达的点，即上完key代表的课后能上的课。
        Map<Integer, List<Integer>> graph = new HashMap<>(numCourses);
        for (int[] prerequisite : prerequisites) {
            graph.putIfAbsent(prerequisite[1], new LinkedList<>());
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            //这里最好跟79一样
            if (!helper(i, graph, visited)){
                return false;
            }
        }
        return true;
    }

    /**
     * 这个DFS跟之前的combination不一样，遍历到一个点自己没被看过，所以visited状态变量变更写在外面.
     * 整体思路跟combination类似
     */
    private boolean helper(int course, Map<Integer, List<Integer>> graph, boolean[] visited){
        if (visited[course]){
            return false;
        }
        visited[course] = true;
        if (graph.get(course) != null){
            //这里如果上完一节课，没有其他课好上，会出现NPE，此时应该直接返回true
            for (int next : graph.get(course)){
                //改成79的标准的话，会在这里判断能不能走到，即used是否为true，true的话就遇到环了，退出。
                if (!helper(next, graph, visited)){
                    return false;
                }
            }
        }
        //切换另一个子图时候visited状态都要清空
        visited[course] = false;
        return true;
    }

}
