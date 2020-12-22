package com.leetcode.math;

/**
 * @author Zhancong Huang
 * @date 22:24 2019/1/31
 */
public class _168 {
    /**
     * number = a*26^2 + b*26^1 + c*26^0
     * 目的就是确认出abc，number = 整除结果*26^1 + 余数*26^0.整除结果作为下一个Number进行递归计算。理解这个递归很重要
     * 但是上面按题意abc范围在1--26.除26取余数的话，26%26=0 达不到上面的效果。
     * 下面的办法就是对能整除26的特殊处理。整除结果照旧
     * 例如AZ=52=1*26^1+26*26^0. 按照整除26，是不会出现上面的结果的，因此需要特殊处理，直接减去26，后面的幂降1.
     */
    public static String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            if (n % 26 == 0) {
                res.insert(0, "Z");
                n = (n - 26) / 26;
            } else {
                res.insert(0, (char) (n % 26 + 64));
                n /= 26;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(26 * 26));
        System.out.println(convertToTitle(27));
    }
}
