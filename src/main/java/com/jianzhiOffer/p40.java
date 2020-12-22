package com.jianzhiOffer;

/**
 * 要找两个不同的数字， 必定有一位不同。 即一个为0，一个为1.
 * 然后把所有的数字按这个特征把所有的数字化成两批。相同的数字保证在同一批中，就退化成找单个数字的题目了
 * 关键在找这个标志
 * if ((sum & (1 << i)) != 0)错写成 == 1了
 *
 * @author Zhancong Huang
 * @date 16:02 2019/4/22
 */
public class p40 {
    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array.length < 2) return;

        int xorRet = 0;
        for (int i = 0; i < array.length; i++) {
            xorRet ^= array[i];
        }

        int flagIdx  = 0;
        for (int i = 0; i < 32; i++) {
            if ((xorRet & (1 << i)) != 0){
                flagIdx = i;
                break;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if ((array[i] & (1 << flagIdx)) != 0) {
                num1[0] ^= array[i];
            }else {
                num2[0] ^= array[i];
            }
        }
    }
}
