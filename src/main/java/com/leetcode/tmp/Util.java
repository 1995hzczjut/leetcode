package com.leetcode.tmp;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Zhancong Huang
 * @date 10:54 2019/8/23
 */
public class Util {

    private static Random rand = new Random();

    public static void shuffle(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int idx = rand.nextInt(i);
            swap(arr, i, idx);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int[] copy(int[] arr){
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static boolean equals(int[] arr1, int[] arr2){
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 0};
        shuffle(nums);
        System.out.println(Arrays.toString(nums));
    }
}
