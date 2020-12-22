package com.leetcode.Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author Zhancong Huang
 * @date 22:07 2019/3/15
 */
public class _735 {
    /**
     * 用栈保存从左到右暂时不用的，栈里从栈底到栈顶最后组成结果集，也就是说栈里的最后都不会冲突
     * 哪些数字才可以放进去呢？
     * （1）向右的
     * （2）向左，且栈顶也是向左。其实也就说现在所有栈里的都是向左的。如果不是就要发生碰撞
     * 总之栈里保存不会发生碰撞的结果
     */
    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0 || asteroids[i] < 0 && (stack.isEmpty() || stack.peek() < 0)) {
                stack.push(asteroids[i]);
                continue;
            }
            if (asteroids[i] == 0) {
                continue;
            }
            //走到这代表要发生碰撞了,计算结果然后继续处理
            asteroids[i] = calculate(asteroids[i], stack.pop());
            i--;
        }
        //整理结果
        int[] result = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            result[i--] = stack.pop();
        }
        return result;
    }

    private int calculate(int p1, int p2) {
        //质量相等，碰撞结果为0
        if (p1 + p2 == 0) {
            return 0;
        }
        return Math.abs(p1) > Math.abs(p2) ? p1 : p2;
    }
}
