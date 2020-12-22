package com.leetcode.math;

import java.util.Arrays;

/**
 * 数组问题，第一眼复杂大于等于N2，一定先考虑排序。在思考O（N）
 *
 * @author Zhancong Huang
 * @date 15:36 2019/8/10
 */
public class _628 {

    /**
     * 注意数组有正有负,主要是分析的 过程。
     */
    public int maximumProduct1(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        Arrays.sort(nums);
        if (nums[j] <= 0) {    //数组都是非正数，那最大值就是最大的三个数
            return nums[j] * nums[j - 1] * nums[j - 2];
        } else {   //有正有负，[-3,-2,1,2,3] [1,2,3,4,5] 最大的那个数必然是，其他两个看情况
            return Math.max(nums[j] * nums[j - 1] * nums[j - 2], nums[i] * nums[i + 1] * nums[j]);
        }
    }

    //不用排序，上面的答案中可以看到，只需要找到5个数就可以了，2个最小的，3个最大的
    //与414 比，不用丢掉重复的
    public int maximumProduct2(int[] nums) {
        int min1 = Integer.MAX_VALUE; //最小的
        int min2 = Integer.MAX_VALUE; //第二小
        int max1 = Integer.MIN_VALUE; //最大的
        int max2 = Integer.MIN_VALUE; //第二大
        int max3 = Integer.MIN_VALUE; //第三大

        //这里不能用if(continue:)实现了，只能用两个if-else
        for (int i : nums) {
            if (i < min1) {    //min2表示第二小。当最小的更新了（要变成新的更小的了，min2应该更新）
                min2 = min1; //【漏写】
                min1 = i;
            } else if (i < min2) {
                min2 = i;
            }

            if (i > max1) {     //最大的更新了，第二大第三大就要更新
                max3 = max2;
                max2 = max1;
                max1 = i;
            } else if (i > max2) { //第二大更新，第三大要个=更新了
                max3 = max2;
                max2 = i;
            } else if (i > max3) {
                max3 = i;
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }

    public static void main(String[] args) {

    }

}
