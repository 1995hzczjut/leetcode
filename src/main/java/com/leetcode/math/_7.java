package com.leetcode.math;


/**
 * @author Zhancong Huang
 * @date 20:59 2019/1/7
 */
public class _7 {

    /**
     * 遍历一个int，只能/10 %10 从个位数迭代
     */
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }
        return (int)result;
    }
}
