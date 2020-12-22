package com.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 非常标准的回溯题
 * 跟93题,剑指的通配符很像。不过那里最后不需要返回list.
 * 核心还是combination问题（中间仅考虑能不能走到（换句话说能不能加入tmp），能走到的话加入tmp,在起点才考虑合不合法,不合法他会吐出来），画图
 *              空
 *        a     aa     aab
 *      ab  a    b
 *          b
 *
 * @author Zhancong Huang
 * @date 18:59 2018/10/4
 */

public class _131 {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), s, 0);
        return res;
    }

    private void helper(List<List<String>> res, List<String> tmp, String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(tmp));
        }
        for (int i = start; i < s.length(); ++i) {
            String subString = s.substring(start, i + 1);
            //回溯
            if (!isPalidrome(subString)) continue;
            tmp.add(subString);
            helper(res, tmp, s, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    private boolean isPalidrome(String subString) {
        int start = 0, end = subString.length() - 1;
        while (start < end) {
            if (subString.charAt(start++) != subString.charAt(end--)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new _131().partition("abb"));
    }
}
