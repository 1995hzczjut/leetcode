package com.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/** 非常标准的回溯。回溯条件：【不管有多少well-formed的括号组】+ 【）：永远完不成，需要回溯 | （ ：还有机会，再找】
 * @author Zhancong Huang
 * @date 21:12 2018/10/30
 */
public class _22 {

    /**
     * 画图还是Combination做法，巧在回溯。
     *leftRemain, rightRemain 代表左右括号还剩多少可以写，在写的过程中，leftRemain > rightRemain代表不用继续了，可以回溯了
     */
    public List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<>();
        List<String> res = new LinkedList<>();
        helper(new StringBuilder(), res, n, n);
        return res;
    }

    private void helper(StringBuilder tmp, List<String> res, int leftRemain, int rightRemain) {
        if (leftRemain < 0 || rightRemain < 0 || leftRemain > rightRemain) return;
        if (leftRemain == 0 && rightRemain == 0) {
            res.add(tmp.toString());
        }
        tmp.append("(");
        helper(tmp, res, leftRemain - 1, rightRemain);
        tmp.deleteCharAt(tmp.length() - 1);
        tmp.append(")");
        helper(tmp, res, leftRemain, rightRemain - 1);
        tmp.deleteCharAt(tmp.length() - 1);
    }
    public static void main(String[] args) {

    }
}
