package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 找3个数，一看大于等于O（N^2），还要求去重（去重都用包装类写），肯定要排序
 * 然后借鉴167题，关键167只找一组，这里要全找到，还不能有重复，可以用set写，面试也这么写，
 * 因为不易出错，也可以用下面的指针控制，要烦很多
 *
 * @author Zhancong Huang
 * @date 12:12 2019/1/14
 */
public class _15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return threeSumHelper(nums, 0, nums.length - 1, 0);
    }

    /**
     * nums已排序
     */
    public List<List<Integer>> threeSumHelper(int[] nums, int start, int end, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Integer prev = null;
        for (int i = start; i <= end; i++) {
            if (prev != null && prev.equals(nums[i])) {
                //这个值跟上一个值相等，那么这个值对应的答案必然在上一个值可以找到
                continue;
            }
            List<List<Integer>> twoSumResult = twoSumHelper(nums, i + 1, nums.length - 1, target - nums[i]);
            for (List<Integer> list : twoSumResult) {
                result.add(Arrays.asList(nums[i], list.get(0), list.get(1)));
            }
            prev = nums[i];
        }
        return result;
    }

    /**
     * nums以排序.跟第167题2Sum_sorted的差别在于这里要去重
     * 可以用Set写，最好用指针控制，即指针移动的时候一定要跟上一次比较
     */
    public List<List<Integer>> twoSumHelper(int[] nums, int start, int end, int target) {
        List<List<Integer>> result = new LinkedList<>();
        int left = start, right = end;
        Integer prevLeft = null;
        Integer prevRight = null;

        while (left < right) {
            //左边去重
            if (prevLeft != null && prevLeft.equals(nums[left])) {
                left++;
                continue;
            }
            //右边去重
            if (prevRight != null && prevRight.equals(nums[right])) {
                right--;
                continue;
            }
            int curSum = nums[left] + nums[right];
            if (curSum == target) {
                result.add(Arrays.asList(nums[left], nums[right]));
                //167题是上面找到了直接返回，那是因为167规定了只有一组值，这里不一样
                //只能往中间收，prevLeft，prevRight也要设置
                prevLeft = nums[left++];
                prevRight = nums[right--];
            } else if (curSum < target) {
                prevLeft = nums[left++];
            } else {
                prevRight = nums[right--];
            }
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
