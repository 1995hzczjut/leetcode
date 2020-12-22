package com.leetcode.String;

/**
 * @author Zhancong Huang
 * @date 15:30 2020/5/13
 */
public class _10 {
    public boolean isMatch(String s, String p) {
        return match0(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    /**
     * 对比之前修改了指针越界提前处理的情况，二叉树题目中经常用到
     */
    private boolean match0(char[] str, int strIdx, char[] pattern, int patternIdx) {
        //同时走到结尾
        if (strIdx == str.length && patternIdx == pattern.length) {
            return true;
        }
        //patternIdx走到结尾，strIdx没有走到结尾
        if (patternIdx == pattern.length) {
            return false;
        }
        //strIdx走到结尾，patternIdx没有走到结尾。但要注意patternIdx可能指向最后，查看下一个会出现NPE
        if (strIdx == str.length) {
            //这种情况只有pattern都是a*b*c*这种才行，*全部代替0
            if (patternIdx + 1 < pattern.length && pattern[patternIdx + 1] == '*') {
                return match0(str, strIdx, pattern, patternIdx + 2);
            } else {
                return false;
            }
        }
        //strIdx，patternIdx都没有走到结尾。但要注意patternIdx可能指向最后，查看下一个会出现NPE
        if (patternIdx + 1 < pattern.length && pattern[patternIdx + 1] == '*') {
            if (str[strIdx] == pattern[patternIdx] || pattern[patternIdx] == '.') {
                return match0(str, strIdx + 1, pattern, patternIdx + 2)//*当作一个
                        || match0(str, strIdx, pattern, patternIdx + 2)//*当作0个，即不工作
                        || match0(str, strIdx + 1, pattern, patternIdx);//*当作N个用，即还能继续工作
            } else {
                //第一个字符不等，*只能当作0次
                return match0(str, strIdx, pattern, patternIdx + 2);
            }
        } else {
            //patternIdx后面是字符或者是空
            if (pattern[patternIdx] == str[strIdx] || (pattern[patternIdx] == '.')) {
                return match0(str, strIdx + 1, pattern, patternIdx + 1);
            } else {
                return false;
            }
        }
    }

}
