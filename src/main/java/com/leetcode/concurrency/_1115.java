package com.leetcode.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Zhancong Huang
 * @date 14:27 2019/7/18
 */
public class _1115 {
    static class FooBar {
        private int n;

        private int controlNum = 1;
        private Lock lock = new ReentrantLock();
        private Condition condOdd = lock.newCondition();
        private Condition condEven = lock.newCondition();
        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                lock.lock();
                try{
                    while (controlNum % 2 == 0){
                        condOdd.await();
                    }
                    printFoo.run();
                    controlNum++;
                    condEven.signal();
                }finally {
                    lock.unlock();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                lock.lock();
                try{
                    while (controlNum % 2 == 1){
                        condEven.await();
                    }
                    printBar.run();
                    controlNum++;
                    condOdd.signal();
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);

    }
}
