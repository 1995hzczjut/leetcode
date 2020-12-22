package com.leetcode.sort;

import java.util.Arrays;

/**
 * 难点在排序的哪个lambda,思考34 3 怎么排。想要最后的数字最大，只需要看343 334谁大就可以了，不需要复杂的看每一位
 * 主要用Long去接受
 *
 * @author Zhancong Huang
 * @date 12:44 2019/6/18
 */
public class _179 {
    /**
     * Arrays.sort不可以自定义排序基本数据类型
     */
    public static String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        String[] strings = new String[nums.length];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        //core
        Arrays.sort(strings, (o1, o2) -> Long.valueOf(o2 + o1).compareTo(Long.valueOf(o1 + o2)));
        String res = Arrays.stream(strings).reduce("", String::concat);
        if (res.startsWith("0")) {
            //以0开头代表都是0
            res = "0";
        }
        return res;
    }

    public static void main(String[] args) {
        //       String[] arr = new String[]{"34", "3", "30"};
//        Arrays.sort(arr, (left, right) -> Long.valueOf(right + left).compareTo(Long.valueOf(left + right)));
//        System.out.println(Arrays.toString(arr));
        System.out.println(largestNumber(new int[]{0}));
    }
}
