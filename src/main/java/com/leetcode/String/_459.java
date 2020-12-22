package com.leetcode.String;

public class _459 {

    /**
     * ��Ŀ��s �Ƿ���abcabcabc������ѭ���ַ������ɵġ�
     * ��0��ʼ���ѡsub��Ȼ�󿴶��sub�ܷ����s
     * ��һ�����Բ�����String.startwith��
     */
    public static boolean repeatedSubstringPattern1(String s) {
        if (s.length() <= 1) return false;
        for (int i = 1; i <= s.length() / 2; ++i) {
            if (s.length() % i == 0) {
                String sub = s.substring(0, i);
                if (dfs(s, sub, i)) return true;
            }
        }
        return false;
    }

    public static boolean dfs(String s, String sub, int i) {
        if (i == s.length()) return true;
        if (!s.startsWith(sub, i)) return false;
        return dfs(s, sub, i + sub.length());
    }


    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern1("abcabc"));
    }

}
