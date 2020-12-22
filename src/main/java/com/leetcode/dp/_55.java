package com.leetcode.dp;

/**
 * dp更新的思路跟53很像
 *
 * @author Zhancong Huang
 * @date 20:28 2018/10/5
 */
public class _55 {

    /**
     * dp[i]代表从0出发，给定[0,i]数组的 ，最远的落脚点.
     * 注意到只说跳到最后一个点，没说还需要跳出去
     *
     */
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //之前的最大reach点到不了现在i位置，直接返回false
            if (dp[i - 1] < i) return false;
            //之前的最大reach点直接过了终点，那也不用往下看了
            if ( dp[i - 1] >= nums.length - 1) return true;
            //里面第一项：[0,i-1]比较猛，不在i落脚。前提要能越过i,所以在前面判断了
            //里面第二项：i点蓄力比较多，选则在i落脚在跳出来。
            //上面两者选一个
            dp[i] = Math.max(dp[i - 1], i + nums[i]);
        }
        return true;
    }
}
