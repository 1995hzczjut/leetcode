package com.jianzhiOffer;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 参考LC笔记，top K一定要注意要不要求DISTINCT
 * 这题没有说，看来是不要求，要求的话每次for循环第一件事看队列里有没有重复
 *
 * @author Zhancong Huang
 * @date 20:18 2019/4/21
 */
public class p29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (k > input.length) return new ArrayList<>();
        Queue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int num : input) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return new ArrayList<>(pq);
    }
}
