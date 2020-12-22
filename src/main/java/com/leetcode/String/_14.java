package com.leetcode.String;

import java.util.Arrays;

/**
 * 先排序很巧妙，不排序只能一个一个字符看
 * 原数组按字典序排序，common prefix肯定都有的
 * @author Zhancong Huang
 * @date 21:27 2019/1/7
 */
public class   _14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        Arrays.sort(strs);
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();
        int idx = 0;
        //注意越界
        while (idx < first.length && idx < last.length && first[idx] == last[idx]){
            idx++;
        }
        return strs[0].substring(0, idx);
    }


    public static void main(String[] args) {
        String[] strings = new String[]{"","a","ab"};
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));
    }

}
