package com.leetcode.array;

import java.util.*;

/**
 * 一开始想建两个list,挨个添加。策略非常麻烦。题目也没说一定分成两个。//TODO
 * 答案看不懂
 *
 * @author Zhancong Huang
 * @date 21:13 2018/9/28
 */
public class _659 {
    //    //贪心
    public  boolean isPossible(int[] nums) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();   // end -> list of length
        map.put(nums[0] - 1, new PriorityQueue<>());   // add a fake entry for convenience
        for (int num : nums) {
            map.put(num, new PriorityQueue<>());
        }
        for (int num : nums) {
            if (map.containsKey(num - 1) && !map.get(num - 1).isEmpty()) {
                int tmp = map.get(num - 1).poll() + 1;
                map.get(num).offer(tmp);
            } else {
                map.get(num).offer(1);
            }
        }
        for (Queue<Integer> queue : map.values()) {
            if (!queue.isEmpty() && queue.peek() < 3) {
                return false;
            }
        }
        return true;
    }
//    public boolean isPossible(int[] nums) {
//        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> {
//            if (a.end == b.end) {
//                return Integer.compare(a.length, b.length);
//            }
//            return Integer.compare(a.end, b.end);
//        });
//
//        for (int num : nums) {
//            while (!pq.isEmpty() && pq.peek().end + 1 < num) {
//                if (pq.poll().length < 3)
//                    return false;
//            }
//            if (pq.isEmpty() || pq.peek().end == num) {
//                pq.add(new Interval(num, num));
//            } else { // pq.peek().end + 1 == num
//                pq.add(new Interval(pq.poll().start, num));
//            }
//        }
//
//        while (!pq.isEmpty()) {
//            if (pq.poll().length < 3)
//                return false;
//        }
//
//        return true;
//    }
//
//    class Interval {
//        int start;
//        int end;
//        int length;
//
//        public Interval(int start, int end) {
//            this.start = start;
//            this.end = end;
//            length = end - start + 1;
//        }
//    }


    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 4, 4, 5, 5};
        new _659().isPossible(a);
    }
}
