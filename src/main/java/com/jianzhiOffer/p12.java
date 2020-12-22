package com.jianzhiOffer;

/**
 * 快速幂问题
 * 直观的做法：判断exponent正负，然后累乘，是有重复计算的。可以算target/2的情况，再根据奇偶处理。
 * 思路：
 * n次方，先不看符号,n为奇数，看成（n-1）/2  （n-1）/2   1 三个相乘,其实n奇数时，（n-1）/2 等价于 n/2
 * 偶数的话直接 n/2 n/2
 * 上述过程就是递归的过程，重点就是n=0
 *
 * @author Zhancong Huang
 * @date 23:13 2019/4/19
 */
public class p12 {

    /**
     * logN
     */
    public double Power(double base, int exponent) {
        if (base == 0) return 0;
        double result = doPower(base, Math.abs(exponent));
        if (exponent < 0) {
            result = 1 / result;
        }
        return result;
    }

    /**
     * 这里递归的点很难想到
     *
     * @param exponent 保证非负
     */
    private double doPower(double base, int exponent) {
        if (exponent == 0) return 1;
        double subPower;
        if (exponent % 2 == 1) {
            subPower = doPower(base, (exponent - 1) / 2);
            return base * subPower * subPower;
        } else {
            subPower = doPower(base, exponent / 2);
            return subPower * subPower;
        }
    }
}
