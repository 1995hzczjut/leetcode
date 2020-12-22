package com.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zhancong Huang
 * @date 16:07 2018/10/4
 * @see _47
 */
public class _90 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        helper(list, new ArrayList<>(), nums, 0);
        return list;
    }

    /**
     * @param start 在这个点要搜索的起始位置，是自己所处为止+1
     */
    private static void helper(List<List<Integer>> list, List<Integer> tempList, int[] candidates, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < candidates.length; ++i) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            tempList.add(candidates[i]);
            helper(list, tempList, candidates, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }


}
