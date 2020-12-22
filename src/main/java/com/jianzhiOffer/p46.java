package com.jianzhiOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列模拟。把小孩加进去，符合的拿奖励不回去了，不符合的在扔到队列
 *
 * @author Zhancong Huang
 * @date 14:42 2019/4/23
 */
public class p46 {
    /**
     * 队列具备解释性
     */
    public int LastRemaining_Solution_Q(int n, int m) {
        if (n == 0) return -1;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(i);
        }
        m--;
        int count = 0;

        while (queue.size() > 1) {
            int polled = queue.poll();
            if (count == m) {
                count = 0;
            } else {
                count++;
                queue.offer(polled);
            }
        }

        return queue.poll();
    }

}

