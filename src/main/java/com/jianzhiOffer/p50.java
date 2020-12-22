package com.jianzhiOffer;

/**
 * @author Zhancong Huang
 * @date 19:36 2019/4/23
 */
public class p50 {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length == 0) return false;
        for (int i = 0; i < numbers.length; i++) {
            while (i != numbers[i] && numbers[i] != numbers[numbers[i]]){
                swap(numbers, i, numbers[i]);
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != i) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    public  void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}