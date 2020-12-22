package com.jianzhiOffer;

import java.util.ArrayList;

/**
 * 滑动窗口
 *
 * @author Zhancong Huang
 * @date 9:26 2019/4/23
 */
public class p41 {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if (sum < 0) return new ArrayList<>();

        int left = 1, right = 1, subSum = 0;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (; right < sum; right++) {
            subSum += right;
            if (subSum < sum) {
                //当前窗口不合法，需扩大
                continue;
            } else if (subSum == sum) {
                result.add(helper(left, right));
            } else if (subSum > sum) {
                //压左边界
                while (left <= right && subSum > sum) {
                    subSum -= left;
                    left++;
                }
                //退出时，可能subSum小于sum,也可能正好等于sum
                if (subSum == sum) {
                    result.add(helper(left, right));
                }
            }
        }

        return result;
    }

    private ArrayList<Integer> helper(int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();
        for (; left <= right; left++) {
            list.add(left);
        }
        return list;
    }
}
