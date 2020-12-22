package com.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zhancong Huang
 * @date 15:07 2018/10/4
 * @see _90
 */
public class _78 {
    /**
     * 参考39.之前有两种思路，选第一种。
     * 图中遍历到一个点，自己本身已经在临时结果集了。
     * 以tmpList是最好的解释方法
     * 这一类问题
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> tmpList, int[] nums, int start) {
        result.add(new ArrayList<>(tmpList));
        for (int i = start; i < nums.length; i++) {
            tmpList.add(nums[i]);
            dfs(result, tmpList, nums, i + 1);
            tmpList.remove(tmpList.size() - 1);
        }
    }

}
