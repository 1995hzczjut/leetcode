package com.leetcode.bit_manipulation;

/**
 * 汉明距离：两个数字每一位不同的总数
 *
 * @author Zhancong Huang
 * @date 23:45 2019/6/29
 */
public class _461 {
    public static int hammingDistance(int x, int y) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int xx = (x & (1 << i));
            int yy = (y & (1 << i));
            if ((xx ^ yy) != 0){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1,4));
    }
}
