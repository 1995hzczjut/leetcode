package com.jianzhiOffer;

/**
 * 34512 选3作为target写不出来的
 *
 * @author Zhancong Huang
 * @date 22:47 2019/4/16
 */
public class p6 {
    public int minNumberInRotateArray(int[] array) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (array[mid] > array[array.length - 1]){
                left = mid + 1;
            }else {
                right = right - 1;
            }
        }
        return array[left];
    }
}
