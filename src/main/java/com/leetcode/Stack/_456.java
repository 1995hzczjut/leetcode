package com.leetcode.Stack;

import java.util.ArrayDeque;

/**
 * 单调栈经典应用。132看32
 *
 * @author Zhancong Huang
 * @date 15:42 2019/6/9
 */
public class _456 {
    public boolean find132pattern(int[] nums) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        //维护i右边，左边存在一个大于它的数中的最大值。
        //左边存在一个大于它的数 明显用从右向左的递减栈。问题最大怎么找？
        //配合pop，每次拿最后一次的pop
        int two = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < two){
                return true;
            }
            //更新单调栈,two是最后一次pop的
            //例如64235 two最后等于4.其实也是属于贪心
            while (!stack.isEmpty() && nums[i] > stack.peek()){
                two = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }

}
