package com.leetcode.array;

import java.util.Arrays;

import static com.leetcode.sort.SortUtil.swap;

/**
 * @author Zhancong Huang
 * @date 9:27 2019/8/5
 */
public class _4 {

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
//        for (int i = 0; i < n; ++i) {
//            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
//                swap(nums, i, nums[i] - 1);
//            }
//        }
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,-1,1};

        System.out.println(firstMissingPositive(nums));
        System.out.println(Arrays.toString(nums));
    }

}
