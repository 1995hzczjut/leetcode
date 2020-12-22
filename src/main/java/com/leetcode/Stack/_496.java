package com.leetcode.Stack;

import java.util.*;

/**
 * 给定一个数组，找到每一个数右边的第一个大于他的数（不存在不用找）。时间复杂度O（n） 可以做到
 * 通关递减栈实现。
 * 1 5 4 3 6
 * 1入栈。5比1大，1-5 是我们要的
 * 5入栈，4比5小，4入栈
 * 3比4小，3压入栈。 这个栈是递减的
 * 6比3，4，5 都大。把345都带走
 * 利用递减栈构建过程中的pop特性
 */
public class _496 {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //递减栈
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        //key:nums2的数字 value:key的右边第一个大于它自己的数字
        Map<Integer, Integer> map = new HashMap<>(256);
        //构建monotone stack
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        //构建返回结果
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }


    public static void main(String[] args) {
        int[] a = {4, 1, 2};
        int[] b = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement(a, b)));
    }
}
