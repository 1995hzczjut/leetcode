package com.leetcode.array;
/**
 * 可以先计算总共能种多少，直接从左向右计算即可。要注意边界问题
 * 起始写出flowerbed[i - 1] 就要有要越界的意识
 *
 * @author Zhancong Huang
 * @date 22:48 2018/9/20
 */

public class _605 {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        //估计最大能种多少
        int count = 0;
        for (int i = 0; i < flowerbed.length; ++i) {
            if (flowerbed[i] == 0) {
                //两边超过上限是可以种的。
                int prev = i - 1 >= 0 ? flowerbed[i - 1] : 0;
                int next = i + 1 < flowerbed.length ? flowerbed[i + 1] : 0;
                if(prev == 0 && next == 0){
                    count++;
                    flowerbed[i] = 1;
                }
            }
        }
        return count >= n;
    }

    public static void main(String[] args) {
        int[] a = {1,0,0,0,0,1};
        int n = 2;
        System.out.println(canPlaceFlowers(a,n));
    }
}
