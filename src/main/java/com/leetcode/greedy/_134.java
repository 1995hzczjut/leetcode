package com.leetcode.greedy;

import java.util.Arrays;

/**
 * 看起来很简单，根本证不出来
 * https://www.cnblogs.com/felixfang/p/3814463.html
 * 推论：对于一个循环数组，如果这个数组整体和 SUM >= 0，那么必然可以在数组中找到这么一个元素：从这个数组元素出发，绕数组一圈，能保证累加和一直是出于非负状态。
 * 上面的推论是核心，暂时证明不了
 *
 * @author Zhancong Huang
 * @date 22:53 2018/11/14
 */
public class _134 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        //首先看总体和。根据上述推论，一定存在一个起点。
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) return -1;
        //
        int sum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            //肯定能走到i，sum>0代表还能跳到i-1;sum<0，不能往下走了。新的起点i-1
            //前面全都不行，【重点】前面的点每次走到时，带着的gas肯定大于0，大于0都不行，那作为起点初始gas=0更加不行
            sum += gas[i] - cost[i];
            if (sum < 0){
                start = i + 1;
                sum = 0;
            }
        }
        return start;
    }

    public static void main(String[] args) {

    }
}
