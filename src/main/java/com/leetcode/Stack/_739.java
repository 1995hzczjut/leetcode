package com.leetcode.Stack;


import java.util.ArrayDeque;


/**
 * 单调栈性质看笔记《Monotone Stack问题总结》
 *
 * @author Zhancong Huang
 * @date 20:56 2019/9/28
 */
public class _739 {
    /**
     * 用递减栈，要求返回数组下标的间距，栈里应该存下标
     */
    public int[] dailyTemperatures(int[] T) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[T.length];

        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int popoed = stack.pop();
                result[popoed] = i - popoed;
            }
            stack.push(i);
        }
        return result;
    }


}
