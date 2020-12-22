package com.leetcode.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 简单的阻塞队列。
 * 生疏的地方：泛型跟Object。new Object[10]
 *
 * @author Zhancong Huang
 * @date 11:17 2019/7/31
 */
public class MyBlockingQueue<T> {

    private Lock lock = new ReentrantLock();
    private Condition emptyCond = lock.newCondition();
    private Condition fullCond = lock.newCondition();
    private int size = 0;
    private int putIdx = 0;
    private int getIdx = 0;
    private Object[] array;
    private final int MAX_COUNT;

    public MyBlockingQueue(int maxCount) {
        MAX_COUNT = maxCount;
        array = new Object[maxCount];
        size = maxCount;
    }

    @SuppressWarnings("unchecked")
    public T get() throws InterruptedException {
        lock.lock();
        try {
            while (size <= 0) {
                emptyCond.await();
            }
            T result = (T) array[getIdx];
            size--;
            if (++getIdx >= array.length) {
                getIdx = 0;
            }
            fullCond.signal();
            return result;
        } finally {
            lock.unlock();
        }
    }

    @SuppressWarnings("unchecked")
    public void put(T element) throws InterruptedException {
        lock.lock();
        try {
            while (size >= MAX_COUNT) {
                fullCond.await();
            }
            array[putIdx] = element;
            size++;
            if (++putIdx >= array.length) {
                putIdx = 0;
            }
            emptyCond.signal();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        MyBlockingQueue<Integer> blockingQueue = new MyBlockingQueue<>(10);
        for (int i = 0; i < 9; i++) {
            int finalI = i;
            new Thread(() -> {
                while (true) {
                    try {
                        blockingQueue.put(finalI);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("投递" + finalI);
                }
            }).start();
        }

        for (int i = 0; i < 9; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        System.out.println("消费得到" + blockingQueue.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }
    }
}
