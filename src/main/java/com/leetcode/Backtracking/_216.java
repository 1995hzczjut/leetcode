package com.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 跟77 一摸一样。题目看错了只能用1-9 不是1-n
 *
 * @author Zhancong Huang
 * @date 10:16 2018/10/31
 */
public class _216 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), k, n, 1);
        return res;
    }

    private static void dfs(List<List<Integer>> list, List<Integer> tmp,  int k, int remain, int start) {
        if (remain == 0 && tmp.size() == k) {
            list.add(new ArrayList<>(tmp));
        }

        //回溯条件
        if (remain < 0 || tmp.size() > k) {
            return;
        }

        for (int i = start; i <= 9; ++i) {
            tmp.add(i);
            dfs(list, tmp, k, remain - i, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 9));
    }
}
