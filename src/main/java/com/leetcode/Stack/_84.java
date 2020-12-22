package com.leetcode.Stack;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * 思路：直方图是矩形的，所以可以依次遍历每一个值，下标记为i,然后从右向左找第一个小于它的数字，从左向右找第一个小于它的数字
 * 暴力时间复杂度N*N，上述思路完全符合单调栈作用。单调栈的pop操作是至关重要的，pop的时候左右两边第一个小于它的数字都被找到了
 * （这里关键一定要想到可能不存在这样的数字，右边不存在很常见，左边不存在对应它自己是栈底的情况）
 * 值得注意的是，上述操作最后栈里会维护一个递增序列。这个序列也就是栈顶肯定是整个heights数组的最右边一个，这个序列不存在右边
 * 第一个比他小的数。
 *
 *
 * @author Zhancong Huang
 * @date 17:25 2020/2/12
 */
public class _84 {

    public static int largestRectangleArea(int[] heights){
        int result = 0;
        //存下标
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int curHeight = heights[stack.pop()];
                //[left,right]是要求的直方图.stack.peek()写出来就要想到NPE,对应上面弹出的数字左边
                //不存在比他小的数字了，左边都是比他高的bar,因此左边界下标应该是0
                int left = stack.isEmpty() ? 0 : (stack.peek() + 1);
                int right = i - 1;
                result = Math.max(result, (right - left + 1) * curHeight);
            }
            stack.push(i);
        }

        //[每个数字]都要查看左右边界，但是递增栈构建中有些数字没有Pop的，所以要额外处理
        //递增栈栈顶是heights最右边下标，每个数字构建的直方图的右边界。左边界同理
        final int right = heights.length - 1;
        while(!stack.isEmpty()){
            int curHeight = heights[stack.pop()];
            int left = stack.isEmpty() ? 0 : (stack.peek() + 1);
            result = Math.max(result, (right - left + 1) * curHeight);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,5,6,2,3};
        System.out.println(largestRectangleArea(nums));
    }

}
