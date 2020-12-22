package com.jianzhiOffer;

/**
 * 多路归并排序问题，注意这里属于Distinct问题，所以要有多个指针指向的数字相等且是当前最小值，则一起移动
 *
 * @author Zhancong Huang
 * @date 13:25 2019/4/22
 */
public class p33 {

    /**
     * index=3,返回丑数序列下标为2的
     */
    public int GetUglyNumber_Solution(int index) {
        //题目要求的返回值，讲道理是不会存在这个丑数的
        if (index == 0) return 0;
        int[] factors = {2, 3, 5};
        int[] idxs = new int[3];
        int[] uglyNums = new int[index];
        uglyNums[0] = 1;

        for (int i = 1; i < index; i++) {
            int minValue = Math.min(factors[0] * uglyNums[idxs[0]], Math.min(factors[1] * uglyNums[idxs[1]],factors[2] * uglyNums[idxs[2]]));
            uglyNums[i] = minValue;
            //distinct
            for (int j = 0; j < 3; j++) {
                if (factors[j] * uglyNums[idxs[j]] == minValue){
                    idxs[j]++;
                }
            }
        }
        return uglyNums[index - 1];
    }
}
