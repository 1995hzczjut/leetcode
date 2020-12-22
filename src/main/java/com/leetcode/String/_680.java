package com.leetcode.String;

/**
 * ˼·�ǳ�����
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
                //Ҫ����󹹳ɻ��ģ�ij��Ȼֻ������1
                //�ұ�ɾ����ʣ�µĲ��ֱ�Ȼ�ǻ��Ĳ���
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
