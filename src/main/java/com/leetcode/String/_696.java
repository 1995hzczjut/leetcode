package com.leetcode.String;

import java.util.ArrayList;
import java.util.List;

public class _696 {

    /**
     * ���кϷ������ֿ��Կ������ߣ�ÿһ�鶼��0��1����������ȡ�˼����ô�����ģ�
     * 00 1111 00 11.
     * �Ȱ������Ƭ��Ȼ��ÿ��������������������Ƚ����Ρ�
     * ����00 1111���ܲ�������������� 0011 01.������̵��Ǹ��ĳ���
     */
    public static int countBinarySubstrings(String s) {
        List<Integer> list = new ArrayList<>();
        int num = 1;
        //������ÿ��λ�ô�����֮ǰ�Ľ����Ҫ��ѭ���󵥶�����һ�¡���Ϊ���һ��û�˰������ˡ����Ըġ�
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                num++;
            } else {
                list.add(num);
                num = 1;
            }
        }
        list.add(num);
        int res = 0;
        for (int i = 0; i < list.size() - 1; ++i) {
            res += Math.min(list.get(i), list.get(i + 1));
        }
        return res;
    }

    /**
     * /(n)  O(1)
     * �Ż��ռ䡣����DP��ķ���
     */
    public static int countBinarySubstrings1(String s) {
        int pre = 0;
        int num = 1;
        int res = 0;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                num++;
            } else {
                res += Math.min(pre, num);
                pre = num;
                num = 1;
            }
        }
        res += Math.min(pre, num);
        return res;
    }

    public static void main(String[] args) {
        countBinarySubstrings("11001100");
    }

}
