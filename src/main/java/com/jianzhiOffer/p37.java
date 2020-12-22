package com.jianzhiOffer;

/**
 * 两次两分减一下就是了。logN
 * 复习两分写法：
 * 卡位置（一定要思考找不到时的指针卡位）-》确定返回-》思考单个数字情况确定等于时谁动-》是否需要最后check指针合法性
 *
 * @author Zhancong Huang
 * @date 15:24 2019/4/22
 */
public class p37 {
    public int GetNumberOfK(int[] array, int k) {
        int left = findFirstEqual(array, k);
        int right = findLastEqual(array, k);
        return left == -1 ? 0 : right - left + 1;
    }

    /**
     * 2019年8月22日：例如k=3, 23334确定出返回left，3 确定出等于时right动， 4 确定出需要校验left，应为规定是找不到返回-1。
     * 还有两分的本质是根据中点根target关系，划掉一半，不要再写出right--;这种复杂度是O（N）,也有这种题目
     * right=mid-1 才是logN
     */
    public int findFirstEqual(int[] array, int k) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (array[mid] >= k) right = mid - 1;
            else left = mid + 1;
        }
        if (left >= array.length || array[left] != k) {
            return -1;
        } else {
            return left;
        }
    }

    public int findLastEqual(int[] array, int k) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (array[mid] > k) right = mid - 1;
            else left = mid + 1;
        }
        if (right < 0 || array[right] != k) {
            return -1;
        } else {
            return right;
        }
    }
}
