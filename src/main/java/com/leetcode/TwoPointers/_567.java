package com.leetcode.TwoPointers;

/**
 * @author Zhancong Huang
 * @date 20:22 2019/5/4
 */
public class _567 {

    /**
     * ��Ŀ������ s1 �ǲ��� s2��һ��subString �� permutation.
     * ������s2�ϻ������ڣ����ڴ�С��s1�Ĵ�С��Ȼ��Ƚϱ���ж�A�Ƿ���Bpermutation�����⣨������charMap��
     * ע������Խ��
     */
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        char[] char_s1 = new char[26];
        char[] char_s2 = new char[26];
        for (int i = 0; i < s1.length(); ++i) {
            char_s1[s1.charAt(i) - 'a']++;
            char_s2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= s2.length() - s1.length(); ++i) {
            if (match(char_s1, char_s2)) return true;
            char_s2[s2.charAt(i) - 'a']--;
            if (i + s1.length() > s2.length() - 1) break;
            //����С��Խ�硣
            char_s2[s2.charAt(i + s1.length()) - 'a']++;
        }
        return false;
    }

    public static boolean match(char[] chars1, char[] chars2) {
        for (int j = 0; j < chars1.length; ++j) {
            if (chars1[j] != chars2[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidlboaoaoo"));
    }

}
