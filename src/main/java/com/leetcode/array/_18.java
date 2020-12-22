package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  总结：2sum 2sum_sorted Xsum（X>2）
 *  找两个数，O（N）时间的要求，不让回头看，只能用额外的空间存
 *  排序了，两分解决
 *  >2 fix 一个往下迭代
 * @author Zhancong Huang
 * @date 17:00 2019/1/16
 */
public class _18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            //不要做>0的剪枝
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            setResult_4sum(result, nums, i, target);
        }
        return result;
    }

    private void setResult_4sum(List<List<Integer>> result, int[] nums, int i, int target) {
        List<List<Integer>> twoSumResult = threeSum(nums, target - nums[i], i + 1, nums.length - 1);
        for (List<Integer> list : twoSumResult) {
            result.add(Arrays.asList(nums[i], list.get(0), list.get(1), list.get(2)));
        }
    }


    public List<List<Integer>> threeSum(int[] nums, int target, int lo, int hi) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = lo; i < hi - 1; i++) {
            //不要做>0的剪枝
            if (i > lo && nums[i] == nums[i - 1]) continue;
            setResult_3sum(result, nums, i, target);
        }
        return result;
    }

    public void setResult_3sum(List<List<Integer>> result, int[] nums, int i, int target) {
        List<List<Integer>> twoSumResult = twoSumSorted(nums, target - nums[i], i + 1, nums.length - 1);
        for (List<Integer> list : twoSumResult) {
            result.add(Arrays.asList(nums[i], list.get(0), list.get(1)));
        }
    }

    public List<List<Integer>> twoSumSorted(int[] nums, int target, int lo, int hi) {
        List<List<Integer>> result = new ArrayList<>();
        Integer prevLo = null;
        Integer prevHi = null;
        //不可以<= 否则123 target=6 最后两个都指在3了
        while (lo < hi) {
            if (prevLo != null && prevLo.equals(nums[lo])) {
                lo++;
                continue;
            }
            if (prevHi != null && prevHi.equals(nums[hi])) {
                hi--;
                continue;
            }
            int tmpSum = nums[lo] + nums[hi];
            if (tmpSum == target) {
                result.add(Arrays.asList(nums[lo], nums[hi]));
                //prev更新小心，一开始先移动lo,再prevlo = nums[lo]肯定错了
                prevLo = nums[lo++];
                prevHi = nums[hi--];
            }
            if (tmpSum < target) {
                prevLo = nums[lo++];
            } else if (tmpSum > target) {
                prevHi = nums[hi--];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-5,-2,1,1,3,5,5,5};
        int target = 4;
//        System.out.println(new _18().threeSumSorted(nums, 3,0, nums.length-1));
//        System.out.println(new _15().threeSum(nums));
        //System.out.println(new _18().twoSumSorted(nums,8 ,2,nums.length-1));
        System.out.println(new _18().threeSum(nums, 9,1, nums.length-1));
        //System.out.println(new _18().fourSum(nums, target));
    }
}
