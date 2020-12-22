package com.leetcode.TwoPointers;

import java.util.Arrays;
import java.util.List;

/**
 * 删掉几个字符能否变成某个字符串 =》 是不是子序列
 * 里面哪个小问题就是LC 392 792的问题，题目的返回看题意，先看长度再看字典序
 *
 * @author Zhancong Huang
 * @date 20:22 2019/5/4
 */
public class _524 {
    public static String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String t : d) {
            if (helper(s, t)) {
                if (res.length() < t.length() || (res.length() == t.length() && t.compareTo(res) < 0)){
                    res = t;
                }
            }
        }
        return res;
    }

    private static boolean helper(String s, String t) {
        if (s == null) return false;
        int i = 0;
        for (int k = 0; k < s.length(); k++) {
            if (s.charAt(k) == t.charAt(i)) {
                if (++i == t.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //System.out.println(helper("abpcplea", "ale"));
        System.out.println(findLongestWord("abpcplea", Arrays.asList("ale","apple","monkey","plea")));
    }
}
