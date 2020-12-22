package com.leetcode.collectionsTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 进程内都有的问题，重启内存未处理的订单会丢失。
 * https://blog.csdn.net/superdog007/article/details/53944884
 * @author Zhancong Huang
 * @date 21:44 2018/9/19
 */
public class DealyTest {
    public static void main(String[] args) {
        ItemQueueThread ith=ItemQueueThread.getInstance();
        ith.init();
        Random r=new Random();
        for(int i=0;i<5;i++)
        {
            int a=r.nextInt(20);//创建一个随机秒数
            System.out.println("预先知道等待时间:"+a);
            DataDemo dd=new DataDemo(a);//创建一个任务对象
            ith.put(a, dd, TimeUnit.SECONDS);//将任务对象添加到队列中
        }

    }

}
