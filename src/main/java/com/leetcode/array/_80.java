package com.leetcode.array;

import java.util.Arrays;

/**
 * 26,27 格式参考荷兰国旗问题，懒的改了 todo
 *
 * @author Zhancong Huang
 * @date 21:26 2019/1/17
 */
public class _80 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        //代表SLOW指针向左的闭区间里最右边的数字重复了几次，规定只能重复一次
        int dup = 0;
        //SLOW指针向左的闭区间 都是符合要求的
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            //以循环的开始作为分界线思考。fast是现在要看的点，slow指的地方必然满足题目题意
            System.out.println(String.format("slow:%s fast:%s dup:%s ", slow, fast, dup));
            if (nums[fast] == nums[slow]) {
                if (dup == 0) {
                    //不能 &&上去。
                    //一开始写成nums[low++] 就是没搞清楚low定义。low每个指的地方都是合法的，怎么能修改呢？
                    nums[++slow] = nums[fast];
                    dup++;
                }
            } else {
                nums[++slow] = nums[fast];
                dup = 0;
            }
        }
        return slow + 1;
    }


    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new _80().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
