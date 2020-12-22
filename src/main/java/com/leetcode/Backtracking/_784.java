package com.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhancong Huang
 * @date 0:18 2019/5/24
 */
public class _784 {

    /**
     *
     */
    public List<String> letterCasePermutation(String S) {
        char[] chars = S.toCharArray();
        List<String> res = new ArrayList<>();
        helper(res, chars, 0);
        return res;
    }

    /**
     * 一开始的想法，每次里面拷贝chars。要超出存储要求
     * 类似于先序遍历二叉树，叶子节点对应不同的状态，最后收入res.
     */
    private void helper(List<String> res, char[] chars, int start) {
        System.out.println(new String(chars));
        if (start == chars.length) {
            res.add(new String(chars));
            return;
        }
        if (Character.isDigit(chars[start])) {
            helper(res, chars, start + 1);
            return;
        }
        chars[start] = Character.toLowerCase(chars[start]);
        helper(res, chars, start + 1);
        chars[start] = Character.toUpperCase(chars[start]);
        helper(res, chars, start + 1);
    }

    public static void main(String[] args) {
        new _784().letterCasePermutation("abc");
    }
}
