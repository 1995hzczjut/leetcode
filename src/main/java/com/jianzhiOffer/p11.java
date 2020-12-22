package com.jianzhiOffer;

/**
 * 直观的做法： 用1<<i 去挨个与
 * https://www.nowcoder.com/questionTerminal/8ee967e43c2c4ec193b040ea7fbb10b8
 *
 * @author Zhancong Huang
 * @date 22:45 2019/4/19
 */
public class p11 {

    public static int NumberOf(int n) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0)
                cnt++;
        }
        return cnt;
    }


    public static int NumberOf1(int n) {
        int cnt = 0;
        //错误：while(n>0) n可能是负数，第一位是1，所以用！=0，处理的时候不用管正负
        while (n != 0) {
            //10000 减1是 01111 ，
            n = n & (n - 1);
            cnt++;
        }
        return cnt;
    }

}
