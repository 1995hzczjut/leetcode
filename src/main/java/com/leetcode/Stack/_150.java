package com.leetcode.Stack;

import java.lang.reflect.Array;
import java.util.ArrayDeque;

/**
 * 就是后缀表达式
 * 平时我们习惯将表达式写成 (1 + 2) * (3 + 4)，加减乘除等运算符写在中间，因此称呼为中缀表达式。
 * 而波兰表达式的写法为 (* (+ 1 2) (+ 3 4))，将运算符写在前面，因而也称为前缀表达式。
 * 逆波兰表达式的写法为 ((1 2 +) (3 4 +) *)，将运算符写在后面，因而也称为后缀表达式。
 * 至于逆波兰表示式，可用栈进行计算，天生适合于基于栈的语言。遇到数字就将数字压栈，遇到操作符，就将栈顶的两个元素取出计算，将计算结果再压入栈。
 * 最后栈里的数字就是要的结果
 *
 * @author Zhancong Huang
 * @date 13:38 2019/6/4
 */
public class _150 {
    public static int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens){
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "-":
                    int n1 = stack.pop(), n2 = stack.pop();
                    stack.push(n2 - n1);
                    break;
                case "/":
                     n1 = stack.pop();
                     n2 = stack.pop();
                    stack.push(n2 / n1);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
