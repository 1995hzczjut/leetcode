package com.jianzhiOffer;

/**
 * 不要忘记dp[0],2级台阶可用从地板跳+从一级跳
 * @author Zhancong Huang
 * @date 0:15 2019/4/17
 */
public class p7 {
    public int Fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return  1;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}
