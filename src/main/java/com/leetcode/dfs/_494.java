package com.leetcode.dfs;

/**
 * @author Zhancong Huang
 * @date 19:41 2019/7/21
 */
public class _494 {

    /**
     * 严格按照模板画图写出来的
     */
    public int findTargetSumWays3(int[] nums, int S) {
        int[] result = new int[1];
        helper2(result, 0, nums, nums[0], S);
        helper2(result, 0, nums, -nums[0], S);
        return result[0];
    }


    private void helper2(int[] result, int opIdx, int[] nums, int subSum, int S) {
        if (opIdx == nums.length - 1) {
            if (subSum == S) {
                result[0]++;
            }
            return;
        }
        helper2(result, opIdx + 1, nums, subSum - nums[opIdx + 1], S);
        helper2(result, opIdx + 1, nums, subSum + nums[opIdx + 1], S);
    }

    public int findTargetSumWays(int[] nums, int S) {
        return helper(nums, 0, S);
    }

    /**
     * 看成背包问题。背包的递归写法也有模板，包的数量，剩余物资.
     * 也可以写成prefix,加剩下的符号数量（推荐）
     */
    private int helper(int[] nums, int start, int remain) {
        if (start == nums.length) {
            if (remain == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        return helper(nums, start + 1, remain + nums[start]) + helper(nums, start + 1, remain - nums[start]);
    }


    /**
     * 2-D DP
     * 有问题，对s小的可以，大点就放不下了,但是题目给了限制了
     * The sum of elements in the given array will not exceed 1000.
     * 由于没法表示负数，所以0-2000 代表S -1000 1000 .
     */
    public static int findTargetSumWays1(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];
        dp[nums.length - 1][1000 + nums[nums.length - 1]] = 1;
        //+= 是因为nums[nums.length - 1] 可能为0
        dp[nums.length - 1][1000 - nums[nums.length - 1]] += 1;
        int a = 0;
        for (int i = nums.length - 2; i >= 0; --i) {
            for (int j = -1000; j <= 1000; ++j) {
                int left = (j + 1000 - nums[i]) >= 0 ? dp[i + 1][j + 1000 - nums[i]] : 0;
                int right = (j + 1000 + nums[i]) <= 2000 ? dp[i + 1][j + 1000 + nums[i]] : 0;
                dp[i][j + 1000] = left + right;
            }
        }
        return S > 1000 ? 0 : dp[0][S + 1000];
    }

    /**
     * 1-D DP
     * 每一层只依赖他下一层,只需要两层狗了。2-D写的出，优化空间很简单
     * 注：2维空间优化，一般需要prev[] 保存之前的一层。有时候不需要
     */
    public static int findTargetSumWays2(int[] nums, int S) {
        int[] prev = new int[2001];
        prev[1000 + nums[nums.length - 1]] = 1;
        prev[1000 - nums[nums.length - 1]] += 1;

        for (int i = nums.length - 2; i >= 0; --i) {
            int[] cur = new int[2001];
            for (int j = -1000; j <= 1000; ++j) {
                int left = (j + 1000 - nums[i]) >= 0 ? prev[j + 1000 - nums[i]] : 0;
                int right = (j + 1000 + nums[i]) <= 2000 ? prev[j + 1000 + nums[i]] : 0;
                cur[j + 1000] = left + right;
            }
            prev = cur;
        }
        return S > 1000 ? 0 : prev[S + 1000];
    }

    public static void main(String[] args) {
        //int[] a = {1, 1, 1, 1, 1};
        int[] a = {6, 20, 22, 38, 11, 15, 22, 30, 0, 17, 34, 29, 7, 42, 46, 49, 30, 7, 14, 5};
        System.out.println(findTargetSumWays2(a, 28));
    }
}
