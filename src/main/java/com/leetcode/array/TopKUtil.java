package com.leetcode.array;

import java.util.*;

/**
 * k从1开始，代表前k个
 *
 * @author Zhancong Huang
 * @date 13:58 2019/8/16
 */
public class TopKUtil {


    /**
     * 之前的做法也是错的，要求不重复，不是poll全拉出来，而是遇到新的遍历一遍队列，看有没有重复
     */
    public static List<Integer> topKUsingQueue(int[] nums, int k, boolean isDistinct) {
        if (k >= nums.length) throw new RuntimeException("k过大");
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for (int num : nums) {
            //如果结果不能有重复的话，queue应该具有set的性质，来个数字先检查有没有，而不是队列满了才检查。跟下面一样。
            if (isDistinct && skip(queue, num)) continue;
            if (queue.size() == k) queue.poll();
            queue.offer(num);
        }
        return new LinkedList<>(queue);
    }

    private static boolean skip(Queue<Integer> queue, int num) {
        for (int e : queue) {
            if (num == e) return true;
        }
        return false;
    }

    /**
     * k较小时可以以O（N）找到，一般就K=2,3.这里以2为例子.Integer拆箱很容易NPE
     * 这个模板一定要记住，注意点：
     * （1）用包装类
     * （2）包装类 ==，>,< 非包装类 都可能引起NPE一定要注意。
     */
    public static List<Integer> top2(int[] nums, boolean isDistinct) {
        Integer max1 = null, max2 = null;
        for (Integer num : nums) {
            if (isDistinct && (num.equals(max1) || num.equals(max2))) continue;
            if (max1 == null || num > max1) {
                //新的最大数进来，应该先调整小的那个
                max2 = max1;
                max1 = num;
            } else if (max2 == null || num > max2) {
                max2 = num;
            }
        }
        List<Integer> result = new LinkedList<>();
        result.add(max1);
        result.add(max2);
        return result;
    }





}
