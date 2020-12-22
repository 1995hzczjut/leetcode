package com.leetcode.BinarySearch;

import java.util.Arrays;

/**
 *  主要思考搜索结束时的指针位置
 * @author Zhancong Huang
 * @date 11:40 2018/10/31
 */
public class _34 {

    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        return new int[]{findFirstEqual(nums, target), findLastEqual(nums, target)};
    }


    /**
     * 找第一次等于target的位置。要考虑三种情况结束后right,left指针的位置
     * 233333  找3
     * 2 3.5 3.5 3.5 找3
     * 23333   找100
     */
    public int findFirstEqual(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        //找不到有两种情况，一种Left越界或者left不越界但是指的数字不等于target
        if (left == nums.length || nums[left] != target) {
            return -1;
        } else {
            return left;
        }
    }

    /**
     * 找最后一次等于target的位置，同样思考
     * 2333344 找3
     * 2 3.5 3.5 3.5 找3
     * 233333  找1
     */
    public int findLastEqual(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (right == -1 || nums[right] != target) {
            return -1;
        } else {
            return right;
        }
    }

    public static void main(String[] args) {
        _34 s = new _34();
//        int[] nums = {5,7,7,8,8,10};
//        int t = 80;
                int[] nums = {1};
        int t = 1;
        System.out.println(Arrays.toString(s.searchRange(nums, t)));
    }
}
