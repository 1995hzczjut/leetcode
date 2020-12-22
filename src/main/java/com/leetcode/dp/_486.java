package com.leetcode.dp;

/**
 * 子问题想清楚，这里子问题返回boolean显然不行
 *
 * @author Zhancong Huang
 * @date 22:07 2019/3/15
 */
public class _486 {


    public static boolean predictTheWinnerRecursive(int[] nums) {
        return calculateDiff(0, nums.length - 1, nums) >= 0;
    }

    /**
     * 思考子问题？
     * 第一次：A先拿第一个，B拿最后一个。看减小后的数组上A能不能赢。发现这样不对，如果子问题上A赢的少了，那么最后b还是可能赢
     * 所以子问题一定返回差值，即先拿一方比后拿一方 最后多出来的值
     * 这题的递归终止条件也值得分析：假设数组下标是i-j = 0-10
     * 那么递归后看的是1-10或0-9。很熟悉，回文问题的递归写法也是这样的
     * 所以递归终止条件就是i==j,不会出现越界。
     */
    private static int calculateDiff(int start, int end, int[] nums){
        if (start == end){
            //只有一个数，先拿的人拿完后拿的没的选了
            return nums[start];
        }
        //重点：A先拿最左边的。右边的递归结果代表在start + 1, end 上，B先拿A后拿，最后B比A多多少
        int diffWithStart = nums[start] - calculateDiff(start + 1, end, nums);
        int diffWithEnd = nums[end] - calculateDiff(start, end - 1, nums);
        return Math.max(diffWithEnd, diffWithStart);
    }


    /**
     * 递归——》DP。 回文字符串那个写法
     * 空间优化略。只需要一层就够了
     */
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) { dp[i][i] = nums[i]; }
        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }

    public static void main(String[] args) {

    }

}
