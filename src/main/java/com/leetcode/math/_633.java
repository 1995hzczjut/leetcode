package com.leetcode.math;

import java.util.HashSet;

/**
 * @author Zhancong Huang
 * @date 18:26 2019/4/13
 */
public class _633 {
    /**
     * 看成在1到C之间选两个数平方和为C,就是two sum问题变种
     * 题目要求0也可以称为一部分。那就需要set有初始值0了.还有2也可以，1，1的平方，即可以重复。
     * 那可以巧妙的变一下，先add
     * 后来又出现了TLE，加根号就行了。
     * 题目简单，小问题还是很多
     */
    public static boolean judgeSquareSum(int c) {
        HashSet<Integer> set = new HashSet<>(256);
        for (int i = 0; i <= Math.sqrt(c); i++) {
            set.add(i * i);
            if (set.contains(c - i * i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        judgeSquareSum(0);
//        judgeSquareSum(4);
//        judgeSquareSum(5);
        System.out.println(judgeSquareSum(2));
    }
}
