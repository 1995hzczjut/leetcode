package com.leetcode.dp;

/**
 * 优先掌握DP的，DP的处理隐含一个贪心的选择
 *
 * @author Zhancong Huang
 * @date 23:01 2018/11/28
 */
public class _376 {

    /**
     * 评论区的一句话是关键，里面隐含了一个贪心的选择：
     * assume down[i-1] end with a, if down[i-1] not end with nums[i-1], then nums[i-1] must > a,
     * so nums[i] > nums[i-1] > a, then up[i] = down[i-1]+1 is still valid.
     * 看起来很简单的转移，里面的理解有点复杂
     * 是subsequence问题，up[i]和down[i]都代表到i为止，前者代表到i为止wiggle串最后一个数字处于down状态，vice verse
     * 假设现在nums[i]大于它前面一个，即自己处于up状态.
     * 计算up[i]:明显依赖down[i-1]，关键是down[i-1]不能反应出最后一个数字的位置？
     * 其实没有影响，假设down[i-1]代表的 wiggle串 ends with 数字a,a不一定位于idx i-1,
     * 假设nums[i-1]一定>a,因为等于肯定不行，如果小于a，那么根据贪心down[i-1]代表的 wiggle串 ends with 最后一个数字
     * 例如[3,7,5,4]，375满足要求，374也满足，选哪个？
     * 由于后面情况未知，肯定选374.
     * 总结：nums[i] > nums[i-1]，nums[i] 一定大于 到i-1为止最后一个数字处于down的wiggle串的最后一个数字
     *       DP代表的含义与常规Subsequence 问题一致，都是到XX为止
     */
    public static int wiggleMaxLengthDP(int[] nums) {
        if (nums.length == 0) return 0;

        int[] up = new int[nums.length];
        int[] down = new int[nums.length];

        up[0] = 1;
        down[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }

        return Math.max(down[nums.length - 1], up[nums.length - 1]);
    }

    public static void main(String[] args) {
//        int[] nums1 = new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
//        int[] nums2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//        System.out.println(wiggleMaxLength1(nums1));
//        System.out.println(wiggleMaxLength1(nums2));
        //int[] nums3 = new int[]{443,123,59,358,241,157,157,134,109,185};
        int[] nums3 = new int[]{5, 10, 4, 3, 2};
        System.out.println("========");
        System.out.println(wiggleMaxLengthDP(nums3));
    }

}
