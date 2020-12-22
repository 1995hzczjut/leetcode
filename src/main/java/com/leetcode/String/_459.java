package com.leetcode.String;

public class _459 {

    /**
     * 题目问s 是否是abcabcabc这样的循环字符串构成的。
     * 从0开始逐个选sub，然后看多个sub能否组成s
     * 这一步可以不断用String.startwith看
     */
    public static boolean repeatedSubstringPattern1(String s) {
        if (s.length() <= 1) return false;
        for (int i = 1; i <= s.length() / 2; ++i) {
            if (s.length() % i == 0) {
                String sub = s.substring(0, i);
                if (dfs(s, sub, i)) return true;
            }
        }
        return false;
    }

    public static boolean dfs(String s, String sub, int i) {
        if (i == s.length()) return true;
        if (!s.startsWith(sub, i)) return false;
        return dfs(s, sub, i + sub.length());
    }


    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern1("abcabc"));
    }

}
