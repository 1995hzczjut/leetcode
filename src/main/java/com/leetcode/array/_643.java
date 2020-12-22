package com.leetcode.array;


/**
 * 找到数组种长度为n的最大子数组和，要求O（N）.还是有点技巧的
 * 0123456748
 *
 * 数值包装类型 在null时 不能i++ 操作，要三元运算符 判空再操作
 * @author Zhancong Huang
 * @date 0:59 2019/2/17
 */
public class _643 {
    public static double findMaxAverage(int[] nums, int k) {
        if (nums.length < k) {
            throw new IllegalArgumentException();
        }
        Integer subSum = null;
        Integer result = null;
        for (int i = k - 1; i < nums.length; i++) {
            //i向左闭区间，共k个
            if (subSum == null) {
                for (int j = 0; j < k; j++) {
                    System.out.println("j: " + j);
                    //subSum += nums[j]; 错误写法会NPE
                    subSum = (subSum == null ? 0 : subSum) + nums[j];
                }
                System.out.println(subSum);
            } else {
                subSum = subSum + nums[i] - nums[i - k];
            }
            if (result == null || result < subSum) {
                result = subSum;
            }
        }
        return (double)result / k;
    }

    public static double findMaxAverage1(int[] nums, int k) {
        long sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];
        System.out.println(sum);
        long max = sum;

        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }

        return max / 1.0 / k;
    }
    public static void main(String[] args) {
        int nums[] = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(findMaxAverage(nums, k));
        System.out.println(findMaxAverage1(nums, k));
    }
}
