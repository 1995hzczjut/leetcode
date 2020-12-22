package com.jianzhiOffer;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @author Zhancong Huang
 * @date 15:10 2019/4/20
 */
public class p20 {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> helper = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (helper.isEmpty() || node < helper.peek()) {
            helper.push(node);
        } else {
            helper.push(helper.peek());
        }
    }

    public void pop() {
        stack.pop();
        helper.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return helper.peek();
    }
}
