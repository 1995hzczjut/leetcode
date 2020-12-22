package com.leetcode.concurrency;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 改成三个condition也是一样的。
 * 重点保证最后没有线程阻塞，这个是很考验细节的。关键在于理解输出最后个数字时，其他线程的状态，以及阻塞状态时全局n值已经跟阻塞前不一样了
 *
 * @author Zhancong Huang
 * @date 15:08 2019/7/18
 */
public class _1116 {

    static class IntConsumer {
        public void accept(int num) {
            System.out.println(num);
        }
    }

    /**
     * 开始提议理解错了 n=5 0102030405 even输出2次 odd输出3次
     */
    static class ZeroEvenOdd {
        private int n;

        private boolean isZero = true;
        private int controlNum = 1;
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            while (n > 0) {
                lock.lock();
                try {
                    while (!isZero) {
                        condition.await();
                    }
                    //关键。n=0代表，（假设输入n=2），0102已经输出，此时even释放锁，并唤醒所有线程一起来排队抢
                    //此时isZero=true，odd线程必然阻塞，而zero线程唤醒，此时不应该输出，所以加n!=0的判断
                    //最关键的是注意n!=0还要继续唤醒，这是为了（此时even由于while不满足线程回收了）唤醒阻塞中的even线程
                    //唤醒之后也发现n=0，此时所有线程安全退出
                    if (n != 0) {
                        printNumber.accept(0);
                    }
                    isZero = false;
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            while (n > 0) {
                lock.lock();
                try {
                    while (isZero || controlNum % 2 == 1) {
                        condition.await();
                    }
                    if (n == 0) return;
                    printNumber.accept(controlNum);
                    controlNum++;
                    isZero = true;
                    n--;
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            while (n > 0) {
                lock.lock();
                try {
                    while (isZero || controlNum % 2 == 0)  {
                        condition.await();
                    }
                    //这行挺难想到的，发生的原因时，odd这里释放锁。然后odd又竞争成功了，再回复的时候n=0了，但还是会输出
                    if (n == 0) return;
                    printNumber.accept(controlNum);
                    controlNum++;
                    isZero = true;
                    n--;
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        IntConsumer intConsumer = new IntConsumer();
        new Thread(() -> {
            try {
                zeroEvenOdd.even(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(1000);
        System.out.println();
    }
}
