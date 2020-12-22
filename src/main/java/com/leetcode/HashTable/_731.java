package com.leetcode.HashTable;

import java.util.TreeMap;

/**
 * 分析非常困难
 *
 * 综合的区间贪心问题。结合729思考背后的基本问题
 * （1）给定一组区间，没有重叠，现给出[start,end]，问能有重叠吗？
 * 这个问题之前也有，需要对区间的起始排序，然后用两分按start找。正好符合TreeMap的特征。
 * （2）如果区间有重复，上面的做法可行吗？
 * 不可以,已有[1,10],[2,5] .插入[7,8]。照上面的做法区间没有重合，结果错误。
 * <p>
 * 所以这道题的核心是解决问题2.具体思路：
 * 729实现了无重叠区间的寻找。现在允许重复一次，那么需要记录重复区间intervals.如果待插入区间与intervals有重复直接返回。
 * 无重复的话计算与Books是否有重复区间。【关键】是有重复区间的需要合并，否则会出现上述（2）的场景
 *
 * @author Zhancong Huang
 * @date 10:18 2019/3/25
 */
public class _731 {
    static class MyCalendarTwo {

        /**
         * 记录所有待查询区间
         */
        TreeMap<Integer, Integer> intervals = new TreeMap<>();
        /**
         * 重复区间
         */
        TreeMap<Integer, Integer> overlaps = new TreeMap<>();

        public MyCalendarTwo() {

        }

        public boolean book(int start, int end) {
            System.out.println("==========");
            System.out.println(String.format("start:%s,end:%s 开始值", start, end));
            if (hasOverlaps(overlaps, start, end)) {
                System.out.println(String.format("start:%s,end:%s 被丢弃", start, end));
                return false;
            }
            if (intervals.size() == 0) {
                intervals.put(start, end);
                return true;
            }
            //查询[start,end) 左边有没有区间产生交集，有则合并
            Integer floorStart = intervals.floorKey(start);
            if (floorStart != null && intervals.get(floorStart) > start) {
                int floorEnd = intervals.get(floorStart);
                System.out.println(String.format("start:%s,end:%s 左边存在冲突，fs:%s,fe:%s", start, end, floorStart, floorEnd));
                overlaps.put(start, Math.min(floorEnd, end));
                //区间必须合并，否则后面的查询无法满足已有区间无重复的假设
                start = floorStart;
                end = Math.max(floorEnd, end);
                //合并的话要把老的删掉，一开始漏了
                System.out.println(String.format("合并后：start:%s,end:%s", start, end));
                intervals.remove(floorStart);
            }


            //查询[start,end) 右边有没有区间产生交集，有则合并
            //跟729不同，探测右边复杂一点，因为start,end内部可能有多个区间。且start固定了
            //这一步很难想到
            Integer ceilingStart = intervals.ceilingKey(start);
            while (ceilingStart != null && ceilingStart < end) {
                int ceilingEnd = intervals.get(ceilingStart);
                System.out.println(String.format("start:%s,end:%s 右边存在冲突，cs:%s,ce:%s", start, end, ceilingStart, ceilingEnd));
                overlaps.put(ceilingStart, Math.min(end, ceilingEnd));
                //start = ceilingStart;
                end = Math.max(end, ceilingEnd);
                System.out.println(String.format("合并后：start:%s,end:%s", start, end));
                intervals.remove(ceilingStart);

                ceilingStart = intervals.ceilingKey(start);
            }
            System.out.println(String.format("start:%s,end:%s 最终结果", start, end));
            intervals.put(start, end);
            System.out.println("==========");
            System.out.println();
            return true;
        }

        private boolean hasOverlaps(TreeMap<Integer, Integer> overlaps, int start, int end) {
            Integer floorKey = overlaps.floorKey(start);
            if (floorKey != null && overlaps.get(floorKey) > start) return true;
            Integer cellingKey = overlaps.ceilingKey(start);
            if (cellingKey != null && cellingKey < end) return true;
            return false;
        }
    }

    public static void main(String[] args) {
        MyCalendarTwo c = new MyCalendarTwo();
//        System.out.println(c.book(10, 20)); // returns true
//        System.out.println(c.book(50, 60)); // returns true
//        System.out.println(c.book(10, 40)); // returns true
//        System.out.println(c.book(5, 15)); // returns false
//        System.out.println(c.book(5, 10)); // returns true
//        System.out.println(c.book(25, 55)); // returns true
        c.book(10, 20); // returns true
        c.book(50, 60); // returns true
        c.book(10, 40); // returns true
        c.book(5, 15); // returns false
        c.book(5, 10); // returns true
        c.book(25, 55); // returns true
    }
}
