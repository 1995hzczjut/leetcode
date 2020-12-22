package com.leetcode.math;

/**
 * 找规律，F（i）-F(i - 1)既可以找到规律
 * https://www.cnblogs.com/grandyang/p/5869791.html
 *
 * @author Zhancong Huang
 * @date 14:11 2019/5/3
 */
public class _396 {
    public int maxRotateFunction(int[] A) {
        int n = A.length, sum = 0, f = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            f += i * A[i];
        }
        int r = f;
        for (int i = 1; i < n; i++) {
            f = f + sum - n * A[n - i];
            r = Math.max(r, f);
        }
        return r;
    }
}
