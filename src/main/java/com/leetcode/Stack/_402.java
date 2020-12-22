package com.leetcode.Stack;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * 过程在笔记..单调栈的经典应用。没有深入理解单调栈是做不出来的,
 * hard级别
 *
 * @author Zhancong Huang
 * @date 10:42 2018/11/15
 */
public class _402 {

    /**
     * 假设k* 正好是num构建递增站的pop次数（pop次数也就是删掉数字的次数），那么栈里剩下的数字一定是num删k*个数字后最小的，可以证明。
     * 问题k 不一定等于 k*
     */
    public static String removeKdigits(String num, int k) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                //k < k*
                //贪心的做法。保证栈底的尽量最小
                k--;
                stack.pop();
            }
            //牢记单调栈每个数字都有一次入栈
            stack.push(num.charAt(i));
        }
        //k > k* 这里也是贪心，同样努力让高位最小
        while (k > 0 && !stack.isEmpty()) {
            k--;
            stack.pop();
        }
        //拼接
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        //去除字符串前面的0.也是难点。循环指针指向第一个字母，为0后移，不为0的跳出循环
        //考虑最后剩下00001，和0000 两种情况
        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }
        //不能妄图通过long int转换，答案可能超过这两个的上限
        //return String.valueOf(Long.valueOf(sb.toString()));
        return i == sb.length() ? "0" : sb.substring(i);
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));
    }
}
