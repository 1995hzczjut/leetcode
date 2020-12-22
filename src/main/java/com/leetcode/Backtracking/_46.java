package com.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  同47。没有重复的化if (visited[i] || i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) continue;
 *  用List的contains方法即可
 * @author Zhancong Huang
 * @date 16:10 2018/10/4
 */
public class _46 {

    /**
     * 经典。Nums有重复怎么找到所有的排序？
     *
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), nums, visited);
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> tmp, int[] nums, boolean[] visited) {
        System.out.println(tmp);
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
        }
        for (int i = 0; i < nums.length; i++) {
            //第一次写法：nums={1,1,2}.tmp={1，1，2}，下一步找的时候第一个1不要很简单，第二个1麻烦，如果按下面写法
            //这个1不会被含进去的，者不符合题意。虽然跟前1个1相等，但是那个1没用过。不影响。
            //假设nums={1,1,1，2} 第三个1不要，为什么？
            // 因为第二、三个1，从root到这两个点的路径都是一样的（画图）
            // 而后面的所以字都是一样的，所以整体的路径也是一样的
            //但第一个1 后面没有东西的，所以要过滤一下
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
        System.out.println(permuteUnique(new int[]{1,1,2}));
    }
}
