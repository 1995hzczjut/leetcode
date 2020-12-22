package com.leetcode.array;

/**
 * @author Zhancong Huang
 * @date 23:11 2019/1/7
 */
public class _28 {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)){
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            //注意API直接指定offset
            if(haystack.startsWith(needle,i)){
                return i;
            }
        }
        return -1;
    }
}
