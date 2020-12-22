package com.leetcode.slidingWindow;

import com.leetcode.slidingWindow.SlidingWindowUtil;

/**
 * 严格遵守模板错不了
 *
 * @see SlidingWindowUtil#findMaxWindow(int[])
 * @author Zhancong Huang
 * @date 22:24 2019/3/19
 */
public class _713 {

    /**
     * 说了都是正数，这种题目一眼看到就知道大概思路了
     * （1）要求subset，combination模板
     * （2） subarray, DP，找以一个数为底的最长的数组，乘积<k,然后累加
     * 上述就是进化成DP里特殊的滑动窗口问题
     * 找最大的小于K的窗口，但又跟之前的标准模板不一样，这里不求全局最大窗口
     * 而是累加每个right处的最大合法窗口值（Nums都是正数）。代码遵守模板。
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0;
        int left = 0, right = 0;
        //监控窗口合法性的变量，这里时乘积，防止溢出
        long product = 1;
        for (; right < nums.length; right++) {
            product *= nums[right];
            if (product < k) {
                //合法
            } else {
                //不合法
                while (product >= k && left <= right) {
                    product /= nums[left++];
                }
            }
            //模板是求极值，这里是累计
            result += right - left + 1;
        }
        return result;
    }



}
