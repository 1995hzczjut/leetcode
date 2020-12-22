package com.leetcode.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Zhancong Huang
 * @date 23:37 2018/9/9
 */
public class _378 {
    /**
     * 参考373.queue.offer(new int[]{cur[0], cur[1] + 1}); 越界又忘记了
     * 这个报错报在lamda
     */
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> matrix[o[0]][o[1]]));
        //init
        for (int i = 0; i < matrix.length; i++) {
            queue.offer(new int[]{i, 0});
        }
        int res = 0;
        while (k-- > 0) {
            int[] cur = queue.poll();
            res = matrix[cur[0]][cur[1]];
            if (cur[1] + 1 == matrix[0].length) continue;
            queue.offer(new int[]{cur[0], cur[1] + 1});
        }
        return res;
    }
}
