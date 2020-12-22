package com.leetcode.math;

/**
 * ��ϵsqrt����
 * @author hzc
 */
public class _367 {


    /**
     * �ο�sqrtд���ˣ�mid == num / mid�������ȡ�������Բ�������ôд
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
            // ע��ֻ����Long
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
