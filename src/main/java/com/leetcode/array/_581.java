package com.leetcode.array;

/**
 * 复杂要求O（N），比较难想到。
 * 思路：给定数组nums,假设排序后的是sorted_nums，题目最终就是要找到这个集合 {i|nums[i] != sorted_nums[i]}
 * 最左，最右的i，然后返回。
 * 找这个i答案里没有用排序，而是看i所在的数字是不是它左边还是右边最大或者最小的数，
 * 因为一个有序数组，某个数字一定是它边还是右边最大或者最小的数
 *
 * @author Zhancong Huang
 * @date 13:14 2019/9/29
 */
public class _581 {

    /**
     * 首先[l_real,r_real]是要排序的结果，l从右向左遍历， l如果不是其右闭区间的最小值
     * 那么[l,EOF]必然要发生排序，因为有序的话这块的最小值要必然在l处。但是不一样要全部排序，可能右边右一块有序。所以需要r_real。
     * 如果l其右闭区间的最小值,那么当前l不用参与排序，即l_real不用更新。
     * 最终l_real左边都满足 当前指针所在数是其右闭区间最小值。那么保证l_real是有序的。
     * 特别注意 里面更新条件是 != 。及思考出现等于最小值的情况，应该是不更新的，保证中间距离最短。
     */
    public  int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int l_real = 0;
        int r_real = -1;
        for (int l = nums.length - 1, r = 0; l >= 0; --l, r++) {
            min = Math.min(min, nums[l]);
            if (nums[l] != min) {
                l_real = l;
            }
            max = Math.max(max, nums[r]);
            if (nums[r] != max) {
                r_real = r;
            }
        }
        return r_real - l_real + 1;
    }



}
