package com.jianzhiOffer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 321               456
 * 大根堆            小根堆
 * 插入完成后，一定保证【小根堆数量>=大根堆,但只能最多多一个，数值关系上也要小根堆>大根堆】
 * 两个堆的peek就是中位数
 *
 * @author Zhancong Huang
 * @date 10:16 2019/9/6
 */
public class p63 {

    int size = 0;
    Queue<Integer> minHeap = new PriorityQueue<>();
    Queue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public void Insert(Integer num) {
        if (size % 2 == 0) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        size++;
    }

    public Double GetMedian() {
        return size % 2 == 0 ? (minHeap.peek() + maxHeap.peek()) / 2.0 : (double)minHeap.peek();
    }

}
