package com.leetcode.array;

import java.util.Arrays;

/**
 * 按照3sum做法，也是fix一个,然后找剩下的最接近target - fixed 的两个数字的和
 * 这个找法也是两分的做法，维护两个变量。遍历中遍历到一个点，先更新，然后决定下一步怎么走。
 *
 * @author Zhancong Huang
 * @date 13:50 2019/1/14
 */
public class _16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        Integer colsestSum = null;
        Integer minDiff = null;
        for (int i = 0; i < nums.length - 2; i++) {
            int curSum = nums[i] + helper(nums, i + 1, nums.length - 1, target - nums[i]);
            int curDiff = Math.abs(curSum - target);
            if (minDiff == null || curDiff < minDiff) {
                minDiff = curDiff;
                colsestSum = curSum;
            }
        }
        if (colsestSum == null) {
            throw new IllegalArgumentException();
        } else {
            return colsestSum;
        }
    }

    /**
     * 找最接近一个数的两个数和
     * 已排序.返回最接近target的两个数的和
     * 不排序即暴力做法O（N^2）.排序完O（N）。做法跟11一样。
     * 11是要找最大，这个找最接近
     */
    private int helper(int[] nums, int start, int end, int target) {
        int left = start, right = end;
        Integer result = null;
        Integer minDiff = null;
        //同样不能用<=。这里判断依据 两个指针指向同一个数能否满足条件
        while (left < right) {
            int curSum = nums[left] + nums[right];
            int curDiff = Math.abs(curSum - target);
            if (minDiff == null || curDiff < minDiff) {
                minDiff = curDiff;
                result = curSum;
            }
            if (curSum == target) {
                break;
            } else if (curSum > target) {
                right--;
            } else {
                left++;
            }
        }
        if (result == null) {
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        _16 s = new _16();
        int[] nums = {-1, 1, 2, 5};
        //System.out.println(s.helper(nums, 0, nums.length - 1, 2));
        System.out.println(s.threeSumClosest(nums, 0));
    }
}
