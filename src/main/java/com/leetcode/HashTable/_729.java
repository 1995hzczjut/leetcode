package com.leetcode.HashTable;

import java.util.TreeMap;

/**
 * 对于MAP查出NULL要特别注意
 *
 * @author Zhancong Huang
 * @date 20:19 2019/3/24
 */
public class _729 {


    static class MyCalendar {

        TreeMap<Integer, Integer> calendar;

        public MyCalendar() {
            calendar = new TreeMap<>();
        }

        /**
         * 题目要求：
         * 要存储查询的区间。这种区间类题目 按照start,end排序是很常见的做法。
         * 这里选择按start，但是同时要保存两个值，变成对象开销太大了，所以选择treemap。
         * map操作千万不能对valueset查询，因为是无序的。对keyset查询可以用二叉树的性质加速查找。
         */
        public boolean book(int start, int end) {
            //开始写的时候假设map里的全都合法
            //floorKey 返回小于等于target中的最大值，没有返回null。
            //int a = null 是要报NPE的
            Integer floorKey = calendar.floorKey(start);
            if (floorKey != null && calendar.get(floorKey) > start) return false;
            //注意null值情况
            Integer cellingKey = calendar.ceilingKey(start);
            if (cellingKey != null && cellingKey < end) return false;
            calendar.put(start, end);
            return true;
        }
    }

}
