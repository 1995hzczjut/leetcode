package com.leetcode.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Zhancong Huang
 * @date 13:13 2019/7/18
 */
public class _1114 {

    static class Foo {

        private int controlnNum = 1;
        private Lock lock = new ReentrantLock();
        private Condition condFirst = lock.newCondition();
        private Condition condSecond = lock.newCondition();
        private Condition condThirst = lock.newCondition();

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            lock.lock();
            try{
                while (controlnNum != 1){
                    condFirst.await();
                }
                printFirst.run();
                controlnNum++;
                condSecond.signal();
            }finally {
                lock.unlock();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            lock.lock();
            try{
                while (controlnNum != 2){
                    condSecond.await();
                }
                printSecond.run();
                controlnNum++;
                condThirst.signal();
            }finally {
                lock.unlock();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            lock.lock();
            try{
                while (controlnNum != 3){
                    condThirst.await();
                }
                printThird.run();
                controlnNum++;
                condFirst.signal();
            }finally {
                lock.unlock();
            }
        }
    }
}
