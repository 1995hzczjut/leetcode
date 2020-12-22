package com.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  permutation系列。
 * @author Zhancong Huang
 * @date 9:38 2018/10/31
 */
public class _77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        helper(res, new LinkedList<>(), n, k, 1);
        return res;
    }

    private void helper( List<List<Integer>> res , List<Integer> tmp, int n, int k, int start){
        if (tmp.size() == k){
            res.add(new LinkedList<>(tmp));
        }
        for (int i = start; i <= n; i++) {
            tmp.add(i);
            helper(res, tmp, n, k, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

}
