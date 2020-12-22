package com.yuanfudao;

import com.leetcode.Stack._402;

import java.util.ArrayDeque;

/**
 * @author Zhancong Huang
 * @date 0:18 2019/11/3
 * @see _402
 */
public class 一个n位数现在可以删除其中任意k位使得剩下的数最小 {

    public static String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while (k-- > 0) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        //不能妄图通过long int转换，答案可能超过这两个的上限
        //return String.valueOf(Long.valueOf(sb.toString()));
        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0'){
            i++;
        }
        return i == sb.length() ? "0" : sb.toString().substring(i, sb.length());
    }

    public static void main(String[] args) {
        System.out.println(String.valueOf(Integer.valueOf("000000")));
    }
}
