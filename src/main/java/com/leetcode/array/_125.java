package com.leetcode.array;

/**
 * @author Zhancong Huang
 * @date 13:39 2019/1/9
 */
public class _125 {
    /**
     * 恶心在有特殊字符和空格,Character API
     */
    public boolean isPalindrome(String s) {
        if(s == null) return true;
        int head = 0;
        int tail = s.length() - 1;
        while (head < tail){
            char cHead = s.toCharArray()[head];
            char cTail = s.toCharArray()[tail];
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if(!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }
        return true;
    }
}
