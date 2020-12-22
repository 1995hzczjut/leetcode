package com.leetcode.TwoPointers;

public class _75 {

    /**
     * 荷兰国旗问题。必须多写。
     * int less = start - 1;  int more = end + 1; 这两个指针搞的很清楚
     * swap(nums, idx++, ++less);  swap(nums, idx, --more);  交换条件指针怎么移动的
     */

    public void sortColors(int[] nums) {
        partition(nums, 0, nums.length - 1, 1);
    }


    public void partition(int[] nums, int start, int end, int target) {
        //(-inf, less] 代表小于target
        int less = start - 1;
        //[more, +inf) 代表大于target；（less, more）代表等于
        //less,more 指的数字是已经满足最终条件的，所以要交换绝对不会交换这两个。
        int more = end + 1;
        int idx = start;
        //终止条件小心，不是<end
        while (idx < more) {
            if (nums[idx] < target) {
                swap(nums, idx++, ++less);
            } else if (nums[idx] > target) {
                swap(nums, idx, --more);
            } else {
                idx++;
            }
        }

    }

    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }



    public static void main(String[] args) {

    }

}
