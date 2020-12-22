package com.leetcode.dp;


import java.util.List;

/**
 * @author Zhancong Huang
 * @date 14:28 2019/10/1
 */
public class _139 {

    /**
     * dp[i]代表前i个字符，套模板，难点在于把字符串放进包里应该是尾部放进去
     */
    public boolean wordBreak1(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        //没有物资通常代表能放下
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            String subString = s.substring(0, i);
            for (int j = 0; j < wordDict.size(); j++) {
                //判断能不能丢进这第j个包.之前代表物资得话直接比较大小就好了，这里如果把字符串前面丢进包里
                //那么dp[i]转移写不下去了，所以只能把尾部丢进去。所以先用endwith判断，不行跳过
                if(!subString.endsWith(wordDict.get(j))) continue;
                //这里只要能放下就不用继续判断了
                if (dp[i] = dp[i - wordDict.get(j).length()]) break;
            }
        }
        return dp[s.length()];
    }

}
