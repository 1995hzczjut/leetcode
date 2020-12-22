package com.leetcode.array;

import java.util.Arrays;

/**
 * nums: 3 0 1
 * idx:  0 1 2
 * miss num: 2
 * 3中算法，最值得学习还是两分搜索
 *
 * @author Zhancong Huang
 * @date 20:19 2018/10/3
 */
public class _268 {
    /**
     * 位运算，利用异或
     */
    public static int missingNumber1(int[] nums) {
        // x^x=0  x^0=x
        //3^0^1^2^3^0^1 正好得到缺失值
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ i ^ nums[i];
        }
        return result;
    }

    //两分。非常巧妙.时间复杂度不行。思路后面也会用到
    //先sort.target 是第一个nums[i] > i的数。
    //套模板。return left，没问题。等号判定靠特例，思考nums sort后只有最后一个数满足要求，前面很长。那么等号该左边动
    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > mid) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    //第三种. 利用和的差值。因为不miss的话所有的和应该已知
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0, 1, 3, 4, 5}));
    }
}
