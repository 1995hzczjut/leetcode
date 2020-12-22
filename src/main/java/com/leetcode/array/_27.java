package com.leetcode.array;

/**
 * 与26解法一样
 *
 * @author Zhancong Huang
 * @date 23:05 2019/1/7
 */
public class _27 {

    /**
     * 荷兰国旗问题的格式
     */
    public int removeElement(int[] nums, int val) {
        int less = -1, idx = 0;
        while (idx <= nums.length - 1) {
            if ( nums[idx] != val) {
                swap(nums, ++less, idx);
            }
            idx++;
        }
        return less + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
