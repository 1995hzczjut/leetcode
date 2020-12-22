package com.leetcode;

import java.util.List;

/**
 * @author Zhancong Huang
 * @date 8:25 2019/7/17
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
