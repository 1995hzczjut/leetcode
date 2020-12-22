package com.leetcode.dp;

import java.util.*;

/**
 * 392里稍微改一下就可以了，背后的海量数据处理的思路很重要。
 * 如果是匹配substring，改成前缀树
 *
 * @author Zhancong Huang
 * @date 20:47 2019/1/31
 */
public class _792 {
    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, List<Integer>> map = init(S);
        int res = 0;
        for (String word : words) {
            if (check(map, word)) res++;
        }
        return res;
    }

    private boolean check(Map<Character, List<Integer>> map, String word) {
        //prev代表前一个字母在map里对应的List的最小值.第一个字母时，值为-1
        int prev = -1, cur = -1;
        for (int i = 0; i < word.length(); i++) {
            if ((cur = findFirstLarger(map.get(word.charAt(i)), prev)) == -1) return false;
            prev = map.get(word.charAt(i)).get(cur);
        }
        return true;
    }

    /**
     * 找第一个大于target的，找不到返回-1。等号的选择以单个数字为特例
     * 两分一定记得处理找不到的情况
     */
    private int findFirstLarger(List<Integer> list, int target) {
        if (list == null) return -1;
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        left = left == list.size() ? -1 : left;
        return left;
    }

    private Map<Character, List<Integer>> init(String s) {
        Map<Character, List<Integer>> map = new HashMap<>(32);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.putIfAbsent(c, new LinkedList<>());
            map.get(c).add(i);
        }
        return map;
    }


    public static void main(String[] args) {
        String S = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println(new _792().numMatchingSubseq(S, words));
    }
}
