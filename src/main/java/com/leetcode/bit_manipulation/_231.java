package com.leetcode.bit_manipulation;

public class _231 {

    /**
     * 简单的位运算
     */
    public boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
