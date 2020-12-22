package com.leetcode.String;

import java.util.Stack;

public class _20 {

    /**
     * ()[]{} 思路就是遇到左边的符号先不管，遇到右边类型的符号，则必须是左边类型符号最后一次出现的值
     * 这正好符合栈的用处，先出现的暂时不用管。
     * 一定小心栈NPE
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '{') {
                stack.push('}');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
            } else if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (stack.isEmpty() || stack.pop() != s.charAt(i)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

}
