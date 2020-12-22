package com.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zhancong Huang
 * @date 23:27 2018/10/30
 */
public class _60 {

    /**
     * 从46改造而来。需要使用成员属性控制顺序
     */
    int num = 0;

    public String getPermutation3(int n, int k) {
        int[] nums = new int[n];
        for (int i = 1; i <= n ; i++) {
            nums[i - 1] = i;
        }
        List<Integer> result = new ArrayList<>();
        helper(result,  k, new ArrayList<>(), nums);
        StringBuilder sb = new StringBuilder();
        for (int i : result){
            sb.append(String.valueOf(i));
        }
        return sb.toString();
    }

    private  void helper(List<Integer> result, int target, List<Integer> tempList,  int[] candidates) {
        if(tempList.size() == candidates.length){
            if (++num == target){
                result.addAll(tempList);
                return;
            }
        }
        for(int i = 0; i < candidates.length; ++i){
            if(tempList.contains(candidates[i])){
                continue;
            }
            tempList.add(candidates[i]);
            helper(result, target, tempList, candidates);
            tempList.remove(tempList.size() - 1);
        }
    }
}
