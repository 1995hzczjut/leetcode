package com.jianzhiOffer;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author Zhancong Huang
 * @date 15:42 2019/4/30
 */
public class p64 {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (size == 0 || size > num.length) return new ArrayList<>();

        Queue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        ArrayList<Integer> result = new ArrayList<>();

        //在i处，处理之前三个数的最大值，明显要规避在线处理问题.最好不要再尾巴处处理
        for (int i = 0; i < num.length; i++) {
            if (i < size){
                queue.offer(num[i]);
            }else {
                //思考NPE？只有size为零才会出现
                int lastMax = queue.peek();
                result.add(lastMax);
                //移除具体的值
                queue.remove(num[i - size]);
                queue.offer(num[i]);
            }
        }
        result.add(queue.peek());
        return result;
    }

}
