package com.leetcode.HashTable;

import java.util.*;

/**
 * @author Zhancong Huang
 * @date 22:07 2019/3/15
 */
public class _451 {
    /**
     * 与347做法一样
     */
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>(256);
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.offer(entry);
        }

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> entry = queue.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                result.append(entry.getKey());
            }
        }
        return result.toString();
    }

}
