package com.leetcode.greedy;

import java.util.*;

/**
 * @author Zhancong Huang
 * @date 22:24 2019/3/19
 */
public class _763 {

    /**
     * 贪心+ 双指针
     * 题意：把一个字符串分为尽可能多个parts,保证一个字母最多出现再一个part里。
     * 也就是说，假设我得到了一个part，里面包含了一个a,则所有a必然出现在这个part里
     * 可以知道 假设该part的结束字母不是该字母出现的最后位置，后面其他part里还有该字母，就矛盾了
     * 所以一个part的最后字母，必然是该字母最后出现的位置。
     * 思考假设已经付出O（n）的代价，得到一个MAP，K=字母，V=出现的最后的位置，怎么确定哪个才是应该分割的点？
     * 看题目给的例子，具体试试看！！！
     * ababcbacadefegdehijhklij ，遍历a可以吗，不可以a最后出现的位置》遍历值。。。
     * b最后出现的地方可以吗，不可以，【重点】来了，因为前面出现过的a的最后位置还在b的后面
     * 同理c可以吗，不可以，前面b,a最后出现的位置都在c后面（一定要想到起作用的是a，因为a最后索引最大）
     * 得到结论：能作为切点的索引，必然是这个索引的字母的最后位置值&&前面出现过的所有字母的最后索引都小于该字母的索引
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
