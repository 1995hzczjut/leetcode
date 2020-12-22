package com.leetcode.Stack;

import java.util.Stack;

public class _232 {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> helper = new Stack<>();

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (empty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (!helper.isEmpty()) {
            return helper.pop();
        } else {
            while (stack.size() > 0) {
                helper.push(stack.pop());
            }
            return helper.pop();
        }

    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (empty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(!helper.isEmpty()){
            return helper.peek();
        }else{
            while (stack.size() > 0) {
                helper.push(stack.pop());
            }
            return helper.peek();
        }
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.isEmpty() && helper.isEmpty();
    }

    public static void main(String[] args) {
        _232 queue = new _232();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        queue.push(4);
        queue.push(5);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
    }
}
