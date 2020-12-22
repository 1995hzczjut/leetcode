package com.leetcode.math;

/**
 * @author Zhancong Huang
 * @date 13:11 2019/4/16
 */
public class _313 {
    /**
     * 输入0单独拿出来。
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 0) {
            return 1;
        }
        //丑数序列
        int[] uglyNums = new int[n];
        //merger的指针。
        int[] idxs = new int[primes.length];
        uglyNums[0] = 1;
        for (int i = 1; i < n; i++) {
            //找到现在idxs指针种最小的那个
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < idxs.length; j++) {
                min = Math.min(min, uglyNums[idxs[j]] * primes[j]);
            }
            uglyNums[i] = min;
            //去重，如果等于Min,idx进一位
            for (int j = 0; j < idxs.length ; j++) {
                if (min == uglyNums[idxs[j]] * primes[j]){
                    idxs[j]++;
                }
            }
        }
        return uglyNums[n - 1];
    }

}
