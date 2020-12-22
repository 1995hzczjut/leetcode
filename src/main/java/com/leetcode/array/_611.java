package com.leetcode.array;

import java.util.Arrays;

/**
 * o(N)肯定不现实，那先排序。
 *
 * @author Zhancong Huang
 * @date 19:44 2019/1/22
 */
public class _611 {
    /**
     * 三角形是要求最小的两个边和大于第三边。因此很自然的想到先排序
     * 排序后可以用两分了
     */
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int idx = findFirstLargerEqual(nums, j + 1, n - 1, nums[i] + nums[j]);
                //返回-1的话 说明j后面所有数字都小target，那要全部加上了
                res += (idx != -1 ? idx - j - 1 : n - j - 1);
            }
        }
        return res;
    }

    /**
     * 找到第一个大于等于target的数。找不到返回-1
     * 两分搜索一定要注意找不到对应的情况
     */
    private int findFirstLargerEqual(int[] nums, int left, int right, int target) {
        int end = right;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] >= target) {
                right = mid - 1;
            }
        }
        if (left <= end) {
            return left;
        } else {
            return -1;
        }
    }
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 4};
        System.out.println(new _611().triangleNumber(nums));
        //System.out.println(new _611().findFinalSmaller(nums, 2, 3, 4));
    }

}
