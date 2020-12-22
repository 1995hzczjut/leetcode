package com.leetcode.greedy;

import java.util.Arrays;

/**
 * 技巧性太强了！！！需要记忆
 * 与767非常类似.都是给一堆字母，重组字符串，填充策略是一摸一样的。这题简单些，不要输出排序结果
 * https://www.cnblogs.com/grandyang/p/7098764.html
 *
 * @author Zhancong Huang
 * @date 22:52 2018/11/18
 */
public class _621 {

    public int leastInterval(char[] tasks, int n) {
        int[] charMap = new int[26];
        for (char c : tasks) {
            charMap[c - 'A']++;
        }
        //找到charmap最大的值,即出现的次数
        int max = Arrays.stream(charMap).max().getAsInt();
        int numOfMax = (int) Arrays.stream(charMap).filter(i -> i == max).count();
        //最紧凑的长度，即空隙没人填充，即有空洞
        int minLength = (n + 1) * (max - 1) + numOfMax;
        return Math.max(tasks.length, minLength);
    }
}
