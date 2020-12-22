package com.leetcode.math;

/**
 * @author Zhancong Huang
 * @date 14:33 2019/4/13
 */
public class _326 {

    /**
     * 跟丑数问题一样，这个简单一些。
     * 都是用递归，终止条件考虑01.
     * 然后看能不能整除一些数字，不能直接扔掉。能的话去调一个因子，再递归调用
     */
    public boolean isPowerOfThree(int n) {
        if (n == 1)return true;
        if (n == 0 || n % 3 != 0)return false;

        return isPowerOfThree(n/3);
    }
}
