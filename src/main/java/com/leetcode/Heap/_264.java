package com.leetcode.Heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *  Hard级别，难在分析的过程。一个丑数序列怎么分解为下面三条，然后再merge。需要数学推理
 * 丑数生成问题。
 * 丑数序列：1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
 * 【关键】在于所有丑数可以被分为这样的三组.不理解下面的分组没法做。
 * (1) 1×2, 2×2, 3×2, 4×2, 5×2, …（第一个丑数*2，第二个丑数*2，第三个丑数*2，第四个丑数*2）
 * (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
 * (3) 1×5, 2×5, 3×5, 4×5, 5×5, …
 * 即用【丑数序列】分别乘以因子。这样得到的3个【递增】的序列，可以参照merge sort。但是要注意重复。
 * 补充：第一行2前面乘的是第一个丑数，第二个丑数，第三个丑数。。。
 * 也可以用heap去除重复的。
 * <p>
 * 4.15补充：
 * 核心在于对丑数的理解。丑数只有235三个因子。因此可以分为3种: 能整除2，能整除3,能整除5
 * 且除以2，3，5后还是丑数。
 * 因此假设{n}是丑数序列。其乘以2，3，5后得到上述3个序列。最重要的是丑数序列除完235还是丑数序列。丑数序列无限
 * 一开始是第一个丑数乘以235
 *
 * @author Zhancong Huang
 * @date 21:36 2018/9/15
 */
public class _264 {
    //类似merge sort移动指针的做法。
    //指针就是丑数序列的索引。
    public static int nthUglyNumber(int n) {
        if (n == 0) {
            return 1;
        }
        int[] uglyNums = new int[n];
        int[] factors = {2, 3, 5};
        int[] idxs = {0, 0, 0}; //merge的指针。存放的丑数数组的索引
        uglyNums[0] = 1;
        for (int i = 1; i < n; i++) {
            uglyNums[i] = Math.min(Math.min(uglyNums[idxs[0]] * factors[0], uglyNums[idxs[1]] * factors[1]), uglyNums[idxs[2]] * factors[2]);
            //下面3个分支可能执行2个以上
            if (uglyNums[i] == uglyNums[idxs[0]] * factors[0]) {
                idxs[0]++;
            }
            if (uglyNums[i] == uglyNums[idxs[1]] * factors[1]) {
                idxs[1]++;
            }
            if (uglyNums[i] == uglyNums[idxs[2]] * factors[2]) {
                idxs[2]++;
            }
        }
        return uglyNums[n - 1];
    }

    /**
     * 推荐做法。每次放3个进来，poll出最小的。理论分析看类注释
     */
    public static int nthUglyNumber1(int n) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(1);
        while (n-- > 1) {
            int uglyNum = queue.poll();
            //为了去重，写一下就知道了
            while (!queue.isEmpty() && queue.peek() == uglyNum) {
                queue.poll();
            }
            queue.offer(2 * uglyNum);
            queue.offer(3 * uglyNum);
            queue.offer(5 * uglyNum);
        }
        return queue.poll();
    }

    //313 题目重复了
    public static int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 0) {
            return 1;
        }
        int[] uglyNums = new int[n];
        int[] idxs = new int[primes.length];
        uglyNums[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int minIndx = 0;
            //下面两个pass 可以合起来。有一点很绕
//            for (int j = 0; j < primes.length; ++j) {
//                if (uglyNums[idxs[j]] * primes[j] < min) {
//                    min = uglyNums[idxs[j]] * primes[j];
//                }
//            }
//            uglyNums[i] = min;
//
//            for (int j = 0; j < primes.length; ++j) {
//                if (uglyNums[i] == uglyNums[idxs[j]] * primes[j]) {
//                    idxs[j]++;
//                }
//            }
            //one-pass做法
            for (int j = 0; j < primes.length; ++j) {
                if (uglyNums[idxs[j]] * primes[j] < min) {
                    min = uglyNums[idxs[j]] * primes[j];
                    minIndx = j;
                    //就是min是中间值。万一不是这一轮的最小。其实也没关系。只是要一个最小值。两个一样的也是输出一样的。
                } else if (uglyNums[idxs[j]] * primes[j] == min) {
                    idxs[j]++;
                }
            }
            uglyNums[i] = min;
            idxs[minIndx]++;
        }
        System.out.println(uglyNums[n - 1]);
        return uglyNums[n - 1];
    }

    public static void main(String[] args) {
        int n = 15;
        while (--n > 0) {
            nthSuperUglyNumber(n, new int[]{2, 3, 5});
        }

    }
}
