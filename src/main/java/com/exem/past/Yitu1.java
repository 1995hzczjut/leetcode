package com.exem.past;

import java.util.*;

/**
 * @author Zhancong Huang
 * @date 20:28 2019/9/19
 */
public class Yitu1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        helper(arr);
    }



    public static void helper(int[] arr) {
        if (arr.length < 1) return;
        Map<Integer, Integer> num2freq = new LinkedHashMap<>();
        for (int n : arr) {
            num2freq.put(n, num2freq.getOrDefault(n, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(num2freq.entrySet());
        list.sort(((o1, o2) -> o2.getValue() - o1.getValue()));

        for (Map.Entry<Integer, Integer> entry : list) {
            int v = entry.getValue(), k = entry.getKey();
            while (v-- > 0) {
                System.out.print(k + " ");
            }
        }
    }

}
