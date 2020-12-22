package com.leetcode.hzc;

public class _303 {

    /**
     * 说了要多次调用求和方法，应该在构造函数里计算完所有的值，放入一个HAHMAP，
     * 这样查询的时候是o（1）
     * 所以问题是构造函数的写法，暴力的话空间复杂度是o(n^2)
     * 正确的做法是sumRange(i, j) = sum[j + 1] - sum[i]
     * orz 没有判空
     * 【int[] sums = new int[0];
     * sums[0] = 1;】肯定不行
     * 怎么处理nums[-1] sum[-1]?
     */
    public static class NumArray {
        private int[] sum;

        public NumArray(int[] nums) {
            if (nums == null) {
                sum = null;
            } else if (nums.length == 0) {
                sum = new int[0];
            } else {
                sum = new int[nums.length];
                sum[0] = nums[0];
                for (int i = 1; i < nums.length; i++) {
                    sum[i] = sum[i - 1] + nums[i];
                }
            }
        }

        public int sumRange(int i, int j) {
            if (sum == null) {
                return 0;
            }
            if (i >= sum.length || j >= sum.length || j < i) {
                return 0;
            } else if (i == 0) {
                return sum[j];
            } else {
                return sum[j] - sum[i - 1];
            }
        }
    }


    public static void main(String[] args) {

    }

}
