package com.leetcode.dp;

/**
 * 利用桶排序转化为打劫问题。注意you must delete every element equal to nums[i] - 1 or nums[i] + 1.
 * https://leetcode.com/problems/delete-and-earn/discuss/109891/Sharing-my-Simple-Straight-Forward-Java-O(n)-Solution-Explanation-Included
 *
 * @author Zhancong Huang
 * @date 23:07 2018/12/8
 */
public class _740 {
    public static int deleteAndEarn1(int[] nums) {
        int[] buckets = new int[10001];
        for (int num : nums) {
            //223334 拿了一个3,所有的2 4都没了，即再也没有其他可能拿到24从而删掉3.所以拿了一次3，就要全部拿掉
            buckets[num] += num;
        }
        //即DP[i] 表示状态ends with i的做法。需要分类
        int[] take = new int[10001];
        int[] skip = new int[10001];
        take[0] = buckets[0];
        skip[0] = 0;
        for (int i = 1; i < 10001; i++) {
            take[i] = skip[i - 1] + buckets[i];
            skip[i] = Math.max(skip[i - 1], take[i - 1]);
        }
        return Math.max(take[10000], skip[10000]);
    }

    public static int deleteAndEarn2(int[] nums) {
        int[] buckets = new int[10001];
        for (int num : nums) {
            buckets[num] += num;
        }
        //即DP[i]简单等于子问题DP[i-1]. 忽视具体做法。
        int[] dp = new int[10001];
        dp[0] = buckets[0];
        dp[1] = Math.max(buckets[1], buckets[0]);
        for (int i = 2; i < 10001; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + buckets[i]);
        }
        return dp[10000];
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 3, 3, 4};
        System.out.println(deleteAndEarn2(nums));
    }
}
