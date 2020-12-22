package com.leetcode.array;

/**
 * 20143 这种数组非常特殊，本身是乱序的，数字对应它正确的下标。所以当i指向2时，2正确的
 * 位置就是下标2.要使chunk最多，2代表的块最窄（贪心）
 * 关键：
 * 这个块最窄，那么排序后2是这个块的右边界，即下标<=2的位置不能有大于2的
 * 如果有x>2，那么这个块要变大，变为下标<=x的位置不能有大于x的。直到末尾
 * 具体在写的时候，对应for循环里边界边找边改变（这种场景以前没出现过）。
 *
 * @author Zhancong Huang
 * @date 22:39 2019/1/29
 */
public class _769 {
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int i = 0;
        while (i < arr.length) {
            int cur = arr[i];
            int j = i + 1;
            for (; j <= cur; j++) {
                cur = Integer.max(cur, arr[j]);
            }
            i = j;
            res++;
        }
        return res;
    }
}
