package com.leetcode.dp;

/**
 * 不符合滑动窗口特点
 *
 * @author Zhancong Huang
 * @date 19:30 2019/8/16
 */
public class _795 {

    public static int numSubarrayBoundedMax1(int[] A, int L, int R) {
        int[] dp = new int[A.length];
        int res = 0, prev = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > R) {
                dp[i] = 0;
                prev = i;
            } else if (A[i] < L) {
                dp[i] = i == 0 ? 0 : dp[i - 1];
            } else {
                //原始写法，看起来对的哪里错了？
                //dp[i] = (i == 0 ? 0 : dp[i - 1]) + 1;
                //如果dp[i-1]>0，自然是对的
                //但是dp[i - 1] == 0 并不代表dp[i-1]只有A[i]一种情况，例如前面一段都<L,那么新加入的A[i]加上
                //这一段，会重新合法，这也是滑动窗口不能用的原因。
                //所以这种情况下，dp[i]能找到最长的段的左边是 离i最近的大于R的下一个
                dp[i] = i - prev;
            }
            res += dp[i];
        }
        return res;
    }


    public static void main(String[] args) {
//        System.out.println(numSubarrayBoundedMax1(new int[]{73, 55, 36, 5, 55, 14, 9, 7, 72, 52}, 32, 69));
    }
}
