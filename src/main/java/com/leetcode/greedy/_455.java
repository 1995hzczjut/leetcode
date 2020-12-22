package com.leetcode.greedy;

import java.util.Arrays;

/**
 * 贪心：用最小的代价满足所有孩子
 *
 * @author Zhancong Huang
 * @date 20:35 2018/11/13
 */
public class _455 {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0, cur = 0; //cur g数组的指针
        for (int i = 0; i < s.length; i++) {
            if(s[i] >= g[cur]){
                res++;
                cur++;
                if(cur >= g.length) return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
