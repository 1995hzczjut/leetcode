package com.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Zhancong Huang
 * @date 22:57 2018/11/15
 */

public class _435 {
    /**
     * 标准答案都是按end 排序，试下start.
     * 贪心贪在 局部最优
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int cnt = 0, prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (prevEnd > intervals[i][0]) {
                //贪心的地方，必须丢掉一个区间，丢哪个？丢end靠右的那个，因为后面的未知，只能保证剩下的那个尽量靠左
                cnt++;
                prevEnd = Math.min(prevEnd, intervals[i][1]);
            } else {
                prevEnd = intervals[i][1];
            }
        }
        return cnt;
    }

}
