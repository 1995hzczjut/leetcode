package com.leetcode.Graph;

import java.util.List;

/**
 * @author Zhancong Huang
 * @date 17:03 2019/7/26
 */
public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
