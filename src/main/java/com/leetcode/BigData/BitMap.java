package com.leetcode.BigData;

import java.util.ArrayList;
import java.util.List;

public class BitMap {

    private int N;
    private int[] a;
    private BitMap(int n) {
        N = n;
        a = new int[N / 32 + 1]; //参数刚刚好
    }

    public void display() {
        System.out.println("bitmap display:");
        for (int i = 0; i < N / 32 + 1; i++) {
            List<Integer> list = new ArrayList<Integer>();
            int temp = a[i];
            for (int j = 0; j < 32; j++) {
                list.add(temp & 1);
                temp >>= 1;
            }
            System.out.println("a[" + i + "]" + list);
        }
    }

    public void add(int n) {
        int row = n >> 5;
        //取模的位运算,只有2的N次方才适用
        //n & (31) 就是 这个数第几位，用1左移这个数去或就置为1了
        //remove,serch 同理
        a[row] = a[row] | (1 << (n & (0x1F)));
    }


    public static void main(String[] args) {
        BitMap bitMap = new BitMap(32);
        bitMap.add(31);
        bitMap.display();
    }
}
