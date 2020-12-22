package com.leetcode.array;

import java.util.*;

/**
 * @author Zhancong Huang
 * @date 10:46 2019/6/18
 * @see _57
 */
public class _56 {

    /**
     * 利用start排序，
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1){
            return intervals;
        }
        List<int[]> result = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (prev[1] < intervals[i][0]){
                //不需要合并
                result.add(prev);
                prev = intervals[i];
            }else {
                //合并,取大的end
                prev[1] = Math.max(prev[1], intervals[i][1]);
            }
        }
        //容易漏
        result.add(prev);

        int[][] res = new int[result.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}
