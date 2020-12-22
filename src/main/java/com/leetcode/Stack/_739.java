package com.leetcode.Stack;


import java.util.ArrayDeque;


/**
 * ����ջ���ʿ��ʼǡ�Monotone Stack�����ܽᡷ
 *
 * @author Zhancong Huang
 * @date 20:56 2019/9/28
 */
public class _739 {
    /**
     * �õݼ�ջ��Ҫ�󷵻������±�ļ�࣬ջ��Ӧ�ô��±�
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
