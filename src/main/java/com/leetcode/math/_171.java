package com.leetcode.math;

public class _171 {

    /**
     * 与LC168一起看
     */
    public int titleToNumber(String s) {
        int len = s.length() - 1;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res + (s.charAt(i) - 'A' + 1) * helper(len - i);
        }
        return res;
    }

    private int helper(int n) {
        int res = 1;
        while (n-- > 0) {
            res = 26 * res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println('B' - 'A');
    }

}
