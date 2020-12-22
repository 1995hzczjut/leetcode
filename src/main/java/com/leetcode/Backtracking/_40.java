package com.leetcode.Backtracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 是698的前置问题，数组中找特定subset的都可以用这个模板
 *
 * @author Zhancong Huang
 * @date 14:55 2018/10/4
 */
public class _40 {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
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
            //注意不是从0开始
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            tmp.add(candidates[i]);
            helper(res, tmp, candidates, remain - candidates[i], i+1 );
            tmp.remove(tmp.size() - 1);
        }
    }

}
