package com.leetcode.array;

/**
 * @author Zhancong Huang
 * @date 21:00 2019/11/23
 */
public class _42 {

    /**
     * 有额外空间的做法.在一个点能不能积水，看它左边的最大高度，和右边的最大高度，两者选一个最小的。
     * 这个最小的值大于当前高度才可以积水
     * 最直观的做法，开两个数组，代表包含当前下标左右两边最大的值，然后计算
     */
    public int trap1(int[] height) {
        if (height.length < 2) return 0;
        int[] leftMax = new int[height.length];
        int result = 0;
        int rightMax = height[height.length - 1];

        for (int i = 0; i < leftMax.length; i++) {
            leftMax[i] = i == 0 ? height[i] : Math.max(leftMax[i - 1], height[i]);
        }

        for (int i = height.length - 2; i >= 0; i--) {
            rightMax = Math.max(height[i], rightMax);
            int minMax = Math.min(leftMax[i], rightMax);
            result += minMax - height[i];
        }

        return result;
    }


    /**
     * 没有额外空间，只能双指针。
     * leftmax  l  r  rightmax
     * 关键一点是上述这种情况，对l来说，leftmax才是真实的最值，而rightmax不一定
     * 因为l到r还是未知的，可能出现比rightmax更大（小）的值。
     * 所以leftmax<rightmax的话，只有l能确定积水，l到r如果有比leftmax小的，
     * 那不影响。如果有大的，已经有leftmax<rightmax保证了，积水的量还是以leftmax为关键
     */
    public int trap(int[] height) {
        if (height.length < 2) return 0;
        int left = 0, right = height.length - 1;
        int leftMax = -1, rightMax = -1;
        int result = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax <= rightMax) {
                result += leftMax - height[left++];
            } else {
                result += rightMax - height[right--];
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
