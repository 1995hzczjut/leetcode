package com.leetcode.math;

import java.util.Random;

/**
 * https://www.cnblogs.com/liaohuiqiang/p/9857273.html
 * 看笔记
 * @author Zhancong Huang
 * @date 21:36 2019/8/1
 */
public class _470 {
    public int rand7() {
        return 1 + new Random().nextInt(7);
    }


    public int rand10() {
        int result;
        do {
            result = (rand7() - 1) * 7 + rand7();
        } while (result > 40);
        return ((result - 1) % 10) + 1;
    }
}
