package com.leetcode.math;

/**
 * @author Zhancong Huang
 * @date 21:19 2019/1/7
 */
public class _9 {
    public boolean isPalindrome(int x) {
        if (x < 0 || x != reverse(x)){
            return false;
        }
        return true;
    }

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
