package com.jianzhiOffer;

import java.util.Arrays;

/**
 * https://www.nowcoder.com/questionTerminal/94a4d381a68b47b7a8bed86f2975db46
 * 有图的思路
 *
 * @author Zhancong Huang
 * @date 18:51 2019/4/28
 */
public class p51 {
    public static int[] multiply(int[] A) {
        //check
        if (A == null || A.length < 2) return A;
        int[] B = new int[A.length];
        B[0] = 1;
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int tmp = 1;
        //先用额外的数字表示一个下标右边的乘积，发现可用简化
        for (int i = A.length - 1; i > 0; i--) {
            tmp *= A[i];
            B[i - 1] *= tmp;
        }
        return B;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(multiply(new int[]{1,2,3,4,5})));
    }
}
