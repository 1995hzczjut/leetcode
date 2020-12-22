package com.leetcode.BinarySearch;

/**
 * 难在理解出现重复情况如何破坏33的代码，具体指第33题中等号的判定
 * 过程看笔记
 * 核心思路：变成33的问题背景，tricky
 *
 * @author Zhancong Huang
 * @date 12:39 2018/10/31
 */
public class _81 {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[low] < nums[mid]) {
                if (target > nums[mid] || target < nums[low]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else if (nums[low] > nums[mid]) {
                if (target < nums[mid] || target >= nums[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            //跟33比唯一多的地方
            else {
                low++;
            }
        }
        return false;
    }
}
