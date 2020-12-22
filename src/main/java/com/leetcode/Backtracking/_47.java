package com.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 使用Visited数组+排序去重 有坑，看90没问题，那是因为有start变量
 *
 * @author Zhancong Huang
 * @date 16:54 2018/10/4
 */
public class _47 {

    /**
     * 经典。Nums有重复怎么找到所有的排序？
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), nums, visited);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> tmp, int[] nums, boolean[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //第一次写法：nums={1,1,2}.tmp={1，1，2}，下一步找的时候第一个1不要很简单，第二个1麻烦，如果按下面写法
            //这个1不会被含进去的，者不符合题意。虽然跟前1个1相等，但是那个1没用过。不影响。
            //假设nums={1,1,1，2} 第三个1不要，为什么？1 后面的东西，第一个1后面也会找到，不用担心漏掉（画图很清晰）
            //if (visited[i] || i > 0 && nums[i] == nums[i - 1] ) continue;
            if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            tmp.add(nums[i]);
            helper(res, tmp, nums, visited);
            tmp.remove(tmp.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        new _47().permuteUnique(new int[]{1, 1, 2});
    }
}
