package com.leetcode.math;

import java.util.ArrayList;
import java.util.List;

public class _728 {


    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        while (left <= right) {
            int num = left;
            int flag = 0;
            while (num > 0) {
                int m = num % 10;
                if (m == 0 || left % m != 0) {
                    flag = 1;
                    break;
                }
                num = num / 10;
            }
            if (flag == 0) list.add(left);
            ++left;
        }
        return list;
    }


    public static void main(String[] args) {

    }

}
