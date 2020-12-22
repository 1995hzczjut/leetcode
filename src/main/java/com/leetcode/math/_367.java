package com.leetcode.math;

/**
 * 联系sqrt那题
 * @author hzc
 */
public class _367 {


    /**
     * 参考sqrt写错了，mid == num / mid，后面会取整，所以不能再这么写
     */
    public static boolean isPerfectSquare1(int num) {
        int low = 1;
        int high = num;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (mid == num / mid) {
                return true;
            } else if (mid < num / mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;
        while (low <= high) {
            // 注意只能用Long
            long mid = (low + high) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(isPerfectSquare1(5));

    }

}
