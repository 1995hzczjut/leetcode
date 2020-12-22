package com.jianzhiOffer;

import java.util.Arrays;

/**
 * 之前荷兰国旗问题的结果都不能保证稳定性.看清楚题目有没有说保证相对顺序
 * 这道题价值很高，回答了快排为何不稳定？如何改造成稳定性？
 *
 * @author Zhancong Huang
 * @date 23:35 2019/4/19
 */
public class p13 {

    /**
     * 基于插入排序，能保证稳定性
     * 思路/模板还是荷兰国旗问题，但是原生的荷兰国旗问题是直接交换less++和idx,会打乱less到idx的相对顺序，这就是不稳定的原因
     * 现在i用Arrays.copy的方式插入。保证了稳定性 。快排的稳定性改造可以参考。
     */
    public static void reOrderArray(int[] array) {
        int less = -1, idx = 0;
        while (idx < array.length) {
            if (array[idx] % 2 == 1) {
                //这里就是实现Arrays.copy
                int _idx = idx;
                while (_idx > less + 1) {
                    swap(array, _idx, --_idx );
                }
                less++;
            }
            idx++;
        }
    }

    /**
     * 基于快排的，无法保证稳定性。
     */
    public static void reOrderArray1(int[] array) {
        int less = -1, idx = 0;
        while (idx < array.length) {
            if (array[idx] % 2 == 1) {
                swap(array, ++less, idx++);
            } else {
                idx++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void moveRight(int[] arr, int start, int end){
        for (int i = end + 1; i > start ; i--) {
            arr[i] = arr[i - 1];
        }
    }

    public static void reOrderArray3(int[] array) {
        int less = -1, index = 0;
        while (index < array.length){
            if (array[index] % 2 == 0){
                index++;
            }else {
                //一开始这里array[++less] = array[index];
                // 没考虑到数组移动后，index上的值已经变化了
                int tmp = array[index];
                moveRight(array, less + 1, index - 1);
                array[++less] = tmp;
                index++;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 8, 5, 7, 2, 1, 6};
        reOrderArray3(nums);
        System.out.println(Arrays.toString(nums));
    }
}
