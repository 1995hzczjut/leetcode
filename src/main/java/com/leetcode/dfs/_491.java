package com.leetcode.dfs;

import java.util.*;

/**
 * 开始想的是用排序去重(46/47)，这样是绝对错的。因为subsequences 是要有顺序的，排序就打乱了顺序。
 *
 * @author Zhancong Huang
 * @date 19:33 2019/7/21
 */
@SuppressWarnings("unchecked")
public class _491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        findSequence(set, new LinkedList<>(), 0, nums);
        return new ArrayList<>(set);
    }


    public void findSequence(Set<List<Integer>> res, LinkedList<Integer> tmpList, int start, int[] nums) {
        if (tmpList.size() >= 2) {
            res.add(new LinkedList(tmpList));
        }
        for (int i = start; i < nums.length; i++) {
            if (tmpList.size() == 0 || tmpList.getLast() <= nums[i]) {
                tmpList.add(nums[i]);
                findSequence(res, tmpList, i + 1, nums);
                tmpList.removeLast();
            }
        }
    }
}
