package com.jianzhiOffer;

import java.util.Arrays;

/**
 * https://www.nowcoder.com/questionTerminal/96bd6684e04a44eb80e6a68efc0ec6c5
 * 非常巧的做法。复杂度为nlogn.
 * 借用归并排序的壳，每次找当前比较的两个区间的，另一个区间里大于当前数字的逆序对。
 * 就算对方区间排序过了也无影响吗，相对顺序还是对的
 *
 * @author Zhancong Huang
 * @date 14:02 2019/4/22
 */
public class p35 {

    int cnt = 0;

    public int InversePairs(int[] array) {
        mergeSort0(array, 0, array.length - 1);
        return cnt;
    }

    private void mergeSort0(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) >> 1;
        mergeSort0(nums, left, mid);
        mergeSort0(nums, mid + 1, right);
        int p = left, q = mid + 1, i = 0;
        int[] temp = new int[right - left + 1];
        while (p <= mid && q <= right) {
            if (nums[p] <= nums[q]) {
                temp[i++] = nums[p++];
            } else if (nums[p] > nums[q]) {
                //core code: 只能算左边区间大于当前数字的个数。自己右边区间的不能算。
                //这里有问题：这么算的逆序对以q为右边界的。假设以p为左边界，那么现在q动，p不动，就造成了重复计算。
                //因此只能计算动的那个指针作为边界的情况
                //这部分算完，再递归上去
                cnt += (mid - p + 1) % 1000000007;
                temp[i++] = nums[q++];
            }
        }
        //不能再one-pass了
        while (p <= mid) {
            temp[i++] = nums[p++];
        }
        while (q <= right) {
            temp[i++] = nums[q++];
        }
        for (int j = left; j <= right; j++) {
            nums[j] = temp[j - left];
        }
    }

    /**
     * 不知道哪里错了，就是有一半通不过
     */
    static class  ERROR{
        public int InversePairs(int[] array) {
            if (array == null || array.length < 2) return 0;
            return helper(array, 0, array.length - 1);
        }

        /**
         * 返回的逆序对一定是一个在Mid左边，一个在Mid右边。
         * 然后递归计算每个子数组的逆序对
         * 经常范的错误，递归中数组起点不是0。
         */
        private int helper(int[] array, int start, int end) {
            //数组递归第一行就要想到终止条件
            if (start >= end) return 0;

            int mid = (start + end) >> 1;
            int result = helper(array, start, mid) + helper(array, mid + 1, end);
            //merge
            int[] tmp = new int[end - start + 1];
            int p = start, q = mid + 1, idx = 0;
            while (p <= mid && q <= end) {
                if (array[p] <= array[q]) {
                    tmp[idx++] = array[p++];
                } else {
                    //p>q,p所在的是递增的，即p后面的跟q都能组成逆序对
                    result += (mid - p + 1) % 1000000007;
                    tmp[idx++] = array[q++];
                }
            }
            while (p <= mid) {
                tmp[idx++] = array[p++];
            }
            while (q <= end) {
                tmp[idx++] = array[q++];
            }
            //把临时数组替掉原始数组
            for (int i = 0; i < tmp.length; i++) {
                array[start + i] = tmp[i];
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(new p35().InversePairs(nums));
        System.out.println(Arrays.toString(nums));
    }
}
