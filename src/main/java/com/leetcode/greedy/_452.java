package com.leetcode.greedy;

import java.util.Arrays;
import java.util.Map;

/**
 * 要最小。按第一个数排。为了使结果最小，肯定射在一个范围的end。
 * 再看下一个气球的start,是否能小于end，一箭双雕
 * [1,6] [2,8]  射在6          [1,6] [2,4]  射在4
 * 题意： xstart ≤ x ≤ xend
 * 跟435一样的做法，区间合并就是按start排序
 *
 * @author Zhancong Huang
 * @date 22:15 2018/11/18
 */
public class _452 {
    public static int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (o1, o2) -> (o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));
        int result = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                //需要定新的end.考虑[1,6] [2,8]  射在6 ；[1,6] [2,4]  射在4
                //代表一箭多雕
                end = Math.min(end, points[i][1]);
            } else {
                //只能一键一雕
                result++;
                end = points[i][1];
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
