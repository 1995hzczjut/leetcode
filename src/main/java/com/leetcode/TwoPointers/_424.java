package com.leetcode.TwoPointers;

/**
 * 首先思考没有的k的限制，对于例如"aaabbc"这样的字符串最少需要改动几次使得字符串所有字符一致？
 * 需要 str.len - 字符出现频率的最大值
 * 现在有了k次限制，要求最长的子字符串，考虑用滑动窗口。
 * 滑动的方法之前见到过了（LC209，713），现有窗口合法，向右探测，如果继续合法，OK；不合法，不断减去右边界，直到合法，然后继续。
 * ========
 * subArray最值的问题要么DP，要么滑动窗口
 *
 * @author Zhancong Huang
 * @date 19:31 2019/5/4
 */
public class _424 {

    public static int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        //窗口左边，右边每次都是新的
        int left = 0, res = 0;
        //窗口内字符频率统计
        int[] charMap = new int[26];
        //窗口内出现频率最大的值。每次窗口变了charMap，maxCnt一定要动态更新
        int maxCnt = 0;
        for (int right = 0; right < s.length(); right++) {
            //窗口右边界扩展了，maxCnt也要更新
            maxCnt = Math.max(maxCnt, ++charMap[s.charAt(right) - 'A']);
            //查看向右扩展后的新窗口是否合法，不合法调整至合法,合法的标准看类注释
            while (right - left + 1 - maxCnt > k) {
                //左边界收缩,注意maxCnt，charMap要动。
                --charMap[s.charAt(left++) - 'A'];
                //charMap变了，maxCnt可能要变，没有好的办法，只能遍历所有charMap选一个最大值
                for (int i = 0; i < 25; i++) {
                    maxCnt = Math.max(maxCnt, charMap[i]);
                }
            }
            //窗口已经合法
            //System.out.println(left + " ; " + right);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 1));
    }
}
