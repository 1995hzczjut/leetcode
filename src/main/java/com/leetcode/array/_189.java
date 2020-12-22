package com.leetcode.array;

import java.util.Arrays;

/**
 * tricky
 * @author Zhancong Huang
 * @date 0:18 2018/9/30
 */
public class _189 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int head, int tail){
        while (head < tail) {
            int tmp = nums[head];
            nums[head] = nums[tail];
            nums[tail] = tmp;
            head++;
            tail--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        new _189().rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
