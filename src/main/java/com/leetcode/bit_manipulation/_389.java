package com.leetcode.bit_manipulation;

/**
 * 异或
 *
 * @author Zhancong Huang
 * @date 20:50 2019/7/4
 */
public class _389 {
    public static char findTheDifference(String s, String t) {
        //0与任何异或都是它本身.0正好也对应空串
        char res = 0;
        for (char c : s.toCharArray()) {
            res ^= c;
        }
        for (char c : t.toCharArray()) {
            res ^= c;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("", ""));
    }
}
