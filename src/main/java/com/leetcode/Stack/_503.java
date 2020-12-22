package com.leetcode.Stack;

import java.util.*;

/**
 * 496上改进。这里数组重复，栈里放的是索引了
 *
 * @author Zhancong Huang
 * @date 22:07 2019/3/15
 * @see _496
 */
public class _503 {


    public int[] nextGreaterElements(int[] nums) {
        //放的是下标,之前放数字是因为没有重复，这里有重复了。
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        //与496类似，差别在于这里key是下表了
        Map<Integer, Integer> map = new HashMap<>(256);

        int len = nums.length;
        //把原数组向后复制一段，但是复制出来的一段不参与Push,只是用来查看前一段的next greater number
        for (int i = 0; i < nums.length * 2; i++) {
            while (!stack.isEmpty() && nums[i % len] > nums[stack.peek()]) {
                map.put(stack.pop(), nums[i % len]);
            }
            if (i < len) {
                stack.push(i);
            }
        }
        //构建答案
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = map.getOrDefault(i, -1);
        }
        return res;
    }
}
