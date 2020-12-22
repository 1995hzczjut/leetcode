package com.leetcode.Heap;

import java.util.PriorityQueue;

/**
 * 思路重要，海量数据处理的题目常用
 * JAVA 直接使用minheap。这个小根堆维护的是数据流中【top k】。 例如k=3
 * 队列第一个数字就是第K大，第二个第K-1大，最后个是最大的
 * 然后有新数字进来了，扔进堆里，poll（）
 * 再返回peek()就是要的答案
 *例如12345 用小根堆
 * 记住【动态的过程】，不需要把所有数据放进内存，正式堆的高效之处
 *
 * @author Zhancong Huang
 * @date 18:35 2018/9/8
 */

public class _703 {

    static class KthLargest {

        private PriorityQueue<Integer> pq;
        private int k;

        public KthLargest(int k, int[] nums) {
            this.pq = new PriorityQueue<>();
            this.k = k;
            for (int i : nums) {
                pq.offer(i);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        public int add(int val) {
            pq.offer(val);
            if (pq.size() > k) {
                pq.poll();
            }
            return pq.peek();
        }
    }


    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, arr);
        kthLargest.add(3);   // returns 4
        kthLargest.add(5);   // returns 5
        kthLargest.add(10);  // returns 5
        kthLargest.add(9);   // returns 8
        kthLargest.add(4);   // returns 8
    }
}
