package com.leetcode.array;

/**
 * o(n)  o(1)
 * 有点技巧
 *
 * @author Zhancong Huang
 * @date 20:25 2018/9/28
 */
public class _724 {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        int leftSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0) {
                leftSum += nums[i - 1];
            }
            if (2 * leftSum == totalSum - nums[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        _724 s = new _724();
        //int[] a = new int[]{1, 7, 3, 6, 5, 6};
        System.out.println(s.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }
}
