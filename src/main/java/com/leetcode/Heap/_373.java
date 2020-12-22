package com.leetcode.Heap;

import java.util.*;

/**
 * @author Zhancong Huang
 * @date 9:19 2018/9/12
 */
public class _373 {
    /**
     * (1,2) -> (1,9) -> (1,10) -> (1,15)
     * (7,2) -> (7,9) -> (7,10) -> (7,15)
     * (11,2) -> (11,9) -> (11,10) -> (11,15)
     * (16,2) -> (16,9) -> (16,10) -> (16,15)
     * 看成4路归并，小心越界，代表一路归并完了
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> o1[0] + o1[1] - o2[0] - o2[1]));
        List<List<Integer>> res = new LinkedList<>();
        //init
        for (int i = 0; i < nums1.length; i++) {
            queue.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while (k-- > 0 && !queue.isEmpty()) {
            int[] cur = queue.poll();
            LinkedList<Integer> tmp = new LinkedList<>();
            tmp.add(cur[0]);
            tmp.add(cur[1]);
            res.add(tmp);
            //没注意到的，nums2[cur[2] + 1] 代表这一路Merge完了,直接跳过
            if (cur[2] + 1 == nums2.length) continue;
            queue.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return res;
    }
}
