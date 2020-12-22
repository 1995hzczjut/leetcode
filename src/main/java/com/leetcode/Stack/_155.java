package com.leetcode.Stack;

import java.util.Stack;

/*
 * 最小栈问题
 * */
public class _155 {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> helper = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if(helper.isEmpty() || x <= helper.peek()){
            helper.push(x);
        }
    }

    public int pop() {
        if(stack.isEmpty()){
            throw new ArrayIndexOutOfBoundsException();
        }
        int o = stack.pop();
        if(o == helper.peek()){
            helper.pop();
        }
        return o;
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return helper.peek();
    }

    public static void main(String[] args) {
        _155 solution = new _155();
        solution.push(512);
        solution.push(-1024);
        solution.push(-1024);
        solution.push(512);
        System.out.println(solution.pop());
        System.out.println(solution.getMin());
        System.out.println(solution.pop());
        System.out.println(solution.getMin());
        System.out.println(solution.pop());
        System.out.println(solution.getMin());
    }
}
