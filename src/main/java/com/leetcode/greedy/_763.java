package com.leetcode.greedy;

import java.util.*;

/**
 * @author Zhancong Huang
 * @date 22:24 2019/3/19
 */
public class _763 {

    /**
     * ̰��+ ˫ָ��
     * ���⣺��һ���ַ�����Ϊ�����ܶ��parts,��֤һ����ĸ��������һ��part�
     * Ҳ����˵�������ҵõ���һ��part�����������һ��a,������a��Ȼ���������part��
     * ����֪�� �����part�Ľ�����ĸ���Ǹ���ĸ���ֵ����λ�ã���������part�ﻹ�и���ĸ����ì����
     * ����һ��part�������ĸ����Ȼ�Ǹ���ĸ�����ֵ�λ�á�
     * ˼�������Ѿ�����O��n���Ĵ��ۣ��õ�һ��MAP��K=��ĸ��V=���ֵ�����λ�ã���ôȷ���ĸ�����Ӧ�÷ָ�ĵ㣿
     * ����Ŀ�������ӣ��������Կ�������
     * ababcbacadefegdehijhklij ������a�����𣬲�����a�����ֵ�λ�á�����ֵ������
     * b�����ֵĵط������𣬲����ԣ����ص㡿���ˣ���Ϊǰ����ֹ���a�����λ�û���b�ĺ���
     * ͬ��c�����𣬲����ԣ�ǰ��b,a�����ֵ�λ�ö���c���棨һ��Ҫ�뵽�����õ���a����Ϊa����������
     * �õ����ۣ�����Ϊ�е����������Ȼ�������������ĸ�����λ��ֵ&&ǰ����ֹ���������ĸ�����������С�ڸ���ĸ������
     */
    public static List<Integer> partitionLabels(String S) {
        Map<Character, Integer> map = new HashMap<>(256);
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), i);
        }
        List<Integer> res = new LinkedList<>();
        int maxCnt = 0;
        int left = 0;
        for (int i = 0; i < S.length(); i++) {
            if (i == map.get(S.charAt(i)) && maxCnt <= i){
                res.add(i - left + 1);
                left = i + 1;
            }
            maxCnt = Math.max(maxCnt, map.get(S.charAt(i)));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij").toString());
    }

}
