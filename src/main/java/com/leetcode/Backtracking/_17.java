package com.leetcode.Backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Zhancong Huang
 * @date 20:24 2019/5/6
 */
public class _17 {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * Combination 问题的变形
     * 理解题意，画图，发现跟Combination遍历方式一样，套模板，测一下corner case，结束
     */
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return  new LinkedList<String>();
        }
        List<String> result = new LinkedList<String>();
        helper(new StringBuilder(), 0, digits, result);
        return result;
    }

    private void helper(StringBuilder tmp, int start, String digits, List<String> result) {
        if (start == digits.length()) {
            result.add(tmp.toString());
            return;
        }
        //注意‘2’ 是Int50
        String s = KEYS[digits.charAt(start) - '0'];
        //s是空的话for跳过， 最后是没有结果的。
        if (s.length() == 0) {
            helper(tmp, start + 1, digits, result);
        } else {
            for (int i = 0; i < s.length(); i++) {
                tmp.append(s.charAt(i));
                helper(tmp, start + 1, digits, result);
                tmp.deleteCharAt(tmp.length() - 1);
            }
        }
    }
}
