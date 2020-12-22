package com.leetcode.dp;

/**
 * 题意：
 * 字符串S是24个字母的无限循环，再给出一个字符串p，问p的unique substring 里有多少是S的substring
 * 暴力：一个一个去匹配。这样无法利用S的特性
 * 正确做法：把最后p的substring按最后一个字母划分，可以知道以字符c结尾的字符串的个数 等于 以其结尾的最长的字符串的长度
 * 例如 abcd bcd cd d 。
 * 所以现在问题怎么找所有的最长的substring? 这个问题O（N）就可以完成
 * 动态规划，类似第53题。不过每个dp值计算出来后顺便保存在charMap
 * 空间压缩略
 * https://www.cnblogs.com/grandyang/p/6143071.html
 *
 * @author Zhancong Huang
 * @date 22:11 2018/12/2
 */
public class _467 {
    public static int findSubstringInWraproundString(String p) {
        if (p == null || p.length() == 0) return 0;
        char[] ps = p.toCharArray();
        int[] charMap = new int[26];
        //dp[i]代表以ps[i]为底的最长连续字符串，要保存在charMap用于最后统计
        int[] dp = new int[p.length()];
        for (int i = 0; i < ps.length; i++) {
            if (i == 0) {
                //一开始忘记了，这个1也要加入charmap
                dp[0] = 1;
            } else {
                //不考虑S的循环特性
                //dp[i] = (ps[i] == ps[i - 1] + 1) ? dp[i - 1] + 1: 1;
                dp[i] = (ps[i] == ps[i - 1] + 1 || ps[i] == ps[i - 1] - 25) ? dp[i - 1] + 1 : 1;
            }
            charMap[ps[i] - 'a'] = Math.max(charMap[ps[i] - 'a'], dp[i]);
        }
        //统计
        int result = 0;
        for (int num : charMap) {
            result += num;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findSubstringInWraproundString("zabc"));
    }
}
