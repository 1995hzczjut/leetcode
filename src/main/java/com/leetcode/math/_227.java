package com.leetcode.math;



/**
 * 经典的后缀表达式问题，注意题目说字符串中有空格。不用栈，用栈反而难写
 * 表达式看成 块 +/- 块 +/- 块.起始自带0+，搞清变量的含义
 *
 * @author Zhancong Huang
 * @date 19:22 2019/5/7
 */
public class _227 {
    /**
     * 正解
     */
    public static int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int res = 0;
        //prevNum 永远表示两个op前的数字
        //-64*2*2 指向最后一个*时，curNum=2，prevNum=-64。下一步curNum要接受其他数字了，prevNum变为-128
        int prevNum = 0;
        //整个s前面隐含0+
        char prevOp = '+';
        //永远表示当前c之前的数字，可能是负值
        int curNum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                curNum = curNum * 10 + c - '0';
                continue;
            }
            if (prevOp == '+') {
                System.out.println(String.format("prevOP:%s, prevNum:%s, curNum:%s, curOp:%s"
                        , prevOp, prevNum, curNum, c));
                res += prevNum;
                prevNum = curNum;
            } else if (prevOp == '-') {
                System.out.println(String.format("prevOP:%s, prevNum:%s, curNum:%s, curOp:%s"
                        , prevOp, prevNum, curNum, c));
                //负号归属于当前一块，每一块的分割符号只能是+
                res += prevNum;
                prevNum = -curNum;
            } else if (prevOp == '*') {
                System.out.println(String.format("prevOP:%s, prevNum:%s, curNum:%s, curOp:%s"
                        , prevOp, prevNum, curNum, c));
                prevNum *= curNum;
            } else if (prevOp == '/') {
                System.out.println(String.format("prevOP:%s, prevNum:%s, curNum:%s, curOp:%s"
                        , prevOp, prevNum, curNum, c));
                prevNum /= curNum;
            }
            //curName清空
            curNum = 0;
            prevOp = c;
        }
        System.out.println(String.format("处理剩余值 prevOP:%s, prevNum:%s, curNum:%s"
                , prevOp, prevNum, curNum));
        //单独处理
        if (prevOp == '+') {
            res += prevNum + curNum;
        } else if (prevOp == '-') {
            res += prevNum - curNum;
        } else if (prevOp == '*') {
            res = res + prevNum * curNum;
        } else if (prevOp == '/') {
            res = res + prevNum / curNum;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(calculate("4/3+2"));
    }
}
