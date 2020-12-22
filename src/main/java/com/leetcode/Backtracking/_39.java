package com.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 后面大量DFS题目的基本模板
 * 抽象成有向无环图：
 * 第一个节点为空，出去的节点为235，依次。
 * 遍历这个图，tmp是走到当前节点的路径
 *
 * @author Zhancong Huang
 * @date 14:01 2018/10/4
 */
public class _39 {
    /**
     * 画图，以tmp画图。起始为空
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int remain, int start) {
        //注意顺序
        if (remain == 0){
            res.add(new ArrayList<>(tmp));
        }
        if (remain < 0 ){
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            helper(res, tmp, candidates, remain - candidates[i], i );
            tmp.remove(tmp.size() - 1);
        }
    }

}
