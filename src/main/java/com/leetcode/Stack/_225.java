package com.leetcode.Stack;

import javax.management.Query;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
* 还是加个swap 浪费空间，省代码
* */
public class _225 {

    private Queue<Integer> data = new LinkedList<>();
    private Queue<Integer> helper = new LinkedList<>();

    private void swap(){
        Queue<Integer> temp = new LinkedList<>();
        temp = data;
        data = helper;
        helper = temp;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        data.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(data.isEmpty()) throw new ArrayIndexOutOfBoundsException();
        while (data.size() > 1){
            helper.offer(data.poll());
        }
        int o = data.poll();
        swap();
        return o;
    }

    /** Get the top element. */
    public int top() {
        if(data.isEmpty()) throw new ArrayIndexOutOfBoundsException();
        while (data.size() > 1){
            helper.offer(data.poll());
        }
        int o = data.poll();
        helper.offer(o);
        swap();
        return o;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return data.isEmpty();
    }

    public static void main(String[] args) {
        _225 stack = new _225();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}
