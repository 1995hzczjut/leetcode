package com.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 与LIS同根。差别在于LIS只返回最后的长度，简单很多,此题要求返回最后的dp状态对应的数字。LIS的follow-up也是这么做的
 * 1.题目说了subset，先sort。
 * 2.对于一个满足题意的subset:{1,2,4,8}，n可以加入这个set, 充要条件就是n 可以整除这个set的最大值
 * 3.难在之前返回长度，现在返回具体的结果.也是精髓所在，
 * 4.注意dp的初始化。
 *
 * @author Zhancong Huang
 * @date 20:19 2018/11/27
 */
public class _368 {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new LinkedList<>();
        if ( nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            result.add(nums[0]);
            return result;
        }
        //dp[i]代表以nums[i]为末尾的长度
        int[] dp = new int[nums.length];
        //parents[i]代表以nums[i]为末尾的最大subset的前一个元素的索引
        //只要在构建dp的过程中，找到最大长度的set的末尾索引，就可以构建最后的答案
        //这是最大的难点
        int[] parents = new int[nums.length];
        Arrays.fill(parents, -1);
        int largesLen = 0;
        int largestIdx = -1;
        //这个初始化非常重要，考虑[XXX，1,2]
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++){
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                    parents[i] = j;
                }
                if (dp[i] > largesLen){
                    largesLen = dp[i];
                    largestIdx = i;
                }
            }

        }
        if (largestIdx < 0){
            result.add(nums[0]);
            return result;
        }
        //构建答案
        while (largestIdx >= 0){
            result.add(0, nums[largestIdx]);
            largestIdx = parents[largestIdx];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(largestDivisibleSubset(new int[]{1,2,3,6}));
    }
}
