package com.leetcode.HashTable;

import com.mysql.jdbc.util.Base64Decoder;

import java.util.*;

/**
 * 多路归并题,超级丑数类似。弹出最小的数同样能弹全部弹出来，第一次这里漏了。
 * 如下面链接的图所示：
 * https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists/solution/liang-ge-fei-chang-rong-yi-li-jie-de-si-lu-yi-kan-/
 * 终止条件：一个指针走到底就行了，其他数组数字肯定比当前堆里的大，所以再看，区间只会变大
 *
 * @author Zhancong Huang
 * @date 16:51 2020/4/23
 */
public class _632 {

    public static int[] smallestRange(List<List<Integer>> nums) {
        int[] indexs = new int[nums.size()];
        int left = 0, right = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //放的是具体的值
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < nums.size(); i++) {
            int cur = nums.get(i).get(0);
            queue.offer(cur);
            max = Math.max(max, cur);
        }

        //终止条件是一个指针到底，不在放入队列
        while (queue.size() == nums.size()) {
            //一定要全部弹出
            int minVal = queue.peek();
            while (!queue.isEmpty() && queue.peek() == minVal){
                queue.poll();
            }
            //更新区间
            if (max - minVal < right - left) {
                right = max;
                left = minVal;
            }
            //移动指针，加入队列，同时维护最大值
            for (int i = 0; i < nums.size(); i++) {
                if (nums.get(i).get(indexs[i]) == minVal) {
                    if (++indexs[i] == nums.get(i).size()) {
                        //到顶了，直接退出
                        break;
                    }
                    int nextVal = nums.get(i).get(indexs[i]);
                    max = Math.max(max, nextVal);
                    queue.offer(nextVal);
                }
            }
        }
        return new int[]{left, right};
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new LinkedList<>();
        list.add(new LinkedList<>());
        list.add(new LinkedList<>());
        list.add(new LinkedList<>());
        list.add(new LinkedList<>());

        list.get(0).add(2);
        list.get(0).add(6);
        list.get(0).add(8);

        list.get(1).add(3);
        list.get(1).add(5);
        list.get(1).add(7);
        list.get(1).add(9);

        list.get(2).add(2);
        list.get(2).add(3);
        list.get(2).add(4);
        list.get(2).add(6);
        list.get(2).add(10);

        list.get(3).add(1);
        list.get(3).add(4);
        list.get(3).add(7);

        System.out.println(Arrays.toString(smallestRange(list)));


    }
}
