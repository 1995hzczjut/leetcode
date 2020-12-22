package com.leetcode.array;

/**
 * 有序数组的2sum 问题。不再需要hashmap，利用有序这个性质。
 * 借助两分的思路。两个数的和就是两分要找的target
 * 重要的是这种抽象的两分思路
 * ============
 * 题目告知有序，一定想想能不能用两分优化。其他复杂度已知很高，也可以先想想能不能先排序
 * <p>
 * 2.19 补充
 * 这里太简单，如果结果不允许有重复还要复杂一点，见_15
 *
 * @author Zhancong Huang
 * @date 19:53 2018/10/3
 */
public class _167 {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }
        int lo = 0;
        int hi = numbers.length - 1;
        while (lo <= hi) {
            int tmpSum = numbers[lo] + numbers[hi];
            if (tmpSum == target) {
                return new int[]{lo + 1, hi + 1};
            }
            if (tmpSum < target) {
                lo++;
            } else if (tmpSum > target) {
                hi--;
            }
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {

    }
}
