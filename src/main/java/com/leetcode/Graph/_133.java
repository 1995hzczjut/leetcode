package com.leetcode.Graph;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author Zhancong Huang
 * @date 17:03 2019/7/26
 */
public class _133 {

    /**
     * DFS
     */
    public Node cloneGraph(Node node) {
        return cloneGraphDFS(node, new HashMap<>(256));
    }

    /**
     * 联想：怎么拷贝一棵树。节点new一个，然后递归调用子节点。树是图的子集，图里也是一样的，new节点，递归调用neighbors
     * 但是树只能往下走，图有很多走的方向，可能会走到之前的节点，以前就是visited数组解决，这里要变一下。
     * 遍历到之前走过的节点，应该直接拿之前节点的拷贝节点。
     * 特别注意：map put要发生在递归调用之前，很像Spring的循环依赖解决
     */
    private Node cloneGraphDFS(Node node, Map<Integer, Node> map) {
        if (map.containsKey(node.val)) return map.get(node.val);
        Node result = new Node(node.val, new LinkedList<>());
        //这个应该在递归调用前执行
        map.put(node.val, result);
        for (Node next : node.neighbors) {
            result.neighbors.add(cloneGraphDFS(next, map));
        }
        return result;
    }


    /**
     * BFS.
     * 注意map放新节点，queue因为要搜只能放老的节点。这里同样也借助JAVA的引用机制
     */
    public Node cloneGraphBFS(Node node) {
        if (node == null) return null;
        Map<Integer, Node> map = new HashMap<>(256);
        Queue<Node> queue = new LinkedList<>();
        Node result = new Node(node.val, new LinkedList<>());
        //map里value是老的节点
        map.put(result.val, result);
        //队列里放老的节点
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node polled = queue.poll();
            for (Node child : polled.neighbors) {
                Node newNode;
                if (map.containsKey(child.val)) {
                    newNode = map.get(child.val);
                } else {
                    newNode = new Node(child.val, new LinkedList<>());
                    map.put(newNode.val, newNode);
                    queue.offer(child);
                }
                map.get(polled.val).neighbors.add(newNode);
            }
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
