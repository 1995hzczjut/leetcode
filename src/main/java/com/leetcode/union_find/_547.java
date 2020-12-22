package com.leetcode.union_find;

/**
 * 简单做法：
 * https://mp.weixin.qq.com/s/50QN956P6Udpo4AKlWfeew?
 * 按rank合并
 * https://leetcode.com/problems/friend-circles/discuss/101336/Java-solution-Union-Find
 * 暴力搜索复杂度N^N，并查集N^3
 *
 * @author Zhancong Huang
 * @date 15:52 2019/11/15
 */
public class _547 {

    public int findCircleNum(int[][] M) {
        UnionFind unionFind = new UnionFind();
        unionFind.makeSet(M.length);
        for (int i = 0; i < M.length; i++) {
            //j从i+1开始 省一半时间
            for (int j = i + 1; j < M[0].length; j++) {
                if (M[i][j] == 1){
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.count();
    }

}
