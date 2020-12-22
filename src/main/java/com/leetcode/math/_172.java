package com.leetcode.math;

/**
 * @author Zhancong Huang
 * @date 22:18 2019/2/3
 */
public class _172 {
    public int trailingZeroes(int n) {
        //1到n，每隔5*1，5*2，5*3，5*4 。因为2肯定管够，只要看5有几个就行了。
        //但是只看5也不行，还有25的倍数提供两个5
        //例如1到50，也看能整除5的有几个。5，10，15。。。50 共10个
        //在此基础上，看能整除25的有几个。25，50.这两个数【额外】提供了一个5.
        //整除125的就没了。
        long f = 5;
        int res = 0;
        while (n / f > 0) {
            res += n / f;
            f *= 5;
        }
        return res;
    }
}
