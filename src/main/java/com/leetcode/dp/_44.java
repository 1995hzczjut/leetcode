package com.leetcode.dp;

/**
 * LCS类型DP。
 * 必须明白有一个或运算的简化：
 * A||B，B成立A一定成立，这种情况下简化为A||B=A
 * 简单证明
 * A    B     A\\b
 * T    T      T
 * T    F      T
 * F    T     不存在
 * F    F      F
 * 只要A为T，结果为T，A为F，结果为F
 * 这个优化不知道写不出来符合时间复杂度的解
 *
 * @author Zhancong Huang
 * @date 15:46 2020/5/13
 */
public class _44 {

    /**
     * 大致做法跟LCS类似， dp[i][j] : 表示 s 的前 i 个字符和 p 的前 j 个字符是否匹配
     * 转移的时候看s,p最后个字符，难在p最后是个*
     * 可以看做吃掉0个或者任意多个，难在任意多个需要查看dp[i-1][j]||dp[i-2][j]||dp[i-3][j]...
     * 这样复杂度肯定不行，但是我们可以发现由于p最后是个*，dp[i-2][j]|成立，dp[i-1][j]必定成立
     * 所以根据最上面注释，可以优化为dp[i-1][j]
     */
    public boolean isMatch1(String s, String p) {
        int m = s.length();
        int n = p.length();

        // 状态 dp[i][j] : 表示 s 的前 i 个字符和 p 的前 j 个字符是否匹配
        boolean[][] dp = new boolean[m + 1][n + 1];

        // 初始化
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
        }

        // 状态转移
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        // 返回结果
        return dp[m][n];

    }

}
