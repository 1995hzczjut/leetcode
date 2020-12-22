package com.leetcode.Heap;

import java.util.*;

/**
 * sort, heap, trie(TODO).
 * 还有一个机器内存放不下怎么做？
 *
 * @author Zhancong Huang
 * @date 21:04 2018/9/12
 */
public class _692 {
    //sort。O（nlogn）  o(n)
    public static List<String> topKFrequent1(String[] words, int k) {
        if (words == null || words.length == 0 || k <= 0) {
            return new ArrayList<>();
        }
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<String> list = new ArrayList<>(map.keySet());
        //使用lambda 替代匿名类。注意题意说了数量相同按字典序排序。不要网了String类自带字典序方法
        Collections.sort(list, (s1, s2) -> map.get(s1).equals(map.get(s2)) ? s1.compareTo(s2)
                : map.get(s2) - map.get(s1));
        return list.subList(0, k);
    }

    //heap . O(Nlogk) o(n)
    public static List<String> topKFrequent2(String[] words, int k) {
        if (words == null || words.length == 0 || k <= 0) {
            return new ArrayList<>();
        }
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        //注意字典序比较要返以下。否则队列poll会poll字典序小的。
        Queue<String> queue = new PriorityQueue<>((s1, s2) -> map.get(s1).equals(map.get(s2)) ? s2.compareTo(s1)
                : map.get(s1) - map.get(s2));
        for (String s : map.keySet()) {
            queue.offer(s);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        List<String> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(0, queue.poll());
        }
        return list;
    }

    public static void main(String[] args) {
        String[] strings = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println(topKFrequent2(strings, k));

    }
}
