package com.leetcode.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/insert-interval/discuss/21602/Short-and-straight-forward-Java-solution
 *
 * @author Zhancong Huang
 * @date 16:30 2019/11/24
 * @see _56
 */
public class _57 {


    /**
     * 主要考虑3种case，看笔记
     */
    public int[][] insertError(int[][] intervals, int[] newInterval) {
        List<int[]> result = new LinkedList<>();
        if (intervals.length == 0) result.add(newInterval);
        int i = 0;
        while (i < intervals.length){
            if (newInterval[0] > intervals[i][1]){
                result.add(intervals[i++]);
            }else {
                int newLeft = Math.min(intervals[i][0], newInterval[0]);
                int newRight = Math.max(intervals[i++][1], newInterval[1]);
                while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
                    newRight =  Math.max(intervals[i++][1], newInterval[1]);
                }
                result.add(new int[]{newLeft, newRight});
                while (i < intervals.length){
                    result.add(intervals[i++]);
                }
            }
        }

        return result.toArray(new int[result.size()][2]);
    }
}
