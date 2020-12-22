package com.leetcode.Graph;

import com.sun.applet2.preloader.event.InitEvent;

import java.util.*;

/**
 * 在207基础上把图的遍历出来。之前说过有向图没有环就是一棵树。遍历参考树
 * 之前visited仅有t/f两种状态，现在是不够的，子图切换到另一个子图时，另一个图visited=false,
 * 即合法的（这也是树的特性，树的两个子树绝对不会有交集的，所以遍历的时候不会碰到，而图不一样了，
 * 207里可能遇到另一个子图，这个子图里面确认过没有环，但现在还是要再遍历，这道题就恶心再这里），
 * 但现在不能保存，因为会重复.所以visited需要三个值：
 * 0代表一次都没看过，1代表当前子图正在遍历的，遇到这个要立即返回false
 * 2代表上面说的特殊情况，当前节点已经遍历过了，且加入栈了，应该直接返回true
 *
 * @author Zhancong Huang
 * @date 15:05 2019/7/31
 */
public class _210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>(numCourses);
        for (int[] prerequisite : prerequisites) {
            graph.putIfAbsent(prerequisite[1], new LinkedList<>());
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        int[] visited = new int[numCourses];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (!helper(i, graph, visited, stack)) {
                return new int[0];
            }
        }
        int i = 0;
        int[] result = new int[numCourses];
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }

    /**
     * 这个DFS跟之前的combination不一样，遍历到一个点自己没被看过，所以visited状态变量变更写在外面.
     * 整体思路跟combination类似
     */
    private boolean helper(int course, Map<Integer, List<Integer>> graph, int[] visited, ArrayDeque<Integer> stack) {
        if (visited[course] == 2) {
            //假设图入口root，下两个子图A,B，A,B交集。走到这一步说明，B图便利到A的节点了
            //也说明A图走完了，且无环，因此从这个course出发绝对不会生成环，因此B图在这里应该回溯
            //207那种做法是有问题，没有提前回溯
            return true;
        }
        if (visited[course] == 1){
            return false;
        }
        visited[course] = 1;
        if (graph.get(course) != null) {
            for (int next : graph.get(course)) {
                if (!helper(next, graph, visited, stack)) {
                    return false;
                }
            }
        }
        //遍历完一个子图后，全部变为2状态
        visited[course] = 2;
        stack.push(course);
        return true;
    }
}
