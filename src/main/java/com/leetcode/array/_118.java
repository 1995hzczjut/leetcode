package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路要记，题目的动画效果也说明了，每一行先再之前的头里插入
 * 在计算
 *
 * @author Zhancong Huang
 * @date 10:52 2019/8/12
 */
public class _118 {

    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        List<Integer> tmpRaw = new ArrayList<>();
        //i代表每一层的索引
        for (int i = 0; i < numRows; i++) {
            tmpRaw.add(0, 1);
            for (int j = 1; j < tmpRaw.size() - 1; j++) {
                tmpRaw.set(j, tmpRaw.get(j) + tmpRaw.get(j + 1));
            }
            result.add(new ArrayList<>(tmpRaw));
        }
        return result;
    }
}
