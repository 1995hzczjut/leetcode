package com.leetcode.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Zhancong Huang
 * @date 12:19 2020/4/29
 */
public class _895 {
    static class FreqStack {
        Map<Integer, Integer> freq;
        Map<Integer, Stack<Integer>> group;
        int maxfreq;

        public FreqStack() {
            freq = new HashMap();
            group = new HashMap();
            maxfreq = 0;
        }

        public void push(int x) {
            int f = freq.getOrDefault(x, 0) + 1;
            freq.put(x, f);
            if (f > maxfreq)
                maxfreq = f;

            group.computeIfAbsent(f, z -> new Stack()).push(x);
        }

        public int pop() {
            int x = group.get(maxfreq).pop();
            freq.put(x, freq.get(x) - 1);
            if (group.get(maxfreq).size() == 0)
                maxfreq--;
            return x;
        }
    }

    public static void main(String[] args) {
        //[5,7,5,7,4,5]
        FreqStack obj = new FreqStack();
        obj.push(5);
        obj.push(7);
        obj.push(5);
        obj.push(7);
        obj.push(4);
        obj.push(5);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        int i = 0;
    }
}
