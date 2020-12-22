package com.jianzhiOffer;


import java.util.ArrayList;
import java.util.List;

/**
 * Int 越界，全部用long
 * 就是permutation问题
 *
 * @author Zhancong Huang
 * @date 12:47 2019/4/22
 */
public class p32 {
    public String PrintMinNumber(int [] numbers) {
        if (numbers.length == 0) return "";
        long[] result = new long[1];
        result[0] = Long.MAX_VALUE;
        boolean[] used = new boolean[numbers.length];
        helper(result, new ArrayList<>(), numbers, used);
        return String.valueOf(result[0]);
    }

    private void helper(long[] result, List<Integer> tmpList, int[] nums, boolean[] used){
        if (tmpList.size() == nums.length){
            result[0] = Long.min(calculate(tmpList), result[0]);
            return;
        }
        //牢记模板，中间6行
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]){
                used[i] = true;
                tmpList.add(nums[i]);
                helper(result, tmpList, nums, used);
                used[i] = false;
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }

    private long calculate(List<Integer> tmpList) {
        StringBuilder sb = new StringBuilder();
        for (Integer i : tmpList){
            sb.append(String.valueOf(i));
        }
        return Long.valueOf(sb.toString());
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3334,3,3333332};
        System.out.println(new p32().PrintMinNumber(nums));
    }
}
