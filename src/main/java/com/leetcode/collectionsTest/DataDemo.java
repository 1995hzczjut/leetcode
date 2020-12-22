package com.leetcode.collectionsTest;

/**
 * @author Zhancong Huang
 * @date 21:42 2018/9/19
 */

public class DataDemo implements Runnable {

    int a = -1;

    public DataDemo(int a) {
        this.a = a;
    }

    @Override
    public void run() {

        System.out.println("超时，我要撤销订单啦~~~~~~~" + "##########################" + a);
    }
}


