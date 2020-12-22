package com.leetcode.array;

/**
 * @author Zhancong Huang
 * @date 12:34 2019/1/9
 */
public class _88 {

    /**
     * 要把nums2 移到 nums1 。肯定不能利用额外空间。
     * 原始的merge是两个指针在头部，这样需要额外的地方存。所以不行，考虑到nunm1后半部分是用不到的，所以应该两个指针从尾部移动
     * 好像有错，下面对的
     * @param m 前m个数
     * @param n 前n个数
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1;
        int q = n - 1;
        int k = m + n - 1;
        while (p >= 0 && q >= 0) {
            if (nums1[p] < nums2[q]) {
                nums1[k--] = nums2[q--];
            } else {
                nums1[k--] = nums1[p--];
            }
        }
        //如果p还有的多，不用管。因为要求移到1
        while (q >= 0) {
            //此时p<0
            nums1[k--] = nums1[q--];
        }
    }

    /**
     * 简化。
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1;
        int q = n - 1;
        int k = m + n - 1;
        while (q >= 0) {
            nums1[k--] = p < 0 || nums1[p] < nums2[q] ? nums1[q--] : nums2[p--];
        }
    }

    public static void main(String[] args) {
        new _88().merge2(new int[]{}, 0, new int[]{1}, 1);
    }
}
