package com.leetcode.concurrency;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Zhancong Huang
 * @date 13:53 2019/10/6
 */
public class ProviderAndComsumer {

    private final int MAX_SIZE;
    private int size = 0;
    private Lock lock = new ReentrantLock();
    private Condition putCond = lock.newCondition();
    private Condition takeCond = lock.newCondition();

    public ProviderAndComsumer(int size) {
        this.MAX_SIZE = size;
    }

    public void put() {
        lock.lock();
        try {
            if (size >= MAX_SIZE) {
                putCond.await();
            }
            System.out.println(String.format("当前容量：%s, 生产完后剩余：%s", size, ++size));
            takeCond.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public void take() {
        lock.lock();
        try {
            if (size <= 0) {
                takeCond.await();
            }
            System.out.println(String.format("当前容量：%s, 消费完后剩余：%s", size, --size));
            putCond.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ProviderAndComsumer test = new ProviderAndComsumer(10);
        Random random = new Random();

        new Thread(() -> {
            while (true){
                try {
                    //Thread.sleep(random.nextInt(1000));
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test.put();
            }
        }).start();

        new Thread(() -> {
            while (true){
                try {
                    //Thread.sleep(random.nextInt(1000));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test.take();
            }
        }).start();
    }
}
