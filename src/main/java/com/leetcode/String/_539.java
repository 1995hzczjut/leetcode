package com.leetcode.String;

import java.util.List;

public class _539 {

    /**
     * 题目给定若干个时间，任意选两个时间可以得到一个差值，求所有差值中绝对值最小的那个
     * 排序肯定不行，题目要求O（N）。自然想到O（N）的非比较的排序方法——桶排序
     * 这里桶个数也是已知的，先把输入转换成分钟数放进桶了。一般桶是int[]数组，里面数字表示有几个数字落入桶中
     * 然后遍历即可。但是题目给的case暗示时间是循环的，所以需要找到最小的时间和最大的时间，反向减一下
     */
    public int findMinDifference(List<String> timePoints) {
        boolean[] buckets = new boolean[24 * 60];
        for (String s : timePoints) {
            String[] arr = s.split(":");
            int num = Integer.valueOf(arr[0]) * 60 + Integer.valueOf(arr[1]);
            //坑，桶排序现在桶里只能放一个数据，怎么表示放两个？
            if (buckets[num]) return 0;
            buckets[num] = true;

        }

        int first = 24 * 60;
        int last = -1;
        int pre = 0;
        int min = Integer.MAX_VALUE;

        //逻辑很搞！！！
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i]) {
                // first没找到不求min。保证第一次桶里有值不求min.把求min放到前面
                if (first != 24 * 60) {
                    min = Math.min(min, i - pre);
                }
                first = Math.min(first, i);
                last = Math.max(last, i);
                pre = i;

            }
        }
        //这个case题目给了
        return Math.min(min, (24 * 60 - last + first));
    }

    public static void main(String[] args) {

    }

}
