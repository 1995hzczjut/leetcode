package com.leetcode.Stack;

/**
 * 非常厉害的解法
 *
 * @author Zhancong Huang
 * @date 19:08 2019/6/13
 */
public class _738 {
    public static int monotoneIncreasingDigits(int N) {
        char[] ch = String.valueOf(N).toCharArray();
        int mark = ch.length;

        //如果数组存在一个连续pair,是降序，那么pair[0]必定减小，想要最后修改后的数字最大
        //修改的数字后面只能全部为9
        for (int i = ch.length - 1; i > 0; i--) {
            if (ch[i] < ch[i - 1]) {
                mark = i - 1;
                ch[i - 1]--;
            }
        }
        for (int i = mark + 1; i < ch.length; i++) {
            ch[i] = '9';
        }
        return Integer.parseInt(new String(ch));
    }

    public static void main(String[] args) {

    }
}
