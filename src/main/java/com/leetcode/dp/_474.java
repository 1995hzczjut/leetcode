package com.leetcode.dp;

/**
 * https://leetcode.com/problems/ones-and-zeroes/discuss/95807/0-1-knapsack-detailed-explanation.
 * 明显01背包问题，找最多能分到几个包里面.与416不同，416较简单，只需要知道能不能即可。
 *
 * @author Zhancong Huang
 * @date 22:25 2018/12/2
 * @see _416
 */
public class _474 {

    /**
     * 空间压缩：不需要i了。dp[j][k] = Math.max(dp[j][k], dp[j-nums[0]][k-nums[1]]+1);
     *
     * @param strs 包
     * @param m    0的个数
     * @param n    1的个数。m,n组成抽象物资
     */
    public int findMaxForm(String[] strs, int m, int n) {
        //代表只使用前几个包，现有物资最大能分摊到几个包
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 0; i <= strs.length; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (i == 0 || k == 0 && j == 0) {
                        //初始状态。只用前0个包或没有0，1了
                        dp[i][j][k] = 0;
                    } else {
                        int[] nums = calculate(strs[i - 1]);
                        dp[i][j][k] = Math.max(dp[i - 1][j][k]
                                , j - nums[0] >= 0 && k - nums[1] >= 0 ? dp[i - 1][j - nums[0]][k - nums[1]] + 1 : 0);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    private int[] calculate(String s) {
        int[] res = new int[2];
        if (s == null || s.length() == 0) {
            return res;
        }
        int numOfZero = 0, numOfOne = 0;
        for (char c : s.toCharArray()) {
            if (c - '0' == 0) {
                res[0]++;
            } else {
                res[1]++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _474().findMaxForm(new String[]{"0", "00", "1"}, 1, 0));
    }
}
