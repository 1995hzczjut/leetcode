package com.leetcode.TwoPointers;

/**
 * @author Zhancong Huang
 * @date 20:22 2019/5/4
 */
public class _567 {

    /**
     * 题目就是问 s1 是不是 s2的一个subString 的 permutation.
     * 做法是s2上滑动窗口，窗口大小是s1的大小。然后比较变成判断A是否是Bpermutation的问题（就是用charMap）
     * 注意数组越界
     */
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        char[] char_s1 = new char[26];
        char[] char_s2 = new char[26];
        for (int i = 0; i < s1.length(); ++i) {
            char_s1[s1.charAt(i) - 'a']++;
            char_s2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= s2.length() - s1.length(); ++i) {
            if (match(char_s1, char_s2)) return true;
            char_s2[s2.charAt(i) - 'a']--;
            if (i + s1.length() > s2.length() - 1) break;
            //这里小心越界。
            char_s2[s2.charAt(i + s1.length()) - 'a']++;
        }
        return false;
    }

    public static boolean match(char[] chars1, char[] chars2) {
        for (int j = 0; j < chars1.length; ++j) {
            if (chars1[j] != chars2[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidlboaoaoo"));
    }

}
