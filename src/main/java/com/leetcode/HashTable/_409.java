package com.leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;

public class _409 {


    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int flag = 0;
        for (char c : s.toCharArray()) {
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }

        for (int val : map.values()) {
            if (val % 2 == 0) {
                res += val;
            } else {
                if (flag == 0) {
                    res++;
                    flag++;
                }
                res += (val - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
