package com.leetcode.array;

/**
 * 图解。好题加深了对两分的理解。本质还是递归调用，非递增函数也可以用。
 * https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/14436/Revised-Binary-Search?page=1
 *
 * @author Zhancong Huang
 * @date 23:43 2018/10/3
 */
public class _33 {
    /**
     * 对不重复数组找指定数的基本问题要非常熟悉。
     * 不重复的直接
     * if (nums[mid] == target) {
     * return mid;
     * }
     * 重复的一般会说找第一个，或者最后一个出现的。需要再最后校验
     */
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            //注意这个等号
            if (nums[low] <= nums[mid]) {
                if (target > nums[mid] || target < nums[low]) {
                    //别跟11搞混写成Low--
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (target < nums[mid] || target >= nums[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 7, 0, 1, 2};
        int n = 0;
        for (int i = 0; i < a.length; i++) {
            System.out.println(search(a, 100));
        }
    }
}
