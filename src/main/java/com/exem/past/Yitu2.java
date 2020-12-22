package com.exem.past;

import java.util.Scanner;

/**
 * @author Zhancong Huang
 * @date 19:39 2019/9/20
 */
public class Yitu2 {

    static double x = 2;
    static double y = 7;

    public static long helper() {
        double low = y * y / x - 0.5d;
        double high = y * y / x + 0.5d;
        System.out.println(String.format("low %s, high %s", low, high));
        long ret = -1;
        if (high % 1 == 0){
            ret = (long) high;
        }else {
             ret = (long) Math.floor(low + 1);
        }

        x = y;
        y = ret;
        return (long) (ret % (1e9 + 7));
    }

    /**
     * 题目的输入要一次性读取完
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        if (total == 0) return;
        int[] arr = new int[total];
        for (int i = 0; i < total; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < total; i++) {
            int num = arr[i];
            if (num == 1) {
                System.out.println(2);
            } else if (num == 2) {
                System.out.println(7);
            } else {
                int _num = num - 3;
                int idx = 0;
                while (true) {
                    if (idx++ == _num) {
                        System.out.println(helper());
                        break;
                    } else {
                        helper();
                    }
                }
                x = 2;
                y = 7;
            }
        }
    }


}
