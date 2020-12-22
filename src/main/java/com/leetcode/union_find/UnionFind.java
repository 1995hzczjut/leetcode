package com.leetcode.union_find;

import java.util.Arrays;

/**
 * 简单做法：
 * https://mp.weixin.qq.com/s/50QN956P6Udpo4AKlWfeew?
 * 按rank合并
 * https://leetcode.com/problems/friend-circles/discuss/101336/Java-solution-Union-Find
 * 算法思想：
 * 左程云视频 基础7 中间的播放进度
 *
 * @author Zhancong Huang
 * @date 16:16 2019/11/15
 */
public class UnionFind {


    /**
     * 代表集合数量，一开始肯定最大值，发现能合并就减1
     */
    private int count = 0;

    /**
     * 代表当前节点的父节点，-1代表自己是这个集合的root节点.一个集合看成一个多叉树
     */
    private int[] parent;

    /**
     * 看成树的高度。合并的时候应该高度小的合并到高度大的去，否则容易把树退化成链表
     * 增大时间复杂度。
     * 初始都为0，高度小的合并到高度大的不会增加高度，所以rank不用变。但是两个树高度一样合并
     * 必然会高度增加1
     */
    private int[] rank;

    public void makeSet(int n) {
        count = n;
        parent = new int[n];
        Arrays.fill(parent, -1);
        rank = new int[n];
    }


    public int findSet(int idx) {
        if (parent[idx] == -1) return idx;
        //path compression
        parent[idx] = findSet(parent[idx]);
        return parent[idx];
    }

    public void union(int x, int y) {
        int xRoot = findSet(x), yRoot = findSet(y);
        //已经在同一个集合
        if (xRoot == yRoot) return;
        if (rank[xRoot] > rank[yRoot]){
            parent[yRoot] = xRoot;
        }else {
            parent[xRoot] = yRoot;
            if (rank[xRoot] == rank[yRoot]) {
                rank[yRoot]++;
            }
        }
        //关键，两个集合合并，总的数量必定减一
        count--;
    }


    public int count(){
        return count;
    }
}
