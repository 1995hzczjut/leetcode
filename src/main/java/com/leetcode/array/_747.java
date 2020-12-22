package com.leetcode.array;


/**
 * 就是找出数组中最大，和第二大的。回顾third-max 问题的规范
 * 这里也是要去重的第二大
 * 一样思考 重复的数字要不要计算在内
 * @author Zhancong Huang
 * @date 15:52 2019/1/13
 */
public class _747 {
    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int result = 0;
        Integer max1 = null;
        Integer max2 = null;
        for (int i = 0; i < nums.length; i++) {
            //必须包装类，才能equals。
            Integer num = nums[i];
            if (num.equals(max1) || num.equals(max2)) {
                //检查是否重复数值
                continue;
            }//必须判空
            if (max1 == null || max1 < num) {
                max2 = max1;
                max1 = num;
                result = i;
            } else if (max2 == null || max2 < num) {
                max2 = num;
            }
        }
        return max2 == null || max1 >= max2 * 2 ? result : -1;
    }

    public static void main(String[] args) {
        System.out.println(new _747().dominantIndex(new int[]{3,6,1,0}));
    }
}
