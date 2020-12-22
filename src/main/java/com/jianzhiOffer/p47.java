package com.jianzhiOffer;

/**
 * 关键在于怎么停止递归，不让用if?用&&
 *
 * @author Zhancong Huang
 * @date 15:53 2019/4/23
 */
public class p47 {
    public static int Sum_Solution(int n) {
        int sum = n;
        boolean f = (sum > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Sum_Solution(1));
    }
}
