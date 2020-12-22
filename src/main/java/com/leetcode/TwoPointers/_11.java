package com.leetcode.TwoPointers;

/**
 * 做法跟2sum_sorted很像
 *
 * @author Zhancong Huang
 * @date 10:36 2019/8/11
 */
public class _11 {

    /**
     * 复杂度暴力N^2  要求N
     * 复杂度可以降低是题目背景隐含了一个条件，可以减少搜索步骤：
     * 两个指针指的数字代表两个柱子，长的柱子往短的柱子移动，容量必然降低。
     * 最后求能装的最大容量
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while (left < right) {
            result = Math.max(result, (right - left) * (Math.min(height[left], height[right])));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

}
