package com.leetcode.array;

/**
 * @author Zhancong Huang
 * @date 20:37 2019/1/22
 * @see EmlementSwap
 * 问题背景一样，数组长度N，数组范围[0, N-1]。这个数组是在太特殊了
 * 在448 442 已经看到了
 * 这里又有一个性质：
 * i nums[i]  nums[nums[i]] ... i 这样不断循环 最后会回到起点i
 * 不同的起点 会有不同的循环路径例如题目的case 0 1 3 作为起点 循环路径都不一样
 * 现在要找最长的起点，为了避免重复计算 一个循环中 中间的点都不应再考虑，因为结果是一样的
 * 所以需要visited数组
 *
 * ===========================================
 * 补充：
 * 除了上述性质，如果有个数字重复了，还能把数组变成有环链表，通过找环起点的方法去找到重复数字
 * 不同起点决定了，非环链表的长度。
 * 没有重复，全是环。起点不同，环长度不同。
 * 同一个环中，不同的起点，环的长度又是一样的。
 */
public class _565 {
    public int arrayNesting(int[] nums) {
        int res = 0;
        boolean[] used = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(used[nums[i]]) continue;
            res = Math.max(res, helper(nums, nums[i], used));
        }
        return res;
    }

    /**        idx
     * index:   s       A[s]         A[A[s]]
     * num:    A[s]    A[A[s]]       A[A[A[s]]]
     * 这里逻辑小心,start是数字
     */
    public int helper(int[] nums, int start, boolean[] used){
        System.out.println("start: " + start);
        int cnt = 0;
        int idx = start;
        while (cnt == 0 || nums[idx] != nums[start]){
            used[idx] = true;
            idx = nums[idx];
            cnt++;
        }
        return cnt;
    }
}
