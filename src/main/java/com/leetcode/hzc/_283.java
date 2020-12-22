package com.leetcode.hzc;



/**
 * 参考26,荷兰国旗问题，这里target=0,且不需要more
 *
 * @author Zhancong Huang
 * @date 8:29 2019/8/13
 */
public class _283 {

    public void moveZeros(int[] nums) {
        if (nums.length == 0) return;
        int less = -1, idx = 0;
        while (idx < nums.length) {
            if (nums[idx] != 0) {
                swap(nums, ++less, idx);
            }
            idx++;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
