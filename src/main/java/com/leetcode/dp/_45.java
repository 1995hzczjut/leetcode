package com.leetcode.dp;


/**
 * O(N),O(N)
 * 在55题的DP基础上需要维护走到每一个点的最小步数，且只有dp[i]>dp[i-1],才代表有新的点能被走到。
 * 写的时候注意success-fast.
 *
 * @author Zhancong Huang
 * @date 15:02 2019/11/24
 */
public class _45 {

    /**
     * arr: 2 2 2 1 4
     * d0=2,s1=1,s2=1
     * d1=3,此时能确定新的更远的点的最小的走到它的步数了，s3=s1+1
     * 略
     * 总结还是基于动态规划，dp[i]比dp[i-1]大代表,有更远的点能被走到，但是需要以i为支柱走过去，更新这些点即可。
     * 一旦发现dp[i]能直接走到最后个点，那不用更新了，直接返回
     */
    public static int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int[] dp = new int[nums.length];
        int[] steps = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || i + nums[i] > dp[i - 1]) {
                dp[i] = i + nums[i];
                if (dp[i] >= nums.length - 1) return steps[i] + 1;
                for (int j = (i == 0 ? 0 : dp[i - 1]) + 1; j <= dp[i]; j++) {
                    steps[j] = steps[i] + 1;
                }
            } else {
                dp[i] = dp[i - 1];
            }
        }
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        //int[] arr = new int[]{1,1,1,1,1};
        int[] arr = new int[]{2,3,1,1,4};
        System.out.println(jump(arr));

    }
}
