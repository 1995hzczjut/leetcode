package com.leetcode.array;



/**
 * 参考next permutation。一个降序的数字是最大的，交换一次要这个排序最大，
 * 最好的方式就是尽量让高位变大，所以先O（N）的代价找到每个数字右边的最大值，包括它本身。
 * 然后从左到右查看 每个数字的右侧最大值是不是它本身，如果不是那就交换。
 * 交换哪个？当然是跟它右边最大的数交换，而且被交换的如果存在存在多个相同的值，
 * 应该选最靠右的，如下：
 * 78888， 7跟哪个8交换？要使数字尽量大，应该让靠右的8变成7
 *
 * @author Zhancong Huang
 * @date 0:11 2019/1/27
 */
public class _670 {

    public int maximumSwap(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        //maxRightNum[i] 代表数字nums[i:-1]区间的最大值
        char[] maxRightNum = new char[nums.length];

        maxRightNum[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            maxRightNum[i] = (char) Math.max(nums[i], maxRightNum[i + 1]);
        }

        for (int i = 0; i < maxRightNum.length; i++) {
            if (nums[i] != maxRightNum[i]) {
                for (int j = maxRightNum.length - 1; j >= 0; j--) {
                    if (nums[j] == maxRightNum[i]) {
                        swap(nums, i, j);
                        return Integer.valueOf(new String(nums));
                    }
                }
            }
        }
        return num;
    }


    private void swap(char[] nums, int i, int j) {
        char tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
