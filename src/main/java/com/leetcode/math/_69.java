package com.leetcode.math;

/**
 * @author Zhancong Huang
 * @date 11:00 2019/8/13
 */
public class _69 {


    /**
     * 分析过程：
     * 两分本质是，用nums[mid]的值排除掉半边候选者，这题也是一样的
     * 假设nums[mid]=mid=5,n的case有25 30 20，100
     * 5*5=25,可以返回了
     * 5*5<30,按照一般的做法，[1,5]都是要找的，可以让left=mid+1
     * 但是这里很特殊，要找最接近的，sqrt30正好位于5和6之前，题目要求返回sqrt30的整数部分，
     * 所以这种情况也要直接返回
     * 5*5>20，这种情况就是sqrt20位于4,5之间，应该返回4，所以5及5右边的可以干掉了
     * 5*5《100,根号100不在56之间，5及5左边干掉。
     *
     */
    public static int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1, right = x;
        while (left <= right) {
            int mid = (left + right) >> 1;
            //用乘法会溢出
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            }
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
    }

}
