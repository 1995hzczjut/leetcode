package com.leetcode.String;

/**
 * 思路非常厉害
 *
 * @author Zhancong Huang
 * @date 18:29 2019/2/19
 */
public class _680 {

    public boolean validPalindrome(String s) {
        if (s.length() < 2) return true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                //要想最后构成回文，ij必然只能留其1
                //且被删掉后，剩下的部分必然是回文才行
                return helper(s, i + 1, j) || helper(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean helper(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

}
