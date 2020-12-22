package com.leetcode.greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 背思路的题：
 * 矮子插队无所谓，反正高个子看不到.具体：
 * 题目中的例子[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 第一次排序后70 71 61 50 52 44
 * 排序的规则是高个子尽量放在前面，如果身高一样，第二个参数小的放前面
 * 关键在于第二个参数。70  中间没人 71 和70 比7小的矮个子N个 71   两种排法是一样的。
 * 即第二个数字是相对的。
 * 利用这一点70 71 插入之后，后面的所有人都比他矮，所以怎么插无所谓
 *
 * @author Zhancong Huang
 * @date 22:14 2018/11/15
 */
public class _406 {
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> p2[0] == p1[0] ? p1[1] - p2[1] : p2[0] - p1[0]);
        List<int[]> result = new LinkedList<>();
        Arrays.stream(people).forEach(p -> result.add(p[1], p));
        return result.toArray(people);
    }

    public static void main(String[] args) {
        reconstructQueue(new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}});
    }
}
